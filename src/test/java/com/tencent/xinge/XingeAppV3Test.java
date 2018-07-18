package com.tencent.xinge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tencent.xinge.bean.ClickAction;
import com.tencent.xinge.bean.MessageAndroid;
import com.tencent.xinge.bean.Style;
import com.tencent.xinge.bean.TimeInterval;
import com.tencent.xinge.request.PushAppRequest;

public class XingeAppV3Test {

    private XingeAppV3 xinge = null;
    private String appId = "a5b5f071ff77a";
    private String secretKey = "ea512eb7704d5fb5a6a937cafa70e771";

    @Before
    public void init() {
        xinge = new XingeAppV3(appId, secretKey);
    }

    @Test
    public void testPushAppAndroid() {

        MessageAndroid androidMessage = new MessageAndroid();
        androidMessage.setType(1);
        androidMessage.setTitle("xxx");
        androidMessage.setContent("xxxxxxxxx");
        TimeInterval acceptTime1 = new TimeInterval(13, 00, 14, 00);
        TimeInterval acceptTime2 = new TimeInterval(0, 00, 9, 00);
        androidMessage.addAcceptTime(acceptTime1);
        androidMessage.addAcceptTime(acceptTime2);

        ClickAction action = new ClickAction();
        action.setActionType(0);
        action.setActivity("xxx");
        action.setIntent("xxx");
        action.setActionType(0);
        androidMessage.setAction(action);

        Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
        androidMessage.setStyle(style);

        PushAppRequest pushAppRequest = new PushAppRequest("all", "android", "notify", androidMessage);
        pushAppRequest.setSeq(123);
        pushAppRequest.setEnvironment("product");

        String jsonStr = "{\"audience_type\":\"all\",\"message_type\":\"notify\"," +
                "\"message\":{\"clearable\":1,\"ring\":1,\"vibrate\":1,\"title\":\"xxx\",\"content\":\"xxxxxxxxx\"," +
                "\"builder_id\":0,\"action\":{\"activity\":\"xxx\",\"action_type\":0," +
                "\"browser\":{\"confirm\":0,\"url\":\"\"}," +
                "\"intent\":\"xxx\",\"aty_attr\":{\"pf\":0,\"if\":0}},\"style_id\":1,\"custom_content\":{}," +
                "\"accept_time\":[{\"start\":{\"min\":\"0\",\"hour\":\"13\"},\"end\":{\"min\":\"0\",\"hour\":\"14\"}}," +
                "{\"start\":{\"min\":\"0\",\"hour\":\"0\"},\"end\":{\"min\":\"0\",\"hour\":\"9\"}}]," +
                "\"lights\":1,\"n_id\":0,\"icon_type\":0},\"platform\":\"android\"}";

        Assert.assertEquals(jsonStr, pushAppRequest.toString());
//		System.out.println(xinge.pushApp(pushAppRequest.toString()));
    }

}
