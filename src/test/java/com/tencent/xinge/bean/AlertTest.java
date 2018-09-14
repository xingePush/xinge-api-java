package com.tencent.xinge.bean;

import com.tencent.xinge.bean.ios.Alert;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class AlertTest {

    @Test
    public void testAlert() {

        Alert alert = new Alert();
        alert.setBody("alert-body");
        alert.setTitle("alert-title");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String rest =  mapper.writeValueAsString(alert);
            System.out.println(rest);

        } catch (Exception e) {

        }
    }
}