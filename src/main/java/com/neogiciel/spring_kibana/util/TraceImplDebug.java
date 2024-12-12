package com.neogiciel.spring_kibana.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TraceImplDebug implements Trace{
    
    /*
    *fileName
    */
    String fileName; 
    
    /*
    *Logger
    */
    Logger logger; 
    
    /*
    *headerTrace
    */
    String headerTrace; 
    
       
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
        this.fileName = fileName;
    }
    
    /*
     * writeFile
     */
    private void writeFile(String message){
        try{
            File file = new File(fileName);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(message+"\r\n");
            br.close();
            fr.close();

        }catch(Exception e){
            logger.info("[TraceImplDebug] Ereur writeFile : "+e.getMessage());
        }
    }

    /*
     * getHeader
     */
    private String getHeader(){
        
        //Recherche le Header
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request.getHeader("id-trace");

        }
        return null;
    }

    /*
     * info
     */
    public void info(String message){
        if(getHeader()!=null){
            logger.info("id-trace: "+getHeader()+" "+message);
            if(fileName!=null){
                writeFile("id-trace: "+getHeader()+" "+message);
            }    
        }else{
            logger.info(message);
            if(fileName!=null){
                writeFile(message);
            }
        }

    }
    /*
     * debug
     */
    public void debug(String message){
        if(getHeader()!=null){
            logger.debug("id-trace: "+getHeader()+" "+message);
            if(fileName!=null){
                writeFile("id-trace: "+getHeader()+" "+message);
            }    
        }else{
            logger.debug(message);
            if(fileName!=null){
                writeFile(message);
            }
        }

    }
    /*
     * Error
     */
    public void error(String message){

        if(getHeader()!=null){
            logger.error("id-trace: "+getHeader()+" "+message,"error", new Exception(message));
            if(fileName!=null){
                writeFile("id-trace: "+getHeader()+" "+message);
            }    
        }else{
            logger.error(message,"error", new Exception(message));
            if(fileName!=null){
                writeFile(message);
            }
        }

    }

}
