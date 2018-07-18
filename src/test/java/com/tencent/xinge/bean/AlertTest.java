package com.tencent.xinge.bean;

import jdk.nashorn.internal.runtime.ECMAException;
import netscape.javascript.JSObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

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