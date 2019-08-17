package com.xxx.travel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 把日期格式转换字符串
     * @param date
     * @param format
     * @return
     */
    public static  String  getDateString(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    /**
     * 把字符串转换日期
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static  Date  getStringDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = dateFormat.parse(dateStr);
        return date;
    }
}
