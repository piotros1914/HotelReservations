package com.piotrowski.helper;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateHelper {

	public static final int MILISECOND_IN_DAY = 1000 * 60 * 60 * 24;

	public static final int differenceInDay(Date fromDate, Date toDate) {

		long difference = (fromDate.getTime() - toDate.getTime()) / MILISECOND_IN_DAY;
		return (int) Math.abs(difference);

	}

	public static Date getDateAfterDays(Date fromDate, int i) {
		return new Date(fromDate.getTime() + (MILISECOND_IN_DAY) * i);
	}

}
