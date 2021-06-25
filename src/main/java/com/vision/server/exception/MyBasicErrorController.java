package com.vision.server.exception;

import com.vision.server.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hanqq on 2021/6/8
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
public class MyBasicErrorController extends AbstractErrorController {

    public MyBasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

//    @Value("${server.error.path}")
//    private String myPath;
//
//    private final ErrorProperties errorProperties;
//
//    private ErrorAttributes mErrorAttributes;
//
//    public MyBasicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
//        super(errorAttributes);
//        this.errorProperties = serverProperties.getError();
//        this.mErrorAttributes = errorAttributes;
//    }
//
//    //@RequestMapping(value = "/error")
//    @RequestMapping("${server.error.path}") //从properties文件中获取
//    @ResponseBody
//    public Result<Object> error(HttpServletRequest request) throws Throwable {
//        System.out.println("myPath = " + myPath);
//
//        //发生错误之后直接将异常抛出去，异常会到统一异常处理器中处理
//        WebRequest webRequest = new ServletWebRequest(request);
//        Throwable throwable = this.mErrorAttributes.getError(webRequest).getCause();
//        throw throwable;
//        /*UserException ex;
//        if(throwable instanceof UserException){
//            ex = (UserException) throwable;
//            throw ex;
//        }else{
//            throw throwable;
//        }*/
//        /*HttpStatus status = getStatus(request);
//        if (status == HttpStatus.NO_CONTENT) {
//            return ResultUtils.error(status.value(), status.name());
//        }
//        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
//        return ResultUtils.error((Integer) body.get("status"), (String)body.get("message"));*/
//    }
//
//    /**
//     * Determine if the stacktrace attribute should be included.
//     *
//     * @param request  the source request
//     * @param produces the media type produced (or {@code MediaType.ALL})
//     * @return if the stacktrace attribute should be included
//     */
//    private boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
//        ErrorProperties.IncludeAttribute include = getErrorProperties().getIncludeStacktrace();
//        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
//            return true;
//        }
//        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
//            return getTraceParameter(request);
//        }
//        return false;
//    }
//
//    /**
//     * Provide access to the error properties.
//     *
//     * @return the error properties
//     */
//    private ErrorProperties getErrorProperties() {
//        return this.errorProperties;
//    }
//
//
//    /**
//     * Returns the path of the error page.
//     *
//     * @return the error path
//     */
//    @Override
//    public String getErrorPath() {
//        return this.errorProperties.getPath();
//    }
}
