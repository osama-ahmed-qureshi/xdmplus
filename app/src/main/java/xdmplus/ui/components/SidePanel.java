package xdmplus.ui.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import xdmplus.ui.res.ColorResource;

public class SidePanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 3821650643051584496L;

	public SidePanel() {
		super();
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(ColorResource.getDarkerBgColor());
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g2);
	}
}
