package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SetValueActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String a = "AAAAAAAAAAAAAAAAAA";

		String b = a;

		Log.e("TAG", "b = " + b);
	}

}
