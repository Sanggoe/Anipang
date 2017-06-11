package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BackgroundMusicSound{
	public static JTextField name = new JTextField("경쾌하고활기찬음악.wav");
	public static File file = null;
	static AudioClip audioClip = null;

	/********** 음악을 무한반복 재생 **********/
	public static void loop() {
		try {
			file = new File(name.getText());
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(name, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	/********** 음악 중지 **********/
	public static void stop() {
		audioClip.stop();
	}
}
