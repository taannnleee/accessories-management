package com.example.accessoriesmanagement.utils;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

public class DateUtils {
    // Hàm để chuyển từ LocalDate sang Date
    public static Date convertToLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
