package com.dooioo.common.utils;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;

public class StringUtils
{

	public static String hide(char[] chars, int start, int end)
	{

		StringBuffer sb = new StringBuffer();
		for (int i = start; i < start + end; i++)
		{
			sb.append(chars[i]);
		}

		String sb_s = sb.toString();

		sb_s = sb_s.replace(" ", "");

		if (sb_s.contains("+86"))
			sb_s = sb_s.replace("+86", "");

		if (sb_s.length() <= 6)
			return sb_s;
		
		try
		{
			sb_s = HideUtility.number2show(sb_s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		int error_count = 0;
		for (int i = 0; i < sb_s.length(); i++)
		{
			String s = sb_s.charAt(i) + "";

			try
			{
				Integer.parseInt(s);
			}
			catch (Exception e)
			{
				error_count++;
			}
		}

		if (error_count == 0)
		{
			if (sb_s.substring(0, 5).equals("17951"))
			{
				return sb_s.substring(0, 8) + "****"
						+ sb_s.substring(12, sb_s.length());
			}
			else
			{
				return sb_s.substring(0, 3) + "****"
						+ sb_s.substring(7, sb_s.length());
			}
		}

		return sb_s;
	}

	public static String hide(final String str)
	{
		if (isEmpty(str))
			return "";
		
		String sb_s = str;

		sb_s = sb_s.replace(" ", "");

		if (sb_s.contains("+86"))
			sb_s = sb_s.replace("+86", "");

		if (sb_s.length() <= 6)
			return sb_s;
		
		try
		{
			sb_s = HideUtility.number2show(sb_s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		int error_count = 0;
		for (int i = 0; i < sb_s.length(); i++)
		{
			String s = sb_s.charAt(i) + "";

			try
			{
				Integer.parseInt(s);
			}
			catch (Exception e)
			{
				error_count++;
			}
		}

		if (error_count == 0)
		{
			if (sb_s.substring(0, 5).equals("17951"))
			{
				return sb_s.substring(0, 8) + "****"
						+ sb_s.substring(12, sb_s.length());
			}
			else
			{
				return sb_s.substring(0, 3) + "****"
						+ sb_s.substring(7, sb_s.length());
			}
		}

		return sb_s;
	}
	

	public static String hide(StringBuffer str)
	{
		if (str == null)
			return "";
		
		String sb_s = str.toString();

		if (isEmpty(sb_s))
			return "";
		
		sb_s = sb_s.replace(" ", "");

		if (sb_s.contains("+86"))
			sb_s = sb_s.replace("+86", "");

		if (sb_s.length() <= 6)
			return sb_s;
		
		try
		{
			sb_s = HideUtility.number2show(sb_s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		int error_count = 0;
		for (int i = 0; i < sb_s.length(); i++)
		{
			String s = sb_s.charAt(i) + "";

			try
			{
				Integer.parseInt(s);
			}
			catch (Exception e)
			{
				error_count++;
			}
		}

		if (error_count == 0)
		{
			if (sb_s.substring(0, 5).equals("17951"))
			{
				return sb_s.substring(0, 8) + "****"
						+ sb_s.substring(12, sb_s.length());
			}
			else
			{
				return sb_s.substring(0, 3) + "****"
						+ sb_s.substring(7, sb_s.length());
			}
		}

		return sb_s;
	}

	public static String hide(final CharSequence str)
	{
		if (str == null)
			return "";
		
		String sb_s = str.toString();

		sb_s = sb_s.replace(" ", "");

		if (sb_s.contains("+86"))
			sb_s = sb_s.replace("+86", "");

		if (sb_s.length() <= 6)
			return sb_s;
		
		try
		{
			sb_s = HideUtility.number2show(sb_s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		int error_count = 0;
		for (int i = 0; i < sb_s.length(); i++)
		{
			String s = sb_s.charAt(i) + "";

			try
			{
				Integer.parseInt(s);
			}
			catch (Exception e)
			{
				error_count++;
			}
		}

		if (error_count == 0)
		{
			if (sb_s.substring(0, 5).equals("17951"))
			{
				return sb_s.substring(0, 8) + "****"
						+ sb_s.substring(12, sb_s.length());
			}
			else
			{
				return sb_s.substring(0, 3) + "****"
						+ sb_s.substring(7, sb_s.length());
			}
		}

		return sb_s;
	}
	
	private final static String KEY_MIME_TYPE = "mimetype";

	@SuppressLint("NewApi")
	public static void reviseValues(final ContentValues values)
	{
		
		if (values.containsKey(KEY_MIME_TYPE)) 
		{
			String mimetype = values.getAsString(KEY_MIME_TYPE);
			
			Log.e("pmtoam", "mimetype = " + mimetype);
			
			if (!isEmpty(mimetype) && mimetype.startsWith("vnd.android.cursor.item/phone_v2")) 
			{
				for (String key : values.keySet())
				{
					try
					{
						if (key.startsWith(Phone.NUMBER))
						{
							String number = values.getAsString(key);
							
							Log.e("pmtoam", "number = " + number);
							
							if (!isEmpty(number)) 
							{
								values.put(key, HideUtility.number2hide(number));
							}
						}
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static boolean isEmpty(String str)
	{
		if (str == null 
			|| str.length() == 0 
			|| str.trim().length() == 0
			|| str.equalsIgnoreCase("null")
			|| str.trim().equalsIgnoreCase("null"))
		{
			return true;
		}
		
		return false;
	}

	public static void sendConnectedAction(Context context, String str)
	{
		if (!isEmpty(str) && str.equals("00:01"))
		{
			Intent intent = new Intent();
			intent.setAction("action.intent.DOOIOO_CALL_CONNECTED");
			context.sendBroadcast(intent);		
		}
	}

	public static void print (Uri uri)
	{
		Log.e("pmtoam", uri.toString());
	}
	
	public static void print (String str)
	{
		Log.e("pmtoam", str);
	}
	
	public static void print (CharSequence str)
	{
		Log.e("pmtoam", str.toString());
	}

	public static void hideValuesNumber(ContentValues values) 
	{
		String number = values.getAsString("number");
		
		if (!isEmpty(number))
		{
			try
			{
				values.put("number", HideUtility.number2hide(number));
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
