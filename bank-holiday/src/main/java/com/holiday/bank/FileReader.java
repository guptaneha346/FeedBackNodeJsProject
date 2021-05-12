package com.holiday.bank;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class FileReader {


    public JSONArray getFileReader() throws IOException, ParseException {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("holiday.json")).getFile());
        JSONArray obj = (JSONArray) new JSONParser().parse(new java.io.FileReader(file));
        return obj;

    }

    public List<Holiday> getHolidayList() throws IOException, ParseException{
        JSONArray obj =  this.getFileReader();
        List<Holiday> HolidayList = new ArrayList<>();
        for(int i = 0; i < obj.size(); i++) {
           HashMap jsonObject = (HashMap) ((JSONObject) obj.get(i));
            Holiday holidays = Holiday.builder().day((String) jsonObject.get("day"))
                    .date(LocalDate.parse((String) jsonObject.get("date"), DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                    .description((String) jsonObject.get("description"))
                    .timezone((List<String>) jsonObject.get("timezone"))
                    .build();
            HolidayList.add(holidays);
        }
          return HolidayList;
    }
}
