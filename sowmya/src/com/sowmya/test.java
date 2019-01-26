package com.sowmya;

import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

class test
{
    public static void main(String ar[])
    {
        test a = new test();
        try{
            a.blowUp();
            System.out.println("a");
        }
        catch (IOException  | SQLException e ) {
			System.out.println("c");
		}
        
    
    }

	 void blowUp() throws IOException,SQLException{
		
		
	}
}