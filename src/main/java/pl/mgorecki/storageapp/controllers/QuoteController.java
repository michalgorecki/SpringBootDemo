package pl.mgorecki.storageapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import pl.mgorecki.storageapp.domain.Quote;

@RestController
public class QuoteController {
    private static final String REST_REQUEST = "https://gturnquist-quoters.cfapps.io/api/random";
    RestTemplate restTemplate = new RestTemplate();
    Quote quote;

    @GetMapping(value = "/quote")
    public ModelAndView quote(){
        System.out.println("quote()");
        quote = restTemplate.getForObject(REST_REQUEST,Quote.class);
        ModelAndView mav = new ModelAndView("quote");
        mav.addObject("quote",quote.getValue().getQuote());
        return mav;
    }
}
