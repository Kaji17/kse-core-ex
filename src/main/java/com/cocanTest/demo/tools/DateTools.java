package com.cocanTest.demo.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class DateTools {

    /**
     *
     * @return the current date in timestamp
     *
     */
    public Timestamp getCurrentDateInTimestamp() {
        Date today = new Date();
        return new Timestamp(today.getTime());
    }
    public Date convertDate(Date date){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(date);
        try {
            date=df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Timestamp convertStringDateToTimestamp(String value) throws ParseException {
        String dateFormat="";
        if(value.length() == 16) {
            dateFormat = "yyyy-MM-dd HH:mm";
        }else {
            dateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        log.debug(" dateFormat "+dateFormat);


        SimpleDateFormat formatter6=new SimpleDateFormat(dateFormat);
        Date date = formatter6.parse(value);
        return new Timestamp(date.getTime());

    }

}
