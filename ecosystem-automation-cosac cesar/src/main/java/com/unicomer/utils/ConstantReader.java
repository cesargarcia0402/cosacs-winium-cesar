package com.unicomer.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstantReader {

    private static ConstantReader instance;
    private Map<String,String> properties;

    private String enviroment;

    private ConstantReader(){
        properties = new HashMap<>();
    }

    private void readFile(){

        try {
            File text = new File("src/test/resources/uat-cosacs-properties.properties");
            Scanner scnr = new Scanner(text);

            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                propertiesHandler(line);
            }
            scnr.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    private void propertiesHandler(String line){
        String key = line.substring(0,line.indexOf("="));
        String val = line.substring(line.indexOf("=")+1);
        byte[] decodedBytes = Base64.getUrlDecoder().decode(val);
        val = new String(decodedBytes);
        properties.put(key, val);
    }

    public static synchronized ConstantReader getInstance(){
        if(instance == null){
            instance = new ConstantReader();
        }
        return instance;
    }

    public String getProperties(String key) {
        return properties.get(key);
    }

    public void setEnv(){
        readFile();
    }

    public String getEnv(){
        return enviroment;
    }

}
