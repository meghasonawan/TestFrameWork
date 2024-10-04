package com.qc.testng.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

	public Properties readprob() throws IOException
	{
		FileInputStream fis =new FileInputStream("src/test/resources/config.properties");
			Properties prob=new Properties();	
			prob.load(fis);
			return prob;
			
	}
	
}
