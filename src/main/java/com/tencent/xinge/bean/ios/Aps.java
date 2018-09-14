package com.tencent.xinge.bean.ios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ref: https://developer.apple.com/documentation/usernotifications/setting_up_a_remote_notification_server/generating_a_remote_notification?language=objc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aps {

  @JsonProperty(value = "alert", required = true)
  private Alert alert;

  @JsonProperty(value = "badge_type", required = true)
  private int badge_type;

  @JsonProperty(value = "sound")
  private Sound sound;

  @JsonProperty(value = "content-available")
  private int content_available;

  @JsonProperty(value = "category")
  private String category;

  @JsonProperty(value = "thread-id")
  private String thread_id;

  /**
   * The notification service app extension flag. If the value is 1, the system passes the
   * notification to your notification service app extension before delivery. Use your extension to
   * modify the notification’s content.
   */
  @JsonProperty(value = "mutable-content")
  private int mutable_content;

  public int getMutable_content() {
    return mutable_content;
  }

  public void setMutable_content(int mutable_content) {
    this.mutable_content = mutable_content;
  }


  public int getContent_available() {
    return content_available;
  }

  public void setContent_available(int content_available) {
    this.content_available = content_available;
  }

  public String getThread_id() {
    return thread_id;
  }

  public void setThread_id(String thread_id) {
    this.thread_id = thread_id;
  }


  public Alert getAlert() {
    return alert;
  }

  public void setAlert(Alert alert) {
    this.alert = alert;
  }

  public int getBadge_type() {
    return badge_type;
  }

  public void setBadge_type(int badge_type) {
    this.badge_type = badge_type;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Sound getSound() {
    return sound;
  }

  public void setSound(Sound sound) {
    this.sound = sound;
  }

}
