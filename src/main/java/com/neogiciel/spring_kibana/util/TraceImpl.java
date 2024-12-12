package com.neogiciel.spring_kibana.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TraceImpl implements Trace {
    
    
    /*
    *Logger
    */
    Logger logger; 
    
    
    /*
     * setLogger
     */
    public void setLogger(Class<?> arg0){
        logger = LoggerFactory.getLogger(arg0);
    }
    
    /*
     * setFile
     */
    public void setFile(String fileName){
    }
    
    /*
     * info
     */
    public void info(String message){
        logger.info(message);

    }
    /*
     * debug
     */
    public void debug(String message){
        logger.debug(message);

    }
    /*
     * Error
     */
    public void error(String message){
        logger.error(message,"error", new Exception(message));
    }

}
