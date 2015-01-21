package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;

import com.dooioo.minote.R;

public class NewMessageActivity extends Activity {

	public static boolean isOnCreate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		isOnCreate = true;

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		isOnCreate = true;
	}

}
