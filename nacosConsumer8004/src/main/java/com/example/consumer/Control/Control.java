package com.example.consumer.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 */
@Controller
public class Control {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String hell0() {
        return restTemplate.getForObject("http://nacosProvider8003/index", String.class);
    }
}
