package com.clientname.projectname.genricutil.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomeNumber() {
		Random ranDom = new Random();
		int randomeNumber = ranDom.nextInt(100);
		return randomeNumber;

	}

	public int getRandomeNumber(int n) {
		Random ranDom = new Random();
		int randomeNumber = ranDom.nextInt(n);
		return randomeNumber;

	}

	public int getRandomeNumber(int from, int to) {
		Random ranDom = new Random();
		int randomeNumber = ranDom.nextInt(from, to);
		return randomeNumber;

	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String date = simple.format(dateObj);
		return date;

	}

	public String getRequiredDate(int day) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, day);
		String requiredDate = simple.format(cal.getTime());
		return requiredDate;

	}
}
