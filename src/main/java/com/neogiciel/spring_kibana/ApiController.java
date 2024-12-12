package com.neogiciel.spring_kibana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.neogiciel.spring_kibana.util.TraceFactory;
import com.neogiciel.spring_kibana.util.Trace;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    
    /*
     * Logger
     */
    //static Trace LOGGER = TraceFactory.getTrace(ApiController.class);
    static Trace LOGGER = TraceFactory.getTrace(ApiController.class);
    //static Trace LOGGER = new TraceFactory().getTrace(ApiController.class);

    // TraceImpl.setLogger(ApiController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        //LOGGER.info("[ApiController : test] : test = ");
        return "test";
    }

    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String param(@RequestParam String id) {

        
        LOGGER.info("[ApiController : param] : *********** debut ("+id +")*********************");
        LOGGER.info("[ApiController : param] : id = "+id);
        LOGGER.info("[ApiController : param] : *********** fin ("+id +")*********************");
        return "[ApiController : param] id ="+id;
    }

}
