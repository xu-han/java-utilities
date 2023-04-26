/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DateTimeUtilsTest {

    @Test
    void testLocalDateString() {
        LocalDate date = LocalDate.now();
        String dateStr = new LocalDateConverter(date).toString();
        assertEquals(date, new StringDateConverter(dateStr).toLocalDate());
    }

    @Test
    void testLocalDateString2() {
        LocalDate date = LocalDate.now();
        String dateStr = date.toString();
        assertEquals(date, new StringDateConverter(dateStr).toLocalDate());
    }

    @Test
    void testLocalDateTimeString() {
        LocalDateTime date = LocalDateTime.now();
        String dateStr = new LocalDateTimeConverter(date).toString();
        assertEquals(date, new StringDateConverter(dateStr).toLocalDateTime());
    }

    @Test
    void testDateLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = new LocalDateTimeConverter(localDateTime).toDate();
        assertEquals(localDateTime, new DateConverter(date).toLocalDateTime());
    }

    @Test
    void testDateLocalDate() {
        LocalDate localDate = LocalDate.now();
        Date date = new LocalDateConverter(localDate).toDate();
        assertEquals(localDate, new DateConverter(date).toLocalDate());
    }

    @Test
    void testDateXmlGC() {
        Date date = new Date();
        XMLGregorianCalendar dateXmlGc = new DateConverter(date).toXMLGregorianCalendar();
        assertEquals(date, new XMLGregorianCalendarConverter(dateXmlGc).toDate());
    }

    @Test
    void testLocalDateXmlGC() {
        LocalDate date = LocalDate.now();
        XMLGregorianCalendar dateXmlGc = new LocalDateConverter(date).toXMLGregorianCalendar();
        assertEquals(date, new XMLGregorianCalendarConverter(dateXmlGc).toLocalDate());
    }

    @Test
    void testLocalDateTimeXmlGC() {
        LocalDateTime localDateTime = LocalDateTime.now();
        XMLGregorianCalendar dateXmlGc = new LocalDateTimeConverter(localDateTime).toXMLGregorianCalendar();
        assertEquals(localDateTime, new XMLGregorianCalendarConverter(dateXmlGc).toLocalDateTime());
    }
}
