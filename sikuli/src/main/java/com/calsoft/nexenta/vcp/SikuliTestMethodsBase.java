package com.calsoft.nexenta.vcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;


public class SikuliTestMethodsBase {
	
	protected static WebDriver driver;
	static WebDriverWait wdw;
	static String browserName;
	Screen currentScreen;
	protected static String returnMsg;
	protected static String _contextLocationForDriver = "E:/Nexenta/updated_Source/SourceTree/F-TAF_Tests_5.0/tests-5.0/src/test/resources/Fusion/Driver";

}
