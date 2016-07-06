package com.calsoft.nexenta.vcp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;


public class SikuliTestMethods extends SikuliTestMethodsBase{
	protected static final Logger _logger = Logger.getLogger(SikuliTestMethods.class);

	public void fluentWait(Pattern imageFile) throws InterruptedException {
		try {
			Thread.sleep(2000);
			Region mIcon = currentScreen.wait(imageFile,20);
			mIcon.highlight();
			mIcon.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String open_Browser(String browser) {
		_logger.info("Trying to open browser "+browser);
		browserName = browser;
		try{
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",_contextLocationForDriver+"/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver",_contextLocationForDriver+"/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "Safari":
				System.setProperty("webdriver.safari.driver",_contextLocationForDriver+"/Safari.exe");
				driver = new SafariDriver();
				break;
			case "Opera":
				System.setProperty("webdriver.opera.driver",_contextLocationForDriver+"/operadriver.exe");
				driver = new OperaDriver();
				break;
			}
			wdw = new WebDriverWait(driver, 60);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch (Exception e){
			_logger.error("Unable to open Browser due to - "+e.getMessage());
			throw new RuntimeException("Unable to open Browser due to - "+e.getMessage());
		}
		_logger.info(browser + " is successfully opened");
		return browser + " is successfully opened";
	}

	public String open_URL(String URL) {
		try {
			_logger.info("Trying to open URL "+URL);
			currentScreen = new Screen();
			driver.get(URL);
			_logger.info("Successfully opened URL "+URL);
			returnMsg = "Successfully opened " + URL;
		} catch (Exception pe) {
			pe.printStackTrace();
			_logger.error("Error occured while opening Url "+ URL + " because " + pe.toString());
			throw new RuntimeException("Error occured while opening Url "+ URL + " because " + pe.toString());
		}
		return returnMsg;
	}

	public String click_Image(List<ExcelPojoForSikuliGUI>listOfPojos) {
		try {
			_logger.info("Trying to Click on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath());
			Pattern patternImage = new Pattern(contextResourceDir+listOfPojos.get(0).getImageFilepath());
			fluentWait(patternImage);
			currentScreen.click();
			_logger.info("Successfully clicked on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath());
			returnMsg = "Successfully clicked on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath();
		} catch (Exception pe) {
			_logger.error("Error occured while clicking on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
			throw new RuntimeException("Error occured while clicking on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
		}
		return returnMsg;
	}
	
	public String select_Dropdown(List<ExcelPojoForSikuliGUI>listOfPojos) {
		try {
			_logger.info("Trying to Click on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath());
			Pattern patternImage = new Pattern(contextResourceDir+listOfPojos.get(0).getImageFilepath());
			fluentWait(patternImage);
			currentScreen.click();
			currentScreen.type(Key.DOWN);
			currentScreen.type(Key.TAB);
			_logger.info("Successfully clicked on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath());
			returnMsg = "Successfully clicked on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath();
		} catch (Exception pe) {
			_logger.error("Error occured while clicking on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
			throw new RuntimeException("Error occured while clicking on the element "+contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
		}
		return returnMsg;
	}

	public String enter_Text(List<ExcelPojoForSikuliGUI>listOfPojos) {
		try {
			_logger.info("Trying to enter the Input "+listOfPojos.get(0).getInput());
			Pattern patternImage = new Pattern(contextResourceDir+listOfPojos.get(0).getImageFilepath());
			fluentWait(patternImage);
			currentScreen.click();
			currentScreen.type("a", KeyModifier.CTRL);
			currentScreen.type(Key.BACKSPACE);
			currentScreen.type(listOfPojos.get(0).getInput());
			_logger.info("Successfully entered the Input "+contextResourceDir+listOfPojos.get(0).getInput());
			returnMsg = "Successfully entered input in " + contextResourceDir+listOfPojos.get(0).getImageFilepath() + " as "	+ listOfPojos.get(0).getInput();
		} catch (Exception pe) {
			_logger.error("Error occured while writing input to "+ contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
			throw new RuntimeException("Error occured while writing input to "+ contextResourceDir+listOfPojos.get(0).getImageFilepath() + " because " + pe.toString());
		}
		return returnMsg;
	}

	public String verify_Image(List<ExcelPojoForSikuliGUI>listOfPojos) {
		try {
			_logger.info("Trying to verify whether object exists on webpage or not ");
			Pattern patternImage = new Pattern(contextResourceDir+listOfPojos.get(0).getImageFilepath());
			fluentWait(patternImage);
			assert(currentScreen.exists(patternImage)!=null);
			_logger.info("Successfully verified object exists on the web page");
			returnMsg = "Successfully verified object exists on the web page";
		} catch (Exception pe) {
			_logger.error("Error occured while verifing object exists on the web page "+ pe.toString());
			throw new RuntimeException("Error occured while verifing object exists on the web page " + pe.toString());
		}
		return returnMsg;
	}

	public void quit_Browser() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
	}

}

