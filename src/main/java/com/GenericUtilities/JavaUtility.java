package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method is used to get random number
	 * @return
	 */
    public int random()
     {
	 Random ran= new Random();
	 int random= ran.nextInt(1000);
	 return random;
	 
     }
    
    /**
     * this method is used to get SystemDate
     * @return
     */
    public String getSystemDate()
    {
    	Date dt= new Date();
    	String date= dt.toString();
    	return date;
    }
    
    /**
     * this method is used to get SystemDate in customised format 
     * @return
     */
    public String formatSystemDate()
    {
    	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    	Date dt= new Date();
    	String getDateAndTime=dateformat.format(dt);
    	return getDateAndTime.replace(":", "-");
    	 
    }
}
