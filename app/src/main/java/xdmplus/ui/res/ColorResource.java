package xdmplus.ui.res;

import java.awt.*;

/**
 * Material 3 inspired dark palette. Method names are kept stable so the ~65
 * UI call sites that read colors through this class don't need to change;
 * only the token values below were remapped to M3 roles:
 * darkestBgColor=surface, darkerBgColor=surface container low,
 * darkBgColor/darkBtnColor=surface container, darkPressedColor=surface
 * container highest (pressed/hover), titleColor=chrome/toolbar surface,
 * selectedColor=primary, activeTabColor=primary container,
 * whiteColor=on-surface, lightFontColor/deepFontColor=on-surface variant.
 */
public class ColorResource {
	private static Color whiteColor = new Color(230, 225, 229);
	private static Color titleColor = new Color(28, 27, 31);
	private static Color selectedColor = new Color(41, 182, 246);
	private static Color activeTabColor = new Color(214, 236, 250);
	private static Color darkBgColor = new Color(48, 47, 51);
	private static Color darkerBgColor = new Color(20, 19, 22);
	private static Color darkPressedColor = new Color(54, 53, 58);
	private static Color deepFontColor = new Color(143, 144, 154);
	private static Color lightFontColor = new Color(200, 197, 202);
	private static Color darkBtnColor = new Color(48, 47, 51);
	private static Color darkestBgColor = new Color(15, 14, 17);

	public static final Color getActiveTabColor() {
		return activeTabColor;
	}

	public static final Color getWhite() {
		return whiteColor;
	}

	public static final Color getTitleColor() {
		return titleColor;
	}

	public static final Color getSelectionColor() {
		return selectedColor;
	}

	public static final Color getButtonBackColor() {
		return selectedColor;
	}

	public static final Color getDarkBgColor() {
		return darkBgColor;
	}

	public static final Color getDarkerBgColor() {
		return darkerBgColor;
	}

	public static Color getDarkPressedColor() {
		return darkPressedColor;
	}

	public static final Color getDeepFontColor() {
		return deepFontColor;
	}

	public static final Color getLightFontColor() {
		return lightFontColor;
	}

	public static final Color getDarkBtnColor() {
		return darkBtnColor;
	}

	public static final void setDarkBtnColor(Color darkBtnColor) {
		ColorResource.darkBtnColor = darkBtnColor;
	}

	public static Color getDarkestBgColor() {
		return darkestBgColor;
	}

	public static void setDarkestBgColor(Color darkestBgColor) {
		ColorResource.darkestBgColor = darkestBgColor;
	}
}
