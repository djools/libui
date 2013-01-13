package com.jde.ui.wizard;

/**
 * class WizardEvent - Description of events that can occur when buttons from
 * the below bar are clicked
 */
public class WizardEvent {
	/** WizardEvent type for cancel button click */
	public static final int WIZARD_EVENT_CANCEL = 0;
	/** WizardEvent type for finish button click */
	public static final int WIZARD_EVENT_FINISH = 1;
	/** WizardEvent type for previous button click */
	public static final int WIZARD_EVENT_PREV_PAGE = 2;
	/** WizardEvent type for next button click */
	public static final int WIZARD_EVENT_NEXT_PAGE = 3;

	int type;

	public WizardEvent(int type) {
		super();
		this.type = type;
	}

	/** getType() - returns the type of WizardEvent */
	public int getType() {
		return type;
	}

}
