package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
       private static FileInputStream fileInputStream;
       private static Properties property;
        
       public static void setupProperty() throws IOException {
    	   File file = new File("C:\\Users\\Dinesh\\eclipse-workspace\\Maven_Apr\\src\\main\\resources\\TestData.properties");
             try {
				fileInputStream = new FileInputStream(file);
				property = new Properties();
				property.load(fileInputStream);
			} catch (FileNotFoundException e) {
			    Assert.fail("ERROR: OCCURE DURING FILE LOADING");
			} catch (Exception e) {
				Assert.fail("ERROR :OCCURE DURING FILE READING");
			}
       
     }
        public static String getDataProperty(String value) throws IOException {
			setupProperty();
			String data = property.getProperty(value);
        	return data;
        	
        }

       public static void main(String[] args) throws IOException {
    	   System.out.println(getDataProperty("browser"));
       }









}
