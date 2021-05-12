package com.holiday.bank;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Date;


@SpringBootApplication
public class BankHolidayApplication {

	public static void main(String[] args) throws IOException, ParseException {

		SpringApplication.run(BankHolidayApplication.class, args);
	}

}
