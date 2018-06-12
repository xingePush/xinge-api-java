package com.tencent.xinge;

public class Style {
	
 /**
  * 	
  * @param builderId
  */
  public Style(int builderId) {
    this(builderId, 0, 0, 1, 0, 1, 0, 1);
  }

  /**
   * 
   * @param builderId
   * @param ring
   * @param vibrate
   * @param clearable
   * @param nId
   */
  public Style(int builderId, int ring, int vibrate, int clearable, int nId) {
    this.m_builderId = builderId;
    this.m_ring = ring;
    this.m_vibrate = vibrate;
    this.m_clearable = clearable;
    this.m_nId = nId;
  }

  /**
   * 
   * @param builderId
   * @param ring
   * @param vibrate
   * @param clearable
   * @param nId
   * @param lights
   * @param iconType
   * @param styleId
   */
  public Style(int builderId, int ring, int vibrate, int clearable, int nId, int lights,
      int iconType, int styleId) {
    this.m_builderId = builderId;
    this.m_ring = ring;
    this.m_vibrate = vibrate;
    this.m_clearable = clearable;
    this.m_nId = nId;
    this.m_lights = lights;
    this.m_iconType = iconType;
    this.m_styleId = styleId;
  }

  /**
   * 本地通知样式标识
   * 
   * @return
   */
  public int getBuilderId() {
    return m_builderId;
  }

  /**
   * 是否有铃声 <br>
   * 0：没有铃声<br>
   * 1：有铃声<br>
   * 
   * @return
   */
  public int getRing() {
    return m_ring;
  }

  /**
   * 是否使用震动<br>
   * 0：没有震动<br>
   * 1：有震动
   * 
   * @return
   */
  public int getVibrate() {
    return m_vibrate;
  }

  /**
   * 通知栏是否可清除
   * 
   * @return
   */
  public int getClearable() {
    return m_clearable;
  }

  /**
   * 通知消息对象的唯一标识 <br>
   * 1. 大于0，会覆盖先前相同id的消息；<br>
   * 2. 等于0，展示本条通知且不影响其他消息；<br>
   * 3. 等于-1，将清除先前所有消息，仅展示本条消息<br>
   * 
   */
  public int getNId() {
    return m_nId;
  }

  /**
   * 是否使用呼吸灯<br>
   * 0：使用呼吸灯<br>
   * 1：不使用呼吸灯<br>
   * 
   * @return
   */
  public int getLights() {
    return m_lights;
  }

  /**
   * 通知栏图标是应用内图标还是上传图标<br>
   * 0：应用内图标<br>
   * 1：上传图标<br>
   * 
   * @return
   */
  public int getIconType() {
    return m_iconType;
  }

  public int getStyleId() {
    return m_styleId;
  }

  /**
   * 指定Android工程里raw目录中的铃声文件名，不需要后缀名
   * 
   * @param ringRaw
   */
  public void setRingRaw(String ringRaw) {
    this.m_ringRaw = ringRaw;
  }

  public String getRingRaw() {
    return m_ringRaw;
  }
  
  /**
   * 应用内图标文件名或者下载图标的url地址
   * @param iconRes
   */
  public void setIconRes(String iconRes) {
    this.m_iconRes = iconRes;
  }

  public String getIconRes() {
    return m_iconRes;
  }

  public void setSmallIcon(String smallIcon) {
    this.m_smallIcon = smallIcon;
  }

  public String getSmallIcon() {
    return m_smallIcon;
  }

  public boolean isValid() {
    if (m_ring < 0 || m_ring > 1) return false;
    if (m_vibrate < 0 || m_vibrate > 1) return false;
    if (m_clearable < 0 || m_clearable > 1) return false;
    if (m_lights < 0 || m_lights > 1) return false;
    if (m_iconType < 0 || m_iconType > 1) return false;
    if (m_styleId < 0 || m_styleId > 1) return false;

    return true;
  }

  private int m_builderId;
  private int m_ring;
  private int m_vibrate;
  private int m_clearable;
  private int m_nId;
  private String m_ringRaw;
  private int m_lights;
  private int m_iconType;
  private String m_iconRes;
  private int m_styleId;
  private String m_smallIcon;
}
