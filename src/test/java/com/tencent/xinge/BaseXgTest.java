package com.tencent.xinge;

import org.junit.Before;

public class BaseXgTest {

    public XingeApp xingeAndroid = null;
    public XingeApp xingeIOS = null;
    private String appIdAndroid = "d617a675b62d0";
    private String secretKeyAndroid = "9e05364c6d56da943783e61da091e8e5";
    private String appIdIOS = "f248587cdc955";
    private String secretKeyIOS = "c6bdff7314d4367c18bacc4d30c95dcf";


    @Before
    public void init() {
        xingeAndroid = new XingeApp(appIdAndroid, secretKeyAndroid);
        xingeIOS = new XingeApp(appIdIOS, secretKeyIOS);
    }
}
