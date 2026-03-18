package edu.wgu.d387_sample_code.convertor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeConversion {

    public String[] convertTime(){
        String easternTime;
        String mountainTime;
        String utcTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDateTime time = LocalDateTime.of(2025,10,11, 15,30);

        ZonedDateTime zUtcTime = time.atZone(ZoneId.of("UTC"));
        // Convert to other zones
        ZonedDateTime zEasternTime = zUtcTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zMountainTime = zUtcTime.withZoneSameInstant(ZoneId.of("America/Denver"));

        easternTime = zEasternTime.format(formatter);
        mountainTime = zMountainTime.format(formatter);
        utcTime = zUtcTime.format(formatter);


        return new String[]{easternTime, mountainTime, utcTime};
    }
}
