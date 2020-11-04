package com.example.nacos8003.Control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
public class Control {
    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    @ResponseBody
    String index() {
        return port;
    }
}
