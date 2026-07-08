package xdmplus.ui.res;

import java.awt.*;

/**
 * Material 3 inspired palette with a dark and a light variant, switched via
 * {@link #applyTheme(boolean)}. Method names are kept stable so the ~65 UI
 * call sites that read colors through this class don't need to change; only
 * the token values are swapped. Roles: darkestBgColor=surface,
 * darkerBgColor=surface container low, darkBgColor/darkBtnColor=surface
 * container, darkPressedColor=surface container highest (pressed/hover),
 * titleColor=chrome/toolbar surface, selectedColor=primary,
 * activeTabColor=primary container, whiteColor=on-surface (primary text),
 * lightFontColor/deepFontColor=on-surface variant (secondary/tertiary text).
 *
 * Note: darkBgColor/darkBtnColor is also reused in a few places (e.g. the
 * category tab labels in MainWindow) as a dark *text* color drawn on top of
 * activeTabColor's light chip, so it intentionally stays a dark neutral in
 * both themes rather than flipping to a light "surface container" tone.
 */
public class ColorResource {
	private static Color whiteColor;
	private static Color titleColor;
	private static Color selectedColor;
	private static Color activeTabColor;
	private static Color darkBgColor;
	private static Color darkerBgColor;
	private static Color darkPressedColor;
	private static Color deepFontColor;
	private static Color lightFontColor;
	private static Color darkBtnColor;
	private static Color darkestBgColor;
	private static boolean dark = true;

	public static boolean isDark() {
		return dark;
	}

	static {
		applyTheme(true);
	}

	public static void applyTheme(boolean isDark) {
		ColorResource.dark = isDark;
		if (isDark) {
			whiteColor = new Color(230, 225, 229);
			titleColor = new Color(28, 27, 31);
			selectedColor = new Color(41, 182, 246);
			activeTabColor = new Color(214, 236, 250);
			darkBgColor = new Color(48, 47, 51);
			darkerBgColor = new Color(20, 19, 22);
			darkPressedColor = new Color(54, 53, 58);
			deepFontColor = new Color(143, 144, 154);
			lightFontColor = new Color(200, 197, 202);
			darkBtnColor = new Color(48, 47, 51);
			darkestBgColor = new Color(15, 14, 17);
		} else {
			whiteColor = new Color(28, 27, 31);
			titleColor = new Color(236, 235, 240);
			selectedColor = new Color(2, 119, 189);
			activeTabColor = new Color(204, 231, 249);
			darkBgColor = new Color(66, 64, 70);
			darkerBgColor = new Color(243, 242, 246);
			darkPressedColor = new Color(225, 224, 229);
			deepFontColor = new Color(121, 116, 126);
			lightFontColor = new Color(73, 69, 79);
			darkBtnColor = new Color(66, 64, 70);
			darkestBgColor = new Color(250, 249, 252);
		}
	}

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
