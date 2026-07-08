package xdmplus.ui.res;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;

/**
 * Vector-drawn Material 3 style checkbox glyph, replacing the old flat 2012
 * era checked.png/unchecked.png raster icons. Scales cleanly to any DPI.
 */
public class MaterialCheckboxIcon implements Icon {

	private final boolean checked;
	private final int size;

	public MaterialCheckboxIcon(boolean checked, int size) {
		this.checked = checked;
		this.size = size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.translate(x, y);

		float stroke = Math.max(1.5f, size / 9f);
		float arc = size / 4f;
		float inset = stroke / 2f;
		RoundRectangle2D box = new RoundRectangle2D.Float(inset, inset, size - stroke, size - stroke, arc, arc);

		if (checked) {
			g2.setColor(ColorResource.getSelectionColor());
			g2.fill(box);

			g2.setColor(ColorResource.getDarkestBgColor());
			g2.setStroke(new java.awt.BasicStroke(stroke, java.awt.BasicStroke.CAP_ROUND,
					java.awt.BasicStroke.JOIN_ROUND));
			Path2D check = new Path2D.Float();
			check.moveTo(size * 0.27, size * 0.53);
			check.lineTo(size * 0.43, size * 0.70);
			check.lineTo(size * 0.75, size * 0.32);
			g2.draw(check);
		} else {
			g2.setColor(ColorResource.getLightFontColor());
			g2.setStroke(new java.awt.BasicStroke(stroke));
			g2.draw(box);
		}

		g2.dispose();
	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public int getIconHeight() {
		return size;
	}
}
