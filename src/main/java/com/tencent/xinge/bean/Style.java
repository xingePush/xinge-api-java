package com.tencent.xinge.bean;

public class Style {

	/**
	 * 本地通知样式标识
	 */
	private int builder_id;
	/**
	 * 是否有铃声 0：没有铃声1：有铃声
	 */
	private int ring;
	/**
	 * 是否使用震动 0：没有震动 1：有震动
	 */
	private int vibrate;
	/**
	 * 通知栏是否可清除
	 */
	private int clearable = 1;
	/**
	 * 通知消息对象的唯一标识<br>
	 * 1. 大于0，会覆盖先前相同id的消息；<br>
	 * 2. 等于0，展示本条通知且不影响其他消息；<br>
	 * 3. 等于-1，将清除先前所有消息，仅展示本条消息<br>
	 */
	private int n_id = 0;
	/**
	 * 指定Android工程里raw目录中的铃声文件名，不需要后缀名
	 */
	private String ring_raw;
	/**
	 * 是否使用呼吸灯 0：使用呼吸灯 1：不使用呼吸灯
	 */
	private int lights;
	/**
	 * 通知栏图标是应用内图标还是上传图标  0：应用内图标 1：上传图标
	 */
	private int icon_type = 0;
	private String icon_res;
	/**
	 * 设置是否覆盖指定编号的通知样式
	 */
	private int style_id = 1;
	/**
	 * 消息在状态栏显示的图标，若不设置，则显示应用图标
	 */
	private String small_icon;

	/**
	 * 
	 * @param builder_id 本地通知样式标识
	 */
	public Style(int builder_id) {
		this(builder_id, 0, 0, 1, 0, 1, 0, 1);
	}

	/**
	 * 
	 * @param builderId 本地通知样式标识
	 * @param ring 是否有铃声 0：没有铃声1：有铃声
	 * @param vibrate  是否使用震动 0：没有震动 1：有震动
	 * @param clearable 通知栏是否可清除
	 * @param n_id 通知消息对象的唯一标识
	 */
	public Style(int builderId, int ring, int vibrate, int clearable, int n_id) {
		this.builder_id = builderId;
		this.ring = ring;
		this.vibrate = vibrate;
		this.clearable = clearable;
		this.n_id = n_id;
	}

	/**
	 * 
	 * @param builder_id 本地通知样式标识
	 * @param ring 是否有铃声 0：没有铃声1：有铃声
	 * @param vibrate  是否使用震动 0：没有震动 1：有震动
	 * @param clearable 通知栏是否可清除
	 * @param nId 通知消息对象的唯一标识
	 * @param lights 是否使用呼吸灯 0：使用呼吸灯 1：不使用呼吸灯
	 * @param icon_type 通知栏图标是应用内图标还是上传图标  0：应用内图标 1：上传图标
	 * @param style_id 设置是否覆盖指定编号的通知样式
	 */
	public Style(int builder_id, int ring, int vibrate, int clearable, int nId, int lights, int icon_type, int style_id) {
		this.builder_id = builder_id;
		this.ring = ring;
		this.vibrate = vibrate;
		this.clearable = clearable;
		this.n_id = nId;
		this.lights = lights;
		this.icon_type = icon_type;
		this.style_id = style_id;
	}

	/**
	 * 本地通知样式标识
	 * 
	 * @return
	 */
	public int getBuilderId() {
		return builder_id;
	}

	/**
	 * 是否有铃声 <br>
	 * 0：没有铃声<br>
	 * 1：有铃声<br>
	 * 
	 * @return
	 */
	public int getRing() {
		return ring;
	}

	/**
	 * 是否使用震动<br>
	 * 0：没有震动<br>
	 * 1：有震动
	 * 
	 * @return
	 */
	public int getVibrate() {
		return vibrate;
	}

	/**
	 * 通知栏是否可清除
	 * 
	 * @return
	 */
	public int getClearable() {
		return clearable;
	}

	/**
	 * 通知消息对象的唯一标识 <br>
	 * 1. 大于0，会覆盖先前相同id的消息；<br>
	 * 2. 等于0，展示本条通知且不影响其他消息；<br>
	 * 3. 等于-1，将清除先前所有消息，仅展示本条消息<br>
	 * 
	 */
	public int getNId() {
		return n_id;
	}

	/**
	 * 是否使用呼吸灯<br>
	 * 0：使用呼吸灯<br>
	 * 1：不使用呼吸灯<br>
	 * 
	 * @return
	 */
	public int getLights() {
		return lights;
	}

	/**
	 * 通知栏图标是应用内图标还是上传图标<br>
	 * 0：应用内图标<br>
	 * 1：上传图标<br>
	 * 
	 * @return
	 */
	public int getIconType() {
		return icon_type;
	}

	public int getStyleId() {
		return style_id;
	}

	/**
	 * 指定Android工程里raw目录中的铃声文件名，不需要后缀名
	 * 
	 * @param ringRaw
	 */
	public void setRingRaw(String ringRaw) {
		this.ring_raw = ringRaw;
	}

	public String getRingRaw() {
		return ring_raw;
	}

	/**
	 * 应用内图标文件名或者下载图标的url地址
	 * 
	 * @param iconRes
	 */
	public void setIconRes(String iconRes) {
		this.icon_res = iconRes;
	}

	public String getIconRes() {
		return icon_res;
	}

	public void setSmallIcon(String smallIcon) {
		this.small_icon = smallIcon;
	}

	public String getSmallIcon() {
		return small_icon;
	}

	public boolean isValid() {
		if (ring < 0 || ring > 1)
			return false;
		if (vibrate < 0 || vibrate > 1)
			return false;
		if (clearable < 0 || clearable > 1)
			return false;
		if (lights < 0 || lights > 1)
			return false;
		if (icon_type < 0 || icon_type > 1)
			return false;
		if (style_id < 0 || style_id > 1)
			return false;

		return true;
	}

}
