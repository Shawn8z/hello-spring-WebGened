package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class HelloController {


    //Handels request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "GoodBye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String coder) {
        return "Hello, " + coder + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request ot /hello
                "<input type='text' name='coder'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "<body>" +
                "<html>";
    }
}
