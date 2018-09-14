package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountPushType {
  latest_device_of_singe_account(0, "往单个账号的最新的device上推送信息"),
  all_devices_of_singe_account(1, "往单个账号关联的所有device设备上推送信息"),

  ;
  AccountPushType(int type, String name) {
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
