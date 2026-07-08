package xdmplus.ui.components;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JCheckBox;

import xdmplus.ui.res.ColorResource;
import xdmplus.util.XDMUtils;

/**
 * A vector-drawn Material 3 style toggle switch (rounded track + thumb),
 * replacing the old on.png/off.png button art. Behaves like a checkbox:
 * isSelected()/setSelected() and ActionListener both work as usual.
 */
public class MaterialSwitch extends JCheckBox {
	private static final long serialVersionUID = 1L;

	private final int trackWidth = XDMUtils.getScaledInt(38);
	private final int trackHeight = XDMUtils.getScaledInt(20);
	private final int gap = XDMUtils.getScaledInt(8);

	public MaterialSwitch(String text) {
		super(text);
		setOpaque(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setIcon(null);
		setForeground(ColorResource.getWhite());
		setHorizontalTextPosition(LEADING);
		setIconTextGap(gap);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		boolean on = isSelected();
		int trackY = (getHeight() - trackHeight) / 2;

		g2.setColor(on ? ColorResource.getSelectionColor() : ColorResource.getDarkerBgColor());
		RoundRectangle2D track = new RoundRectangle2D.Float(0, trackY, trackWidth, trackHeight, trackHeight,
				trackHeight);
		g2.fill(track);

		if (!on) {
			g2.setColor(ColorResource.getLightFontColor());
			g2.draw(new RoundRectangle2D.Float(0.5f, trackY + 0.5f, trackWidth - 1, trackHeight - 1, trackHeight,
					trackHeight));
		}

		int thumbD = trackHeight - XDMUtils.getScaledInt(4);
		int thumbY = trackY + (trackHeight - thumbD) / 2;
		int thumbX = on ? trackWidth - thumbD - XDMUtils.getScaledInt(2) : XDMUtils.getScaledInt(2);
		g2.setColor(on ? ColorResource.getWhite() : ColorResource.getLightFontColor());
		g2.fill(new Ellipse2D.Float(thumbX, thumbY, thumbD, thumbD));

		g2.dispose();

		if (getText() != null && !getText().isEmpty()) {
			Graphics2D gt = (Graphics2D) g.create();
			gt.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gt.setFont(getFont());
			gt.setColor(isEnabled() ? getForeground() : ColorResource.getDeepFontColor());
			FontMetrics fm = gt.getFontMetrics();
			int textX = trackWidth + gap;
			int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
			gt.drawString(getText(), textX, textY);
			gt.dispose();
		}
	}

	@Override
	public Dimension getPreferredSize() {
		FontMetrics fm = getFontMetrics(getFont());
		int textWidth = (getText() != null && !getText().isEmpty()) ? fm.stringWidth(getText()) + gap : 0;
		int width = trackWidth + textWidth;
		int height = Math.max(trackHeight, fm.getHeight());
		return new Dimension(width, height);
	}
}
