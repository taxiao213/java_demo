package com.vision.server.reponse;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * 将返回的 null 值去掉 替换为 “”
 * {
 * "resCode": 1000,
 * "resMsg": "成功",
 * "data": null
 * }
 * Created by hanqq on 2021/6/9
 * Email:yin13753884368@163.com
 * CSDN:http://blog.csdn.net/yin13753884368/article
 * Github:https://github.com/taxiao213
 */
@Configuration
public class JacksonConfig {
    //Include.Include.ALWAYS 默认
    //Include.NON_DEFAULT    属性为默认值不序列化
    //Include.NON_EMPTY       属性为 空（""） 或者为 NULL 都不序列化
    //Include.NON_NULL       属性为NULL 不序列化

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化，属性为NULL 不序列化
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                if (o == null) {
                    // writeObject(new JSONObject()) 返回 {}
//                    jsonGenerator.writeObject(new JSONObject());
                    jsonGenerator.writeString("");
                }
            }
        });
        return objectMapper;
    }
}
