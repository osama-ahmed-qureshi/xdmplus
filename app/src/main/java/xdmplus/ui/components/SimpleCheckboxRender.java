package xdmplus.ui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import xdmplus.ui.res.ColorResource;
import xdmplus.ui.res.FontResource;
import xdmplus.ui.res.ImageResource;
import xdmplus.ui.res.MaterialCheckboxIcon;

import java.awt.*;
import static xdmplus.util.XDMUtils.getScaledInt;

public class SimpleCheckboxRender extends JCheckBox implements ListCellRenderer<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2719764994839662332L;

	public SimpleCheckboxRender() {
		setForeground(Color.WHITE);
		setFont(FontResource.getNormalFont());
		setOpaque(true);
		setPreferredSize(new Dimension(getScaledInt(100), getScaledInt(30)));
		setBorder(new EmptyBorder(getScaledInt(0), getScaledInt(5), 0, 0));
		setIcon(new MaterialCheckboxIcon(false, 16));
		setSelectedIcon(new MaterialCheckboxIcon(true, 16));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(ColorResource.getSelectionColor());
		} else {
			setBackground(ColorResource.getDarkerBgColor());
		}
		if (value != null) {
			setSelected(((BatchItem) value).selected);
			setText(value == null ? "" : value.toString());
		}
		return this;
	}

}
