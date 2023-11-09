package BankSystemPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;


public class TestNewDateClass {

    public static void main(String[] args) {
        //old way -- Deprecated
        Date d1 = new Date();

        //new way
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear()+","+now.getMonth()+","+now.getDayOfMonth()+","+now.getDayOfWeek().name());
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime.getHour()+":"+nowTime.getMinute()+":"+nowTime.getSecond());
        // instead of having date and time seperately then we can combine them as following
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.getYear()+","+dateTime.getMonth()+","+dateTime.getDayOfMonth()+","+dateTime.getDayOfWeek().name()+","+dateTime.getHour()+":"+dateTime.getMinute()+":"+dateTime.getSecond());

    }
}
