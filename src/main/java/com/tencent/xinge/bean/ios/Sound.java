package com.tencent.xinge.bean.ios;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A dictionary that contains sound information for critical alerts. For regular notifications, use
 * the sound string instead Ref: https://developer.apple.com/documentation/usernotifications/setting_up_a_remote_notification_server/generating_a_remote_notification#2990112
 */
public class Sound {

  /**
   * The critical alert flag. Set to 1 to enable the critical alert.
   */
  @JsonProperty(value = "critical")
  private int critical;

  /**
   * The name of a sound file in your app’s main bundle or in the Library/Sounds folder of your
   * app’s container directory.
   */
  @JsonProperty(value = "name")
  private String name;


  /**
   * The volume for the critical alert’s sound. Set this to a value between 0.0 (silent) and 1.0
   * (full volume).
   */
  @JsonProperty(value = "volume")
  private double volume;

  public int getCritical() {
    return critical;
  }

  public void setCritical(int critical) {
    this.critical = critical;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }


}
