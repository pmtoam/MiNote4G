package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.dooioo.common.utils.StringUtils;

public class UriActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		Log.e("", "test git");
		Log.e("", "test git more");
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		
		Uri uri = ContactsContract.Data.CONTENT_URI;
		StringUtils.print(uri);
		
	}

}
