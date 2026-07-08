package xdmplus.ui.components;

import static xdmplus.util.XDMUtils.getScaledInt;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import xdmplus.XDMApp;
import xdmplus.ui.res.ColorResource;
import xdmplus.ui.res.FontResource;
import xdmplus.ui.res.StringResource;

public class AboutPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1284170515876454911L;

	public AboutPage(XDMFrame xframe) {
		super(StringResource.get("TITLE_ABOUT"), getScaledInt(350), xframe);
		int y = 0;
		int h = 0;
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		y += getScaledInt(10);
		h = getScaledInt(50);

		JLabel lblTitle = new JLabel(StringResource.get("FULL_NAME"));
		lblTitle.setFont(FontResource.getBiggerFont());
		lblTitle.setForeground(ColorResource.getWhite());
		lblTitle.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(30), h);
		panel.add(lblTitle);

		y += h;
		y += getScaledInt(20);

		String details = String.format(
				"Version %s with Java %s on %s\n\nXDM+ is a fork of Xtreme Download Manager, created by Osama Ahmed Qureshi.\n\n%s\nCopyright (C) 2026, All rights reserved.",
				XDMApp.APP_VERSION, (System.getProperty("java.vendor") + " " + System.getProperty("java.version")),
				System.getProperty("os.name"), XDMApp.APP_HOME_URL);

		h = getScaledInt(250);
		JTextArea lblDetails = new JTextArea();
		lblDetails.setOpaque(false);
		lblDetails.setWrapStyleWord(true);
		lblDetails.setLineWrap(true);
		lblDetails.setEditable(false);
		lblDetails.setForeground(ColorResource.getWhite());
		lblDetails.setText(details);
		lblDetails.setFont(FontResource.getBigFont());
		lblDetails.setBounds(getScaledInt(15), y, getScaledInt(350) - getScaledInt(30), h);
		panel.add(lblDetails);
		y += h;

		panel.setPreferredSize(new Dimension(getScaledInt(350), y));
		panel.setBounds(0, 0, getScaledInt(350), y);

		jsp.setViewportView(panel);
	}
}
