package com.tencent.xinge.device.tag;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import com.tencent.xinge.device.tag.DeviceTagRequest;

//tag测试
public class AddSingleTagToSingleToken extends BaseXgTest {

    @Test
    public void testAddSingleTagToSingleToken() {
        //1增加单个tag，对单个token而言

        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");

        ArrayList<String> tagList = new ArrayList<>();
        tagList.add("singleTag");

        DeviceTagRequest deviceTagRequest = new DeviceTagRequest();
        deviceTagRequest.setOperator_type(OperatorType.ADD_SINGLE_TAG_SINGLE.getType());
        deviceTagRequest.setPlatform(Platform.android);
        deviceTagRequest.setToken_list(tokenList);
        deviceTagRequest.setTag_list(tagList);

        System.out.println(deviceTagRequest.toString());
        System.out.println(xingeAndroid.deviceTag(deviceTagRequest.toString()));
    }

}
