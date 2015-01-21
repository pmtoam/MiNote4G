package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.dooioo.common.utils.StringUtils;

public class StringBufferActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		StringBuffer str = new StringBuffer();
		str.append("13482405222");
		String b = StringUtils.hide(str);
		
		Log.e("TAG", "b = " + b);
	}

 
}
