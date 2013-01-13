package com.jde.ui.about;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jde.ui.linklabel.JLinkLabel;

/**
 * AboutPane holding details about a software design.
 */
public class AboutPane extends JPanel {

	private static final long serialVersionUID = -7058001019495308674L;

	/**
	 * AboutPane constructor
	 *
	 * @param app
	 *            - name of the app
	 * @param version
	 *            - app version
	 * @param author
	 *            - developper name
	 * @param email
	 *            - contact email (can be null)
	 * @param site
	 *            - website url (can be null)
	 * @param disclaimer
	 *            - quick disclaimer/description (can be null)
	 * @param icon
	 *            - application icon (can be null)
	 */
	public AboutPane(String app, String version, String author, String email,
			String site, String disclaimer, ImageIcon icon) {
		super(new FlowLayout(FlowLayout.LEFT));

		JPanel a = new JPanel(new GridLayout(4, 1));

		a.add(new JLabel(app + (version != null ? " - version " + version : "")));
		a.add(new JLabel("Author: " + author
				+ (email != null ? " - email: <" + email + ">" : "")));

		if(site != null)
			a.add(new JLinkLabel(site));

		a.add(new JLabel(disclaimer));

		this.add(new JLabel(icon));
		this.add(a);
	}
}
