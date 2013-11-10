package com.slidingdemo.utility;

import java.io.File;

import android.os.Environment;

public class Constants {
	public static class Config {
		public static final boolean DEVELOPER_MODE = false;

	}

	public static final String FOLDER_PATH = Environment
			.getExternalStorageDirectory()
			+ File.separator
			+ "LoveQuotes";
	public static final String APP_ID = "683369145010701";

	public static final String twitter_consumer_key = "EJjcoyG5wYIzgMSgEWraZw";// 2g68GljCTdP8NdAyW9I5g";EJjcoyG5wYIzgMSgEWraZw
	public static final String twitter_secret_key = "cMHIPH6MWavegTRQwOeIVri3iUJWWTFbAzZvnm42g";
	// IA3OrIRsCBl22kcEbCOC2tY2MZtgzDYtwzbgZTioog

	// public static final String SENDER_ID = "771736406066";

	public static final String JSON_URL = "http://igeniusapp.com/lovequote/icon/ReadDir.php?method=read_image";

}
