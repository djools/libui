package com.jde.ui.license;

/**
 * class LicenseCheckEvent - Description of events that can occur when buttons
 * from the below bar are clicked
 */
public class LicenseCheckEvent {
	/** LicenseCheckEvent type for accepted radio option */
	public static final int LICENSE_ACCEPTED = 0;
	/** LicenseCheckEvent type for declined radio option */
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
