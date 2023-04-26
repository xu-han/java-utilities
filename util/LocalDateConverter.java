/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDateConverter {

    public static final ZoneId ZONE_ID = ZoneId.of("America/New_York");
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("[yyyy-MM-dd]");

    private final LocalDate date;

    public LocalDateConverter(LocalDate date) {
        this.date = date;
    }

    public XMLGregorianCalendar toXMLGregorianCalendar() {
        if (date == null) {
            return null;
        }
        try {
            XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
            return xcal;
        } catch (DatatypeConfigurationException e) {
            log.error("cannot convert", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        if (date == null) {
            return null;
        }
        return date.format(DEFAULT_DATE_FORMATTER);
    }

    public Date toDate() {
        return Date.from(date.atStartOfDay(ZONE_ID).toInstant());
    }

}
