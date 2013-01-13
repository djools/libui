package com.jde.ui.wizard;

import javax.swing.JComponent;

/**
 * class WizardPage - Java representation of a wizard page (as seen in most of
 * installation tools).
 * 
 */
public class WizardPage {
	protected String name;
	protected JComponent comp;

	public WizardPage(String name, JComponent comp) {
		super();
		this.name = name;
		this.comp = comp;
	}

	public String getName() {
		return name;
	}

	public JComponent getComp() {
		return comp;
	}
}
