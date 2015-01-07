package com.dooioo.micontactsdemo;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts.Data;
import android.provider.ContactsContract.RawContacts;

import com.dooioo.common.utils.StringUtils;

public class InsertContactToLocalDBActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		
		ContentValues values = new ContentValues();
		Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
		long rawContactId = ContentUris.parseId(rawContactUri);

		values.clear();
		values.put(Data.RAW_CONTACT_ID, rawContactId);
		values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
		values.put(Phone.NUMBER, "18977778891");
		values.put(Phone.TYPE, Phone.TYPE_MOBILE);
		
		StringUtils.reviseValues(values);
		
		getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
		
	}

}
