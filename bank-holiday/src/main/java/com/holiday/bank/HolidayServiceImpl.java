package com.holiday.bank;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class HolidayServiceImpl implements HolidayService {

    private FileReader fileReader;

    public HolidayServiceImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Holiday> getHoliday(String day, String time) throws IOException, ParseException {
        final List<Holiday> holidayList = fileReader.getHolidayList();
        return holidayList.stream()
                .filter(d -> d.getDay().equals(day))
                .filter(t -> t.getTimezone().stream()
                        .anyMatch(l ->
                                l.equals(time)))
                .collect(Collectors.toList());
    }

    @Override
    public Holiday getNextHoliday() throws IOException, ParseException {
        final List<Holiday> HolidayList = fileReader.getHolidayList();
        return HolidayList.stream()
                .filter(a -> a.getDate().isAfter(LocalDate.now()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Exception in Find next holiday"));
    }

    @Override
    public Date getTimeZone(String date) {
        final ZoneId zoneId = ZoneId.systemDefault();
        final String s = zoneId.getId();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(s));
        return simpleDateFormat.parse(date, new ParsePosition(0));
    }
}
