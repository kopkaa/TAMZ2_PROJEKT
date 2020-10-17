package com.hroo078.gxattack;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.hroo078.gxattack.Database.DatabaseHelper;
import com.hroo078.gxattack.Game.GallaxyAttackGame;


public class AndroidLauncher extends AndroidApplication {
	private static Context context;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		AndroidLauncher.context = getApplicationContext();
		// create new database
		DatabaseHelper.getInstance(AndroidLauncher.context).getWritableDatabase();

		initialize(new GallaxyAttackGame(), config);
	}

	public static Context getAppContext() {
		return AndroidLauncher.context;
	}
}
