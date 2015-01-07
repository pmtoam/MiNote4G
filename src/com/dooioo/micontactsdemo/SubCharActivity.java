package com.dooioo.micontactsdemo;

import com.dooioo.common.utils.StringUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SubCharActivity extends Activity
{
	
	private String result_string;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
 
//		int start = 11;
//		int end = 11;
//		String s = "wangyuexing13482405222pmtoam";
//		char[] chars = s.toCharArray();
//		String result = StringUtils.hide(chars, start, end);
		
		String s = "13482405222";
		result_string = StringUtils.hide(s);
		Log.e("TAG", result_string);
		
		try
		{
			String result = StringUtils.hide((CharSequence) s);
			Log.e("TAG", result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

 
}
