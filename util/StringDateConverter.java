/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import io.micrometer.core.instrument.util.StringUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringDateConverter {

    public static final String DATE_PATTERN = "[yyyy-MM-dd][yyyy/MM/dd][MM/dd/yyyy]";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static final String DATE_TIME_PATTERN = "[yyyy-MM-dd HH:mm:ss:SSS][yyyy-MM-dd HH:mm:ss][yyyy/MM/dd HH:mm:ss][MM/dd/yyyy HH:mm:ss]";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private final String date;

    public StringDateConverter(String date) {
        this.date = date;
    }

    public LocalDate toLocalDate() {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public LocalDateTime toLocalDateTime() {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

}
