package com.jde.ui.license;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 * LicensePane holding a JEditorPane (holding the License) and optionally an
 * accept/decline radio bar.
 */
public class LicensePane extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4398407266003368351L;

	private JRadioButton rbAccept, rbDecline;

	private final Collection<LicenseCheckListener> listeners;

	/**
	 * LicensePane constructor
	 *
	 * @param licensePath
	 *            - the path to the file to be displayed
	 * @param hasUserInput
	 *            - set to true to make radio options (accept/decline)
	 *            available; false otherwise
	 * @throws IOException
	 */
	public LicensePane(String licensePath, boolean hasUserInput)
			throws IOException {
		super(new BorderLayout());
		rbAccept = new JRadioButton("Accept", true);
		rbDecline = new JRadioButton("Decline");
		rbAccept.addActionListener(this);
		rbDecline.addActionListener(this);

		listeners = new ArrayList<LicenseCheckListener>();

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbAccept);
		bg.add(rbDecline);

		if (hasUserInput) {
			JPanel b = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			b.add(rbAccept);
			b.add(rbDecline);
			this.add(b, BorderLayout.SOUTH);
		}
		JEditorPane e = new JEditorPane();
		e.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		e.setEditable(false);
		readLicense(e, licensePath);

		this.add(new JScrollPane(e), BorderLayout.CENTER);
	}

	private void readLicense(JEditorPane e, String p) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(p)));
		String l;
		StringBuilder sb = new StringBuilder();
		while ((l = br.readLine()) != null) {
			sb.append(l);
			sb.append("\n");
		}
		e.setText(sb.toString());
	}

	public boolean isLicenseAccepted() {
		return rbAccept.isSelected();
	}

	/**
	 * addLicenseCheckListener() - Adds a LicenseCheckListener
	 * 
	 * @param lcl
	 *            - the LicenseCheckListener to be added to the list of
	 *            listeners
	 */
	public void addLicenseCheckListener(LicenseCheckListener lcl) {
		listeners.add(lcl);
	}

	/**
	 * removeLicenseCheckListener() - Removes a LicenseCheckListener
	 * 
	 * @param lcl
	 *            - the LicenseCheckListener to be removed from the list of
	 *            listeners
	 */
	public void removeLicenseCheckListener(LicenseCheckListener lcl) {
		listeners.remove(lcl);
	}

	/**
	 * getLicenseCheckListeners() - Returns the list of LicenseCheckListener
	 * 
	 * @return LicenseCheckListener[] - the list of LicenseCheckListener
	 */
	public LicenseCheckListener[] getLicenseCheckListeners() {
		return listeners.toArray(new LicenseCheckListener[0]);
	}

	/**
	 * fireLicenseCheckEvent() - fires a WizardEvent to registered listeners
	 * 
	 * @param we
	 *            - the LicenseCheckEvent
	 */
	protected void fireLicenseCheckEvent(LicenseCheckEvent lce) {
		for (LicenseCheckListener l : listeners)
			l.licenseCheckPerformed(lce);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(rbAccept))
			fireLicenseCheckEvent(new LicenseCheckEvent(
					LicenseCheckEvent.LICENSE_ACCEPTED));
		else
			fireLicenseCheckEvent(new LicenseCheckEvent(
					LicenseCheckEvent.LICENSE_DECLINED));
	}

}
