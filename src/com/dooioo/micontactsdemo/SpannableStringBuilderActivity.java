package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;

import com.dooioo.common.utils.StringUtils;

public class SpannableStringBuilderActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		SpannableStringBuilder str = new SpannableStringBuilder();
		str.append("13482405222");
		String b = StringUtils.hide(str);
		final String finalResult = b;
		Log.e("TAG", "finalResult = " + finalResult);
	}

 
}
