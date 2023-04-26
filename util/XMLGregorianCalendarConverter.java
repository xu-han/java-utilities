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
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLGregorianCalendarConverter {

    public static final ZoneId ZONE_ID = ZoneId.of("America/New_York");

    private final XMLGregorianCalendar cal;

    public XMLGregorianCalendarConverter(XMLGregorianCalendar cal) {
        this.cal = cal;
    }

    public Date toDate() {
        if (cal == null) {
            return null;
        }
        Date date = cal.toGregorianCalendar().getTime();
        return date;

    }

    public LocalDate toLocalDate() {
        if (cal == null) {
            return null;
        }
        LocalDate localDate = LocalDate.of(cal.getYear(), cal.getMonth(), cal.getDay());
        return localDate;
    }

    public LocalDateTime toLocalDateTime() {
        if (cal == null) {
            return null;
        }
        LocalDateTime localDateTime = cal.toGregorianCalendar().toInstant().atZone(ZONE_ID).toLocalDateTime();
        return localDateTime;

    }

}
