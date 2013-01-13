package com.jde.ui.linklabel;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/** A JLabel handling clickable html links and opening default browser. */
public class JLinkLabel extends JLabel implements MouseListener {

	private static final long serialVersionUID = 5067499154142415159L;

	private String HTML_FORMAT = "<html><body><a href=\"%s\">%s</a></body></html>";
	private String HTML_VISITED = "<html><body><a href=\"%s\"><span style=\"color:#663366\">%s</span></a></body></html>";
	private String link;

	/**
	 * JLinkLabel constructor
	 * 
	 * @param link
	 *            - the link to make clickable (format should be
	 *            http://www.domain.com)
	 */
	public JLinkLabel(String link) {
		this.link = link;
		setText(toHtml(link, false));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);
	}

	private String toHtml(String l, boolean visited) {
		if (visited)
			return String.format(HTML_VISITED, l, l);
		return String.format(HTML_FORMAT, l, l);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		try {
			new LinkWorker(new URI(link)).execute();
		} catch (URISyntaxException e) {
			JOptionPane.showMessageDialog(null, "Failed to open url " + link);
		}
		setText(toHtml(link, true));
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		setToolTipText("Click to open " + link);
	}

	@Override
	public void mouseExited(MouseEvent me) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
	}

	@Override
	public void mouseReleased(MouseEvent me) {
	}

	private class LinkWorker extends SwingWorker<Void, Void> {

		private final URI uri;

		private LinkWorker(URI uri) {
			assert uri != null;
			this.uri = uri;
		}

		@Override
		protected Void doInBackground() throws Exception {
			if (Desktop.isDesktopSupported())
				if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
					Desktop.getDesktop().browse(uri);
			return null;
		}

		@Override
		protected void done() {
			try {
				get();
			} catch (InterruptedException e) {
				JOptionPane
						.showMessageDialog(null, "Failed to open url " + uri);
			} catch (ExecutionException e) {
				JOptionPane
						.showMessageDialog(null, "Failed to open url " + uri);
			}
		}
	}
}
