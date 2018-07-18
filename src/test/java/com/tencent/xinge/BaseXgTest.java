package com.tencent.xinge;

        import org.junit.Before;

public class BaseXgTest {

    private XingeApp xinge = null;
    private String appId = "a5b5f071ff77a";
    private String secretKey = "ea512eb7704d5fb5a6a937cafa70e771";

    @Before
    public void init() {
        xinge = new XingeApp(appId, secretKey);
    }
}
