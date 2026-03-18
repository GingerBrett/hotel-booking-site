package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.convertor.WelcomeMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin
@RequestMapping("/welcome")
public class WelcomeMapping {
    private final WelcomeMessage welcomeMessage;

    public WelcomeMapping(WelcomeMessage welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @RequestMapping(path = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showWelcomeMessage() throws Exception {


    //    String welcomeMessage = "Test Welcome Message!";
        return welcomeMessage.getWelcomeMessage();
    }
}
