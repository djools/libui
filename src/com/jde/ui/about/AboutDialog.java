package com.jde.ui.about;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * AboutDialog holding a AboutPane.
 */
public class AboutDialog extends JDialog {

	private static final long serialVersionUID = -6325858152481736231L;

	/**
	 * AboutDialog constructor
	 *
	 * @param owner
	 *            - parent frame
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
	public AboutDialog(Frame owner, String app, String version, String author,
			String email, String site, String disclaimer, ImageIcon icon) {
		super(owner, app, true);

		JPanel p = new JPanel(new BorderLayout());
		JPanel f = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton b = new JButton("OK");
		AboutPane ap = new AboutPane(app, version, author, email, site,
				disclaimer, icon);

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog.this.dispose();
			}
		});

		f.add(b);
		p.add(ap, BorderLayout.CENTER);
		p.add(f, BorderLayout.SOUTH);
		setContentPane(p);
	}
}
