package xdmplus.ui.laf;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import xdmplus.Config;
import xdmplus.ui.res.ColorResource;

/**
 * Material 3 flavored theme built on top of FlatLaf, with a dark and a light
 * variant. Replaces the old hand-rolled XDMLookAndFeel/XDM*UI delegate
 * classes: FlatLaf already ships modern, properly anti-aliased renderers for
 * every standard Swing widget, so this class only needs to (a) pick FlatLaf's
 * light/dark base theme, (b) tune corner radii to match M3's rounded shape
 * language, and (c) point FlatLaf's accent color at the app's brand color
 * from ColorResource.
 *
 * The active variant is resolved once at startup from
 * {@link Config#getThemeMode()} ("light"/"dark"/"system"), falling back to
 * {@link SystemTheme#isDarkMode()} for "system". Changing the setting takes
 * effect on next launch, since colors are read once at construction time
 * throughout the UI rather than bound reactively.
 */
public class XdmPlusTheme {

	public static void install() {
		boolean dark = resolveDark();
		ColorResource.applyTheme(dark);

		if (dark) {
			FlatDarculaLaf.setup();
		} else {
			FlatLightLaf.setup();
		}

		// M3-style rounded corners
		UIManager.put("Button.arc", 16);
		UIManager.put("Component.arc", 12);
		UIManager.put("CheckBox.arc", 6);
		UIManager.put("ProgressBar.arc", 999);
		UIManager.put("TextComponent.arc", 10);
		UIManager.put("ScrollBar.thumbArc", 999);
		UIManager.put("ScrollBar.trackArc", 999);
		UIManager.put("ScrollBar.width", 12);
		UIManager.put("ScrollBar.thumbInsets", new Insets(2, 3, 2, 3));
		UIManager.put("PopupMenu.arc", 12);
		UIManager.put("ToolTip.arc", 8);

		// Brand color + surfaces, bridged from the app's own ColorResource
		// tokens so the FlatLaf-rendered widgets (buttons, combo boxes,
		// scrollbars, menus, text fields) match the custom-painted panels.
		Color accent = ColorResource.getSelectionColor();
		UIManager.put("Component.accentColor", accent);
		UIManager.put("Component.focusColor", accent);
		UIManager.put("Component.focusedBorderColor", accent);
		UIManager.put("Component.linkColor", accent);

		UIManager.put("Panel.background", ColorResource.getDarkestBgColor());
		UIManager.put("control", ColorResource.getDarkestBgColor());
		UIManager.put("text", ColorResource.getWhite());

		UIManager.put("Button.default.background", accent);
		UIManager.put("Button.default.foreground", Color.WHITE);
	}

	private static boolean resolveDark() {
		String mode = Config.getInstance().getThemeMode();
		if ("dark".equalsIgnoreCase(mode)) {
			return true;
		}
		if ("light".equalsIgnoreCase(mode)) {
			return false;
		}
		return SystemTheme.isDarkMode();
	}

	private XdmPlusTheme() {
	}
}
