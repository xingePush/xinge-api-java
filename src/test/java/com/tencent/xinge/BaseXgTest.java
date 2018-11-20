package com.tencent.xinge;

import org.junit.Before;

public class BaseXgTest {

    public XingeApp xingeAndroid = null;
    public XingeApp xingeIOS = null;
    private String appIdAndroid = "d617a675b62d0";
    private String secretKeyAndroid = "b5da4c1faf95ee9409cd33792b02f5d2";
    private String appIdIOS = "f248587cdc955";
    private String secretKeyIOS = "c6bdff7314d4367c18bacc4d30c95dcf";


    @Before
    public void init() {
        xingeAndroid = new XingeApp.Builder()
                .appId(appIdAndroid)
                .secretKey(secretKeyAndroid)
                .build();
        xingeIOS = new XingeApp.Builder()
                .appId(appIdIOS)
                .secretKey(secretKeyIOS)
                .build();
    }
}
