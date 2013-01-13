package com.jde.ui.license;

public class LicenseCheckEvent {
	public static final int LICENSE_ACCEPTED = 0;
	public static final int LICENSE_DECLINED = 1;

	int type;

	public LicenseCheckEvent(int type) {
		super();
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
