package com.adamwandoch.adamstudiesapis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Wandoch
 */

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "ADAM STUDIES APIS : PING SUCCESSFUL";
    }

}
