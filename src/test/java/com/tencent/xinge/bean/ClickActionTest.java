package com.tencent.xinge.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClickActionTest {

    @Test
    public void testClickAction() {
        ClickAction action = new ClickAction();
        action.setAction_type(1);
        action.setActivity("****");
        action.setIntent("***");

        Browser browser = new Browser();
        browser.setUrl("***");
        browser.setConfirm(1);
        action.setBrowser(browser);

        action.setAty_attr(new AtyAttr());

        ObjectMapper mapper = new ObjectMapper();


        String repoStr = null;
        try {
            repoStr = mapper.writeValueAsString(action);

        } catch (Exception e) {
            fail();
        }

        System.out.println(repoStr);
    }
}