package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.dooioo.minote.R;

public class EditTextListenerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (NewMessageActivity.isOnCreate) {
			NewMessageActivity.isOnCreate = false;
			NewMessageActivity.isOnCreate = false;
		}

		EditText et = (EditText) findViewById(R.id.et);
		et.setEnabled(true);
		String text = et.getText().toString();
		et.setText(text + " ");
			
	}
}
