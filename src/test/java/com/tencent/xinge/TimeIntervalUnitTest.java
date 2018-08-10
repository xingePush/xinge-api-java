package com.tencent.xinge;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class TimeIntervalUnitTest {

	@Test
	public void testIsValid() {
		TimeInterval ti = new TimeInterval(1, 2, 3, 4);
		assertTrue(ti.isValid());
		ti = new TimeInterval(24, 0, 0, 0);
		assertFalse(ti.isValid());
	}

	@Test
	public void testToJsonObject() {
		TimeInterval ti = new TimeInterval(1, 2, 3, 4);
		JSONObject json = ti.toJsonObject();
		assertEquals("{\"start\":{\"min\":2,\"hour\":1},\"end\":{\"min\":4,\"hour\":3}}", json.toString());
	}

}
