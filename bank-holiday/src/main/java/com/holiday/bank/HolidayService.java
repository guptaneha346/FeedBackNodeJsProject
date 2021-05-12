package com.holiday.bank;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface HolidayService {

    List<Holiday> getHoliday(String day, String time) throws IOException, ParseException;

    Holiday getNextHoliday() throws IOException, ParseException;

    Date getTimeZone(String date);
}
