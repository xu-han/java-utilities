/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateConverter {

    public static final ZoneId ZONE_ID = ZoneId.of("America/New_York");

    private final Date date;

    public DateConverter(Date date) {
        this.date = date;
    }

    public XMLGregorianCalendar toXMLGregorianCalendar() {
        if (date == null) {
            return null;
        }
        try {
            GregorianCalendar dateGC = new GregorianCalendar();
            dateGC.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(dateGC);
        } catch (DatatypeConfigurationException e) {
            log.error("cannot convert", e);
            return null;
        }
    }

    public LocalDate toLocalDate() {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZONE_ID).toLocalDateTime();
    }

}
