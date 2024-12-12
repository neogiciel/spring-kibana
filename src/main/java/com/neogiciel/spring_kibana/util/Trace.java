package com.neogiciel.spring_kibana.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neogiciel.spring_kibana.HomeController;

/*
 * Trace
 */
public interface Trace {

    /*
     * setLogger
     */
    public void setLogger(Class<?> arg0);
    
    /*
     * setFile
     */
    public void setFile(String fileName);

    /*
     * info
     */
    public void info(String message);
    /*
     * debug
     */
    public void debug(String message);
    /*
     * Error
     */
    public void error(String message);

  


}
