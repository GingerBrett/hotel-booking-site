package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.convertor.TimeConversion;
import edu.wgu.d387_sample_code.convertor.WelcomeMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin
@RequestMapping("/time")
public class TimeMapping {
    private final TimeConversion timeConversion;

    public TimeMapping(TimeConversion timeConversion) {
        this.timeConversion = timeConversion;
    }

    @RequestMapping(path = "/conversion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showTimes() throws Exception {


        return timeConversion.convertTime();
    }
}
