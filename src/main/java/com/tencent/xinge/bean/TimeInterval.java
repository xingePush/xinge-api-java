package com.tencent.xinge.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;

@JsonSerialize(using = TimeIntervalSerializer.class)
public class TimeInterval {
  
  public TimeInterval(int startHour, int startMin, int endHour, int endMin) {
    this.m_startHour = startHour;
    this.m_startMin = startMin;
    this.m_endHour = endHour;
    this.m_endMin = endMin;
  }

  public boolean isValid() {
    if (this.m_startHour >= 0 && this.m_startHour <= 23 && this.m_startMin >= 0
        && this.m_startMin <= 59 && this.m_endHour >= 0 && this.m_endHour <= 23
        && this.m_endMin >= 0 && this.m_endMin <= 59)
      return true;
    else
      return false;
  }

  public JSONObject toJsonObject() {
    JSONObject json = new JSONObject();
    JSONObject js = new JSONObject();
    JSONObject je = new JSONObject();
    js.put("hour", String.valueOf(m_startHour));
    js.put("min", String.valueOf(m_startMin));
    je.put("hour", String.valueOf(m_endHour));
    je.put("min", String.valueOf(m_endMin));
    json.put("start", js);
    json.put("end", je);
    return json;
  }

  protected int m_startHour;
  protected int m_startMin;
  protected int m_endHour;
  protected int m_endMin;



}


class TimeIntervalSerializer extends JsonSerializer<TimeInterval>{

  @Override
  public void serialize(TimeInterval timeInterval, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeStartObject();

    jsonGenerator.writeFieldName("start");

    jsonGenerator.writeStartObject();
    jsonGenerator.writeFieldName("hour");
    jsonGenerator.writeString(String.valueOf(timeInterval.m_startHour));
    jsonGenerator.writeFieldName("min");
    jsonGenerator.writeString(String.valueOf(timeInterval.m_startMin));
    jsonGenerator.writeEndObject();

    jsonGenerator.writeFieldName("end");

    jsonGenerator.writeStartObject();
    jsonGenerator.writeFieldName("hour");
    jsonGenerator.writeString(String.valueOf(timeInterval.m_endHour));
    jsonGenerator.writeFieldName("min");
    jsonGenerator.writeString(String.valueOf(timeInterval.m_endMin));
    jsonGenerator.writeEndObject();

    jsonGenerator.writeEndObject();
  }
}
