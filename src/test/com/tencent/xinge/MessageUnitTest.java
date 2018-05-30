package com.tencent.xinge;

import org.junit.Test;
import junit.framework.TestCase;

public class MessageUnitTest extends TestCase {

  @Test
  public void testAcceptTimeToJson() {
    Message m = new Message();
    TimeInterval acceptTime1 = new TimeInterval(1, 2, 3, 4);
    TimeInterval acceptTime2 = new TimeInterval(5, 6, 7, 8);
    m.addAcceptTime(acceptTime1);
    m.addAcceptTime(acceptTime2);
    String except =
        "[{\"start\":{\"min\":\"2\",\"hour\":\"1\"},\"end\":{\"min\":\"4\",\"hour\":\"3\"}},{\"start\":{\"min\":\"6\",\"hour\":\"5\"},\"end\":{\"min\":\"8\",\"hour\":\"7\"}}]";
    assertEquals(except, m.acceptTimeToJson());
  }

  @Test
  public void testIsValid() {
    Message m = new Message();
    assertEquals(0, m.getType());
    assertFalse(m.isValid());
    m.setType(Message.TYPE_MESSAGE);
    assertTrue(m.isValid());
    m.setSendTime("abc");
    assertFalse(m.isValid());
    m.setSendTime("2013-12-25 11:49:00");
    assertTrue(m.isValid());
  }

  @Test
  public void testToJson() {
    Message m = new Message();
    m.setType(Message.TYPE_MESSAGE);
    assertEquals("{\"title\":\"\",\"custom_content\":{},\"accept_time\":[],\"content\":\"\"}",
        m.toJson());
  }

}
