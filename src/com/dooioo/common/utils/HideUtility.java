package com.dooioo.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public final class HideUtility {

	private static final int TIMES = 11;

	private static final int CIPHER_FIXED_LENGHT = 21;

	private static final int PUBLIC_SERVICE_PHONE_LENGTH = 6;

	private static final int LAST_TWO_BITS_INDICATOR = 2;

	public static final String number2hide(String phoneNumber) throws Exception {
		if (phoneNumber == null || phoneNumber.length() == 0) {
			return phoneNumber;
		}

		boolean isIpCall = false;
		final String IP = "17951";
		if (phoneNumber.substring(0, 5).equals(IP)) {
			isIpCall = true;

			phoneNumber = phoneNumber.substring(5);
		}

		if (phoneNumber.charAt(0) == '+') {
			phoneNumber = phoneNumber.substring(1);
		}

		if (phoneNumber.length() > CIPHER_FIXED_LENGHT
				- LAST_TWO_BITS_INDICATOR) {
			// already a cipher number, or most likely, an invalid number
			if (isIpCall) {
				return IP + phoneNumber;
			}
			return phoneNumber;
		}

		if (phoneNumber.length() <= PUBLIC_SERVICE_PHONE_LENGTH) {
			// already a cipher number, or most likely, an invalid number
			if (isIpCall) {
				return IP + phoneNumber;
			}
			return phoneNumber;
		}

		String hide1 = hide(phoneNumber, TIMES);

		String hide2 = padding(hide1, CIPHER_FIXED_LENGHT);

		if (isIpCall) {
			return IP + hide2;
		}
		return hide2;
	}

	/***
	 * cipher = head + hide1(body) + two bits cipher length is
	 * CIPHER_FIXED_LENGHT
	 * */
	private static final String padding(String body, int lenght2hide) {
		int length = body.length();
		final int length2pad = lenght2hide - length - 2;

		int rest2pad = length2pad;

		String padHead = "";
		if (length2pad > length) {
			int gap = length2pad - length;

			while (gap > 0) {
				padHead += '8';
				--gap;
			}
			rest2pad = length;
		}
		for (int i = 0; i < rest2pad; i++) {
			padHead += body.charAt(length - i - 1);
		}

		String newPadHead = '8' + padHead.substring(1);
		String twoBitsIndicator = "";
		if (length2pad <= 9) {
			twoBitsIndicator = '0' + String.valueOf(length2pad);
		} else {
			twoBitsIndicator = String.valueOf(length2pad);
		}

		String last = newPadHead + body + twoBitsIndicator;
		return last;
	}

	public static final String number2show(String phoneNumber) throws Exception {
		if (phoneNumber == null || phoneNumber.length() == 0) {
			return phoneNumber;
		}

		boolean isIpCall = false;
		final String IP = "17951";
		if (phoneNumber.substring(0, 5).equals(IP)) {
			isIpCall = true;

			phoneNumber = phoneNumber.substring(5);
		}

		if (phoneNumber.length() != CIPHER_FIXED_LENGHT) {
			// already a cipher number, or most likely, an invalid number, or
			// has +
			if (phoneNumber.length() != 22) {
				if (isIpCall) {
					return IP + phoneNumber;
				}
				return phoneNumber;
			} else {
				// with +, maybe
				char first = phoneNumber.charAt(0);
				if (first != '+') {
					if (isIpCall) {
						return IP + phoneNumber;
					}
					return phoneNumber;
				}
			}

		}
		if (phoneNumber.charAt(0) == '+') {
			phoneNumber = phoneNumber.substring(1);
		}
		String body = unpadding(phoneNumber);

		String realPhone = show(body, TIMES);
		if (!isEmpty(realPhone) || realPhone.length() >= 2) {
			String with86 = realPhone.substring(0, 2);

			if (with86.equals("86")) {
				realPhone = realPhone.substring(2);
			}
		}

		if (isIpCall) {
			return IP + realPhone;
		}
		return realPhone;
	}

	private static final String unpadding(String input) {
		int length = input.length();
		String twobitString = input.substring(length - 2);
		int twobitInt = Integer.parseInt(twobitString);

		// int headLength = length - twobitInt - 2;

		String body = input.substring(twobitInt, length - 2);
		return body;
	}

	private static final String hide(String phoneNumber) throws Exception {

		if (isEmpty(phoneNumber))
			return "";

		phoneNumber = phoneNumber.replaceAll(" ", "");

		if (isEmpty(phoneNumber))
			return "";

		//
		if (phoneNumber.length() <= 6)
			return phoneNumber;

		// 9 minus.
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < phoneNumber.length(); i++) {
			String s = phoneNumber.charAt(i) + "";

			try {
				int _single_str = Integer.parseInt(s);
				strs.add((9 - _single_str) + "");
			} catch (Exception e) {
				strs.add(s);
			}
		}

		StringBuffer numberHide = new StringBuffer();
		for (String string : strs) {
			numberHide.append(string);
		}

		String _str_9 = numberHide.toString();

		// reverse order.
		List<String> _str_9_strs = new ArrayList<String>();
		for (int i = 0; i < _str_9.length(); i++)
			_str_9_strs.add(_str_9.charAt(i) + "");

		Collections.reverse(_str_9_strs);

		StringBuffer numberHide_reverse_order = new StringBuffer();

		for (int i = 0; i < _str_9_strs.size(); i++)
			numberHide_reverse_order.append(_str_9_strs.get(i));

		// String _str_numberHide_reverse_order =
		// numberHide_reverse_order.toString();

		// The last bit extraction to the first.
		String _last = _str_9_strs.get(_str_9_strs.size() - 1);
		_str_9_strs.remove(_str_9_strs.size() - 1);
		_str_9_strs.add(0, _last);

		StringBuffer _sb_reverse_order_extract = new StringBuffer();

		for (int i = 0; i < _str_9_strs.size(); i++)
			_sb_reverse_order_extract.append(_str_9_strs.get(i));

		String _str_reverse_order_extract = _sb_reverse_order_extract
				.toString();

		// merge the uneven and even.
		List<String> _reverse_order_extract_strs = new ArrayList<String>();
		for (int i = 0; i < _str_reverse_order_extract.length(); i++)
			_reverse_order_extract_strs.add(_str_reverse_order_extract
					.charAt(i) + "");

		StringBuffer _sb_uneven_number = new StringBuffer();
		StringBuffer _sb_even_number = new StringBuffer();

		for (int i = 0; i < _reverse_order_extract_strs.size(); i++) {
			if (i % 2 == 0)
				_sb_uneven_number.append(_reverse_order_extract_strs.get(i));
			else
				_sb_even_number.append(_reverse_order_extract_strs.get(i));
		}

		List<String> even_number_strs = new ArrayList<String>();
		for (int i = 0; i < _sb_even_number.toString().length(); i++) {
			even_number_strs.add(_sb_even_number.toString().charAt(i) + "");
		}

		Collections.reverse(even_number_strs);

		StringBuffer _sb_even_number_reverse = new StringBuffer();
		for (int i = 0; i < even_number_strs.size(); i++)
			_sb_even_number_reverse.append(even_number_strs.get(i));

		StringBuffer _sb_uneven_even_number = new StringBuffer();
		_sb_uneven_even_number.append(_sb_uneven_number).append(
				_sb_even_number_reverse);

		String _str_uneven_even_number = _sb_uneven_even_number.toString();

		return _str_uneven_even_number;
	}

	private static final String show(String phoneNumber) throws Exception {
		if (isEmpty(phoneNumber))
			return "";

		phoneNumber = phoneNumber.replaceAll(" ", "");

		if (isEmpty(phoneNumber))
			return "";

		//
		if (phoneNumber.length() <= 6)
			return phoneNumber;

		// Separation of uneven number and even number.
		List<String> uneven_even_number_strs = new ArrayList<String>();
		for (int i = 0; i < phoneNumber.length(); i++) {
			uneven_even_number_strs.add(phoneNumber.charAt(i) + "");
		}

		List<String> _contracted_strs = new ArrayList<String>();
		contract(_contracted_strs, uneven_even_number_strs, true);

		StringBuffer _sb_contracted = new StringBuffer();
		for (String string : _contracted_strs) {
			_sb_contracted.append(string);
		}

		// String _str_contracted = _sb_contracted.toString();

		// The first bit extraction to the last.
		String _first = _contracted_strs.get(0);
		_contracted_strs.remove(0);
		_contracted_strs.add(_first);

		StringBuffer _sb_contracted_extract = new StringBuffer();

		for (int i = 0; i < _contracted_strs.size(); i++) {
			_sb_contracted_extract.append(_contracted_strs.get(i));
		}

		String _str_contracted_extract = _sb_contracted_extract.toString();

		// reverse order.
		List<String> _str_contracted_extract_strs = new ArrayList<String>();
		for (int i = 0; i < _str_contracted_extract.length(); i++)
			_str_contracted_extract_strs.add(_str_contracted_extract.charAt(i)
					+ "");

		Collections.reverse(_str_contracted_extract_strs);

		StringBuffer numberHide_reverse_order = new StringBuffer();

		for (int i = 0; i < _str_contracted_extract_strs.size(); i++)
			numberHide_reverse_order
					.append(_str_contracted_extract_strs.get(i));

		String _str_numberHide_reverse_order = numberHide_reverse_order
				.toString();

		// 9 minus.
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < _str_numberHide_reverse_order.length(); i++) {
			String s = _str_numberHide_reverse_order.charAt(i) + "";

			try {
				int _single_str = Integer.parseInt(s);
				strs.add((9 - _single_str) + "");
			} catch (Exception e) {
				strs.add(s);
			}
		}

		StringBuffer numberHide = new StringBuffer();
		for (String string : strs)
			numberHide.append(string);

		String _str_9 = numberHide.toString();

		return _str_9;
	}

	private static final String hide(String phoneNumber, int times)
			throws Exception {
		List<String> strs = new ArrayList<String>(times);

		for (int i = 0; i < times; i++) {
			if (i == 0)
				strs.add(hide(phoneNumber));
			else
				strs.add(hide(strs.get(i - 1)));
		}

		return strs.get(strs.size() - 1);
	}

	private static final String show(String phoneNumber, int times)
			throws Exception {

		List<String> strs = new ArrayList<String>();

		for (int i = 0; i < times; i++) {
			if (i == 0)
				strs.add(show(phoneNumber));
			else
				strs.add(show(strs.get(i - 1)));
		}

		return strs.get(strs.size() - 1);
	}

	private static final void contract(List<String> _contracted_strs,
			List<String> uneven_even_number_strs, boolean isFirst) {
		if (uneven_even_number_strs.size() <= 0)
			return;

		if (isFirst) {
			_contracted_strs.add(uneven_even_number_strs.get(0));
			uneven_even_number_strs.remove(0);
		} else {
			_contracted_strs.add(uneven_even_number_strs
					.get(uneven_even_number_strs.size() - 1));
			uneven_even_number_strs.remove(uneven_even_number_strs.size() - 1);
		}

		isFirst = !isFirst;

		contract(_contracted_strs, uneven_even_number_strs, isFirst);
	}

	private static final boolean isEmpty(String str) {
		if (str == null || str.length() == 0 || str.trim().length() == 0
				|| str.equalsIgnoreCase("null")
				|| str.trim().equalsIgnoreCase("null")) {
			return true;
		}

		return false;
	}
}
