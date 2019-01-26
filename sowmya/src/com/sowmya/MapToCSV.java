package com.sowmya;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class MapToCSV
{
    public static void main(String ar[]) throws ParseException
    {
    	
       final String[] header = new String[] { "customerNo", "firstName", "lastName", "birthDate", "mailingAddress",
                "married", "numberOfKids", "favouriteQuote", "email", "loyaltyPoints" };
       
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date now = new Date();
      // Date date = formatter.parse(new Date().toString());
    	
    	Map<String, Object> john = new LinkedHashMap<String, Object>();
        john.put(header[0], "1");
        john.put(header[1], "John");
        john.put(header[2], "Dunbar");
        //john.put(header[3], new GregorianCalendar(1945, Calendar.JUNE, 13).getTime());
        john.put(header[3], formatter.format(now));
        john.put(header[4], "\"1600 Amphitheatre Parkway\nMountain View, CA 94043\nUnited\" States");
        john.put(header[5], null);
        john.put(header[6], null);
        john.put(header[7], "\"May the Force,be with you.\" - Star Wars");
        john.put(header[8], "jdunbar@gmail.com");
        john.put(header[9], 0L);
        
        Map<String, Object> bob = new LinkedHashMap<String, Object>();
        bob.put(header[0], "2");
        bob.put(header[1], "Bob");
        bob.put(header[2], "Down");
        bob.put(header[3], new GregorianCalendar(1919, Calendar.FEBRUARY, 25).getTime());
        bob.put(header[4], "\"1601 Willow Rd.\nMenlo Park, CA 94025\nUnited States\"");
        bob.put(header[5], true);
        bob.put(header[6], 0);
        bob.put(header[7], "\"Frankly, my dear, I don't give a damn.\" - Gone With The Wind");
        bob.put(header[8], "bobdown@hotmail.com");
        bob.put(header[9], 123456L);
        
        List<Map<String,Object>> myList = new LinkedList<Map<String,Object>>();
        
        myList.add(john);
        myList.add(bob);
        
        for(Map<String,Object> list1:myList) {
        	String concat= "";
	
			for(Map.Entry<String, Object> map1: list1.entrySet()) {
					String values1 = map1.getValue() == null? "":map1.getValue().toString(); 
					String val2 = values1.toString();
					String rep2 = val2.replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n");
					if(concat == "")
					{
						concat = rep2;
					}
					else
					concat= concat + "," + rep2;					
			}
			System.out.println(concat);
				
		}
		
        String eol = System.getProperty("line.separator");
        
        try {
			
			Writer writer = new FileWriter("D:\\MapToCSV.csv");
			writer.write("customerNo,firstName,lastName,birthDate,mailingAddress,married,numberOfKids,favouriteQuote,email,loyaltyPoints");
			
				
			for(Map<String,Object> list:myList) {
				writer.write(eol);
				String concat1= "";
				for(Map.Entry<String, Object> map: list.entrySet()) {
						String values = map.getValue() == null? "":map.getValue().toString(); 
						String val = values.toString();
						String rep1 = val.replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n");
						if(concat1 == "")
						{
							concat1 = rep1;
						}
						else
						concat1= concat1 + "," + rep1;	
						
				}
				writer.write(concat1);
					
			}
			writer.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}