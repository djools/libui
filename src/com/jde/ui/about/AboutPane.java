package com.jde.ui.about;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPane extends JPanel {

	private static final long serialVersionUID = -7058001019495308674L;

	public AboutPane(String app, String version, String author, String email,
			String site, String disclaimer, ImageIcon icon) {
		super(new FlowLayout(FlowLayout.LEFT));

		JPanel a = new JPanel(new GridLayout(4, 1));

		a.add(new JLabel(app + (version != null ? " - version " + version : "")));
		a.add(new JLabel("Author: " + author
				+ (email != null ? " - email: <" + email + ">" : "")));
		a.add(new JLabel(site != null ? "<html><body>Pease visit <a href=\""
				+ site + "\"" + site + "</a></body></html>" : ""));
		a.add(new JLabel(disclaimer));

		this.add(new JLabel(icon));
		this.add(a);
	}
}
