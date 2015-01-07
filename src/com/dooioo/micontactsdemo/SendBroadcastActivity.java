package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;

import com.dooioo.common.utils.StringUtils;

public class SendBroadcastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		StringUtils.sendConnectedAction(this, "00:00");

	}

}
