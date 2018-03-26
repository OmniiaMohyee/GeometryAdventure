package com.omniia.helloworld;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import com.omniia.helloworld.HelloWorld;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//config.useGL30 = true;
		config.useAccelerometer = true;
		config.useCompass = true;
		initialize(new HelloWorld(), config);
	}
}
