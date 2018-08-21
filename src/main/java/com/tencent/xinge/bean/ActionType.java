package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {

  OPEN_APP(0, "默认打开app"),
  OPEN_ACTIVITY_BY_CLASS_NAME(1, "显式通过类名打开activity或app本身"),
  OPEN_WEB(2, "打开浏览器"),
  OPEN_INTENT(3, "打开Intent"),
  OPEN_APP_BY_APK_NAME(4,"通过包名打开应用"),
  OPEN_ACTIVITY_BY_ACTION(5, "隐式通过action打开activity"), //SDK  4.1 以上支持
  OPEN_RECEIVER_BY_ACTION(6, "发送一个action广播"), //SDK  4.1 以上支持
  ;

  ActionType(int type, String name) {
    this.type = type;
    this.name = name;
  }

  @JsonValue
  public int getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  private int type;

  private String name;

}
