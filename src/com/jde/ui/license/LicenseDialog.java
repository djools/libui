package com.jde.ui.license;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class LicenseDialog extends JFrame {
	private static final long serialVersionUID = -2718534305120814936L;
	LicensePane lp;

	public LicenseDialog(String licensePath, boolean hasUserInput) throws IOException {
		super("License");
		lp = new LicensePane(licensePath, hasUserInput);
		setContentPane(lp);
		pack();

		setMinimumSize(new Dimension(600, 100));
	}

	/**
	 * addLicenseCheckListener() - Adds a LicenseCheckListener
	 * 
	 * @param lcl
	 *            - the LicenseCheckListener to be added to the list of
	 *            listeners
	 */
	public void addLicenseCheckListener(LicenseCheckListener lcl) {
		lp.addLicenseCheckListener(lcl);
	}

	/**
	 * removeLicenseCheckListener() - Removes a LicenseCheckListener
	 * 
	 * @param lcl
	 *            - the LicenseCheckListener to be removed from the list of
	 *            listeners
	 */
	public void removeLicenseCheckListener(LicenseCheckListener lcl) {
		lp.removeLicenseCheckListener(lcl);
	}

	/**
	 * getLicenseCheckListeners() - Returns the list of LicenseCheckListener
	 * 
	 * @return LicenseCheckListener[] - the list of LicenseCheckListener
	 */
	public LicenseCheckListener[] getLicenseCheckListeners() {
		return lp.getLicenseCheckListeners();
	}

}
