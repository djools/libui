package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.jde.ui.about.AboutDialog;
import com.jde.ui.about.AboutPane;
import com.jde.ui.license.LicenseCheckEvent;
import com.jde.ui.license.LicenseCheckListener;
import com.jde.ui.license.LicensePane;
import com.jde.ui.wizard.Wizard;
import com.jde.ui.wizard.WizardEvent;
import com.jde.ui.wizard.WizardEventListener;
import com.jde.ui.wizard.WizardPage;

/** Quick and dirty test class to play with components in packages com.jde.ui.* */
public class UiTest {

	private static List<WizardPage> populateList() throws IOException {
		List<WizardPage> l = new ArrayList<WizardPage>();
		LicensePane lp = new LicensePane("License", true);
		WizardPage wp = new WizardPage("License", lp);

		lp.addLicenseCheckListener(new LicenseCheckListener() {
			@Override
			public void licenseCheckPerformed(LicenseCheckEvent lce) {
				// LicenseCheckEvent received! handle them using lce.getType()
				System.out
						.println("LicenseCheckEvent received! handle them using lce.getType():"
								+ lce.getType());
			}
		});

		l.add(wp);
		l.add((new WizardPage("About", new AboutPane("UiTest", "1.0",
				"Your Name", "your.name@domain.com", "http://www.domain.com",
				"... provided AS IS ...", null))));
		return l;
	}

	private static void testWizard() throws IOException {
		JFrame f = new JFrame("- Ui Test -");

		List<WizardPage> l = populateList();
		Wizard w = new Wizard("img/maths_3.png", l);
		w.addWizardEventListener(new WizardEventListener() {

			@Override
			public void actionPerformed(WizardEvent we) {
				// WizardEvent received! handle them using we.getType()
				System.out
						.println("WizardEvent received! handle them using we.getType():"
								+ we.getType());
			}
		});

		f.setContentPane(w);
		f.pack();
		f.setBounds(0, 0, 750, 510);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private static void testDialog() {
		AboutDialog dialog = new AboutDialog(null, "UiTest", "1.0",
				"Your Name", "your.name@domain.com", "http://www.domain.com",
				"Here goes my description of the tool", null);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println("usage: UiTest <n>");
			System.exit(-1);
		}

		final String param = args[0];
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (param.equals("1"))
					testDialog();
				else
					try {
						testWizard();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		});
	}
}
