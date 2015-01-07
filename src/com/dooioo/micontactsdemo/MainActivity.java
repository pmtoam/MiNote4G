package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dooioo.minote.R;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		TextView tv_test = (TextView) findViewById(R.id.tv_test);
		tv_test.setText("For test.");
		
		tv_test.setVisibility(View.INVISIBLE);
		tv_test.setVisibility(View.GONE);
		tv_test.setVisibility(View.VISIBLE);
		
		String s = "wangyuexing";
		char[] text = s.toCharArray();
		tv_test.setText(text, 3, 4);
		
		String str = new String(text);
		Log.e("XTAG", "char[] to String = " + str);
		
		Log.e("XTAG", "-->XPMTOAM");
		
	}

 
}
