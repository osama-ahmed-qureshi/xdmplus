package xdmplus.ui.laf;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;

import xdmplus.ui.res.ColorResource;

/**
 * Material 3 flavored dark theme built on top of FlatLaf. Replaces the old
 * hand-rolled XDMLookAndFeel/XDM*UI delegate classes: FlatLaf already ships
 * modern, properly anti-aliased renderers for every standard Swing widget,
 * so this class only needs to (a) select FlatLaf's dark base theme, (b) tune
 * corner radii to match M3's rounded shape language, and (c) point FlatLaf's
 * accent color at the app's brand color from ColorResource.
 */
public class XdmPlusTheme {

	public static void install() {
		FlatDarculaLaf.setup();

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

	private XdmPlusTheme() {
	}
}
