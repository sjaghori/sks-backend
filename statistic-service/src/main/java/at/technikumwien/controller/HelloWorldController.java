package at.technikumwien.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources/statistic")
@Log
public class HelloWorldController {

    @Value("${message.public}")
    private String message;

    public void sayHello() {
        System.out.println(message);
    }

    @GetMapping
    public String returnHello() {
        return "message";
    }
}
