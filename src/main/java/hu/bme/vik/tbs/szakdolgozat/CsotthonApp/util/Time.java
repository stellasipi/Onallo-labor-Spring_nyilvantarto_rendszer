package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.util;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Time {
    public static Timestamp getNowInUTC(){
        return  new Timestamp(System.currentTimeMillis());
    }
    public static Timestamp getSpecificTimeInUTC(Integer year,Integer month, Integer day, Integer hour, Integer minute){
        return new Timestamp(new GregorianCalendar(year, month, day,hour,minute,00).getTimeInMillis());
    }
}
