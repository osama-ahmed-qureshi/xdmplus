package xdmplus.ui.laf;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

import xdmplus.util.Logger;
import xdmplus.util.XDMUtils;

/**
 * Best-effort detection of the OS light/dark appearance preference, used
 * when the user leaves the theme setting on "system".
 */
public class SystemTheme {

	public static boolean isDarkMode() {
		try {
			int os = XDMUtils.detectOS();
			if (os == XDMUtils.WINDOWS) {
				return isWindowsDarkMode();
			} else if (os == XDMUtils.MAC) {
				return isMacDarkMode();
			} else if (os == XDMUtils.LINUX) {
				return isLinuxDarkMode();
			}
		} catch (Exception e) {
			Logger.log(e);
		}
		return true; // fall back to the app's traditional dark look
	}

	private static boolean isWindowsDarkMode() {
		try {
			int value = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER,
					"Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize", "AppsUseLightTheme");
			return value == 0;
		} catch (Exception e) {
			return true;
		}
	}

	private static boolean isMacDarkMode() {
		try {
			Process p = new ProcessBuilder("defaults", "read", "-g", "AppleInterfaceStyle").start();
			String out = new String(p.getInputStream().readAllBytes()).trim();
			p.waitFor();
			return "Dark".equalsIgnoreCase(out);
		} catch (Exception e) {
			return true;
		}
	}

	private static boolean isLinuxDarkMode() {
		try {
			Process p = new ProcessBuilder("gsettings", "get", "org.gnome.desktop.interface", "color-scheme").start();
			String out = new String(p.getInputStream().readAllBytes()).trim().toLowerCase();
			p.waitFor();
			if (!out.isEmpty()) {
				return out.contains("dark");
			}
		} catch (Exception e) {
		}
		return true;
	}

	private SystemTheme() {
	}
}
