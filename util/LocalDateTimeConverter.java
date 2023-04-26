/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDateTimeConverter {

    public static final ZoneId ZONE_ID = ZoneId.of("America/New_York");
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss:SSS]");

    private final LocalDateTime localDateTime;

    public LocalDateTimeConverter(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public XMLGregorianCalendar toXMLGregorianCalendar() {
        if (localDateTime == null) {
            return null;
        }
        return new DateConverter(this.toDate()).toXMLGregorianCalendar();
    }

    @Override
    public String toString() {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DEFAULT_DATE_TIME_FORMATTER);
    }

    //Lost time information
    public LocalDate toLocalDate() {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.toLocalDate();
    }

    public Date toDate() {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
    }

}
