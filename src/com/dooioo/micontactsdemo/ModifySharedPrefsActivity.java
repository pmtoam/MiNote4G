package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class ModifySharedPrefsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			Context useContext = createPackageContext("com.android.phone", Context.CONTEXT_IGNORE_SECURITY);
			SharedPreferences sp = useContext.getSharedPreferences("com.android.phone_preferences", Context.MODE_WORLD_WRITEABLE);

			// boolean bool = sp.getBoolean("button_auto_record_call", false);
			// Log.e("TAG", "bool = " + bool);

			SharedPreferences.Editor edit = sp.edit();
			edit.putBoolean("button_auto_record_call", false);
			edit.commit();

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

	}

}
