package com.neogiciel.spring_kibana;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class HomeController {

    /*
     * Logger
     */
    static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        LOGGER.info("myapplication-HomeController [test] : test = ");
        return "test";
    }

}
