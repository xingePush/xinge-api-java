package com.tencent.xinge.bean;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.*;

public class BrowserTest {

    @Test
    public void testBrowser() {

        Browser browser = new Browser();
        browser.setConfirm(1);
        browser.setUrl("xxxx");

        ObjectMapper mapper = new ObjectMapper();


        String repoStr = null;
        try {
            repoStr = mapper.writeValueAsString(browser);

        } catch (Exception e) {
           fail();
        }

        assertEquals("{\"url\":\"xxxx\",\"confirm\":1}", repoStr);

    }
}