package com.vision.server.reponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vision.server.model.Result;
import com.vision.server.model.ResultEnum;
import com.vision.server.module.feedback.dao.IFeedBackDao;
import com.vision.server.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 统一处理返回结果的切面，避免每个controller方法里面都要调用ResultUtils.success()这句话
 * 统一在这个切面里面调用
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof Result) { //发生异常之后，异常处理器里面返回的已经是Result了
            return body;
        } else if (body instanceof String) { //String属于特殊情况，需要单独处理，否则会报错
            try {
                return objectMapper.writeValueAsString(ResultUtils.success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResultUtils.error(ResultEnum.UNKNOWN_ERROR.getResCode(), e.getMessage());
            }
        } else if (body instanceof LinkedHashMap) {
            int status = (int) ((LinkedHashMap) body).get("status");
            if (status != 200) {
                return ResultUtils.error(ResultEnum.NO_API_ERROR.getResCode(), ResultEnum.NO_API_ERROR.getResMsg());
            }
        }
        return ResultUtils.success(body);
    }
}
