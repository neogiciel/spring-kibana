package com.neogiciel.spring_kibana.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
public class TraceFactory {

    static Logger LOGGER = LoggerFactory.getLogger(TraceFactory.class);


   public static Trace getTrace(Class<?> arg0){

        Trace trace; 
        if(TraceProperties.getProperty("trace.type").equals("FILE")) {
            trace = new TraceImplDebug();
            trace.setLogger(arg0);
            trace.setFile(TraceProperties.getProperty("trace.file"));
        }else{
            trace = new TraceImpl();
            trace.setLogger(arg0);
        }

        return trace;
    } 
}
