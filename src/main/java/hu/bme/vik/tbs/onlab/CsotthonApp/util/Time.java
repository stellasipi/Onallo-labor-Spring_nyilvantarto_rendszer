package hu.bme.vik.tbs.onlab.CsotthonApp.util;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class Time {
    public static Timestamp getNowInUTC(){
        return new Timestamp(ZonedDateTime.of(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                0, 0,
                ZoneId.of("UTC")).toInstant().toEpochMilli());
    }
    public static Timestamp getSpecificTimeInUTC(Integer year,Integer month, Integer day, Integer hour, Integer minute){
        return new Timestamp(ZonedDateTime.of(
                year,
                month,
                day,
                hour,
                minute,
                0, 0,
                ZoneId.of("UTC")).toInstant().toEpochMilli());
    }
}
