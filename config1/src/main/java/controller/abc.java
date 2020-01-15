package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class abc {

    @Value("${logging.path}")
    private String message;

    @GetMapping("/test")
    public String test() {
        return message;
    }
}
