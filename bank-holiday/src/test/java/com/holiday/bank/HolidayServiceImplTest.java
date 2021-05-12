package com.holiday.bank;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class HolidayServiceImplTest {

    @Mock
    private FileReader mockFileReader;

    private HolidayServiceImpl holidayServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        holidayServiceImpl = new HolidayServiceImpl(mockFileReader);
    }

    @Test
    public void testGetHoliday() throws Exception {
        final List<Holiday> result = holidayServiceImpl.getHoliday("friday", "America/Sao_Paulo");
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    public void testGetNextHoliday() throws Exception {
        final Holiday result = holidayServiceImpl.getNextHoliday();
        Assertions.assertThat(result).isNotNull();

    }

    @Test
    public void getTimeZone() {
        final Date result = holidayServiceImpl.getTimeZone("2021-05-11");
        assertEquals(new GregorianCalendar(2021, Calendar.MAY, 11).getTime(), result);
    }
}
