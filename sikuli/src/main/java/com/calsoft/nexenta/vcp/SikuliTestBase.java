package com.calsoft.nexenta.vcp;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTestBase {

protected static String contextResourceDir=	System.getProperty("user.dir")+ "/src/test/resources/";
	protected Screen m_screen;  
	WebDriver driver ;
	SikuliTestMethods _sikuliestMethods = new SikuliTestMethods();
//	String HomeImage = "E:/Nexenta/SIKULI/VCP_Images/Home.PNG"; 
}
