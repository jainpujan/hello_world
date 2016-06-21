package com.calsoft.nexenta.vcp;

import java.io.File;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {
	
	public static void main(String[] args) {

		/*TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { com.calsoft.nexenta.vcp.SikuliTest.class });
		testng.addListener(tla);
		testng.run();	*/
		
		/*
		ClassLoader loader = Main.class.getClassLoader();
        System.out.println("Pujan "+loader.getResource("Main.class"));
		
        String classpath = System.getProperty("com.calsoft.nexenta.vcp/SikuliTest.class");
        String[] classpathEntries = classpath.split(File.pathSeparator);
        System.out.println(classpathEntries.toString());*/
        
		File f = new File(System.getProperty("user.dir")+ "/src/test/resources/Home.PNG");
		if(f.exists() && !f.isDirectory()) { 
System.out.println("File Found");
		}
		else{
			System.out.println("File not Found");
		}
		
		
System.out.println(System.getProperty("user.dir")+ "           /sikuli/src/test/resources/Home.PNG");
	
	}
	
	

}
