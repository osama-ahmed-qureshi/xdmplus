<p id="downloads" align="center">
	<h1 align="center">XDM+</h1>
</p>

<p align="center">
	<a href="https://github.com/xdmplus/xdmplus/workflows/Java%20CI/badge.svg?branch=master"><img src="https://github.com/xdmplus/xdmplus/workflows/Java%20CI/badge.svg?branch=master" alt="Java CI" /></a>
</p>

**XDM+** is a powerful download manager, a community fork of Xtreme Download Manager (XDM) 7.2.11 originally created by Subhra Das Gupta. It increases download speeds, saves streaming video from YouTube, DailyMotion, Facebook, Vimeo, Google Video and 1000+ other websites, resumes broken/dead downloads, and schedules and converts downloads.<br>
XDM+ seamlessly integrates with Google Chrome, Mozilla Firefox Quantum, Opera, Vivaldi and other Chromium and Firefox based browsers, to take over downloads and save streaming videos from the web. It has a built in video converter which lets you convert your downloaded videos to different formats so that you can watch them on your mobile or TV (100+ devices are supported).

This fork rebrands the project as XDM+ (starting at version 1.0.0), replaces the hand-rolled Swing look and feel with a Material 3 inspired theme built on [FlatLaf](https://www.formdev.com/flatlaf/), and modernizes the tech stack (Java 21, current Maven dependencies, Gson instead of the long-abandoned json-simple).

## Features
- Download files at maximum possible speed (5-6 times faster than conventional downloaders).
- Saves video from YouTube, Dailymotion, Vimeo, Facebook and thousands of popular video sharing sites.
- Works with all modern browsers on Windows, Linux and Mac OS X.
- Built in video converter, which lets you convert downloaded video to MP3 and MP4 formats.
- Supports `HTTP`, `HTTPS`, `FTP` as well as video streaming protocols like `MPEG-DASH`, `Apple HLS`, and `Adobe HDS`.
- Supports authentication, proxy servers, cookies, redirection etc.
- Video download, clipboard monitoring, automatic antivirus checking, scheduler, system shutdown on download completion.
- Resumes broken / dead downloads caused by connection problems, power failure or session expiration.
- Works with Windows ISA, auto proxy scripts, proxy servers, NTLM, Kerberos authentication.

## Building from source
<pre>
This is a standard Maven project targeting Java 21.
If you have configured Java 21+ and Maven, use: <b>mvn clean package</b> to build the project.
The jar (xdmplus.jar) will be created in the app/target directory.
</pre>

## Submitting translations
If you want to translate XDM+ to your language, feel free to submit a translation file based on the ones in `app/src/main/resources/lang`.

## Credits
XDM+ builds on the excellent work of the original [XDM project](https://github.com/subhra74/xdm) by Subhra Das Gupta and its contributors.
