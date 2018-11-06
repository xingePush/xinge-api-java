package com.tencent.xinge.device.tag;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import org.junit.Test;

import java.util.ArrayList;
import com.tencent.xinge.device.tag.DeviceTagRequest;

//tag测试
public class DelAllTagToSingleToken extends BaseXgTest {

    @Test
    public void testDelAllTagToSingleToken() {
        //5删除所有标签，对单个token而言

        ArrayList<String> tokenList = new ArrayList<String>();
        tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");

        DeviceTagRequest deviceTagRequest = new DeviceTagRequest();
        deviceTagRequest.setOperator_type(OperatorType.DELE_ALL_TAGS_SINGLE.getType());
        deviceTagRequest.setPlatform(Platform.android);
        deviceTagRequest.setToken_list(tokenList);

        System.out.println(deviceTagRequest.toString());
        System.out.println(xingeAndroid.deviceTag(deviceTagRequest.toString()));


    }


}
