package com.tencent.xinge.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Administrator on 2018/11/6.
 */
public class EnumSerializer<T> extends JsonSerializer{
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(o instanceof  Enum){
            jsonGenerator.writeString(String.valueOf(o));
        }
    }

    public static void main(String[] args){
        System.out.println(String.valueOf(Environment.product));
    }
}
