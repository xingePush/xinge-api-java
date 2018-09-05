package com.tencent.xinge.device.tag;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import com.tencent.xinge.device.tag.DeviceTagRequest;

//tag测试
public class DelSingleTagToMultToken extends BaseXgTest {

    @Test
    public void testDelSingleTagToMultToken() {
        //8为多个token删除单个tag

        ArrayList<String> tokenList = new ArrayList<String>();
        tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");
        tokenList.add("22a3bad291f1a8028d0468ecc00eb7f3818b859b7ec3a0f8b8f584a22d938cf2");

        ArrayList<String> tagList = new ArrayList<String>();
        tagList.add("multTagX");

        DeviceTagRequest deviceTagRequest = new DeviceTagRequest();
        deviceTagRequest.setOperator_type(OperatorType.DELE_SINGLE_TAG_MULT.getType());
        deviceTagRequest.setPlatform(Platform.android);
        deviceTagRequest.setToken_list(tokenList);
        deviceTagRequest.setTag_list(tagList);

        System.out.println(deviceTagRequest.toString());
        System.out.println(xingeAndroid.deviceTag(deviceTagRequest.toString()));

    }


}
