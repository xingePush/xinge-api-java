package com.tencent.xinge.push.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Created by bulezeng on 2018/11/6.
 */
public class RequestParseTest {

    @Test
    public void testParseRequestMsg(){
        String requestMsg = "{\"audience_type\":\"account_list\",\"platform\":\"ios\",\"message_type\":\"notify\",\"message\":{\"title\":\"testPushAccountListIOS\",\"content\":\"testPushAccountListIOS from Java API\",\"accept_time\":null,\"xgMediaResources\":null,\"android\":null,\"ios\":{\"aps\":{\"alert\":{\"title\":\"alert from Java API\",\"subtitle\":null,\"body\":\" body alert from Java API\",\"launch_image\":null,\"title_loc_key\":null,\"title_loc_args\":null,\"subtitle_loc_key\":null,\"subtitle_loc_args\":null,\"loc_key\":null,\"loc_args\":null},\"badge_type\":8,\"sound\":null,\"content_available\":0,\"category\":null,\"thread_id\":null,\"mutable_content\":0},\"custom\":null,\"xg\":null}},\"expire_time\":259200,\"send_time\":\"1111111\",\"multi_pkg\":false,\"loop_times\":0,\"loop_interval\":0,\"environment\":\"dev\",\"stat_tag\":\"test\",\"seq\":0,\"tag_list\":null,\"account_list\":[\"xg_account\",\"xg_account1\"],\"account_type\":0,\"token_list\":[],\"push_id\":\"0\"}";
        ObjectMapper objectMapper = new ObjectMapper();
    }
}
