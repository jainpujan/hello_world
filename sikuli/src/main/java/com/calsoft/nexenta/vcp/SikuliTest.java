package com.calsoft.nexenta.vcp;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

public class SikuliTest extends SikuliTestBase implements IAnnotationTransformer{

	int countOfRowInDriver=0;
	static int noOfTests;
	String browser;
	public void readFromDriver() throws Exception{  
		actionItemListForDriver = (Map<Integer, ExcelPojoForSikuliGUI>)_excelReadingUtilityForSikuli.getInfoFromDriverFile(inputFilePathForDriver+"Driver.xls");
		noOfTests=actionItemListForDriver.size();
	}	

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,Constructor testConstructor, Method testMethod) {
		try {
			readFromDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ("testVCP".equals(testMethod.getName())) {
			annotation.setInvocationCount(noOfTests);
		}
	}

	@BeforeTest
	public void setUp() throws Exception{  
		try{
			//put in yaml file
			_sikuliestMethods.open_Browser("firefox");
			_sikuliestMethods.open_URL("https://172.17.111.66:9443/vsphere-client/#");
			_sikuliestMethods.enter_Text(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "LoginPageImages/username.PNG", "root"))));
			_sikuliestMethods.enter_Text(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "LoginPageImages/password.PNG", "vmware"))));
			_sikuliestMethods.click_Image(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "LoginPageImages/login.PNG", ""))));
			_sikuliestMethods.verify_Image(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "LoginPageImages/verifyHome.PNG", ""))));
			_sikuliestMethods.click_Image(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "CommonImages/Home.PNG", ""))));
			_sikuliestMethods.click_Image(new ArrayList<ExcelPojoForSikuliGUI>(Arrays.asList(new ExcelPojoForSikuliGUI("", "", "LoginPageImages/NexentaConfig.PNG", ""))));
		}catch(Exception e){
			_sikuliestMethods.quit_Browser();
			System.out.println(e.getMessage());
		}
	}  

	@SuppressWarnings("unchecked")
	@Test()
	public void testVCP() throws Exception{  
		try{
			actionItemListForTestCase = (Map<Integer, List<ExcelPojoForSikuliGUI>>) invokeMethod(_excelReadingUtilityForSikuli, ExcelReadingUtilityForSikuli.class.getMethod
					("getSteps",String.class),inputFilePathForTestCase+actionItemListForDriver.get(countOfRowInDriver).getSectionName()+"/"+
					actionItemListForDriver.get(countOfRowInDriver).getTestCaseID()+".xls");

			for(int i=0;i<actionItemListForTestCase.size();i++){
				if(actionItemListForTestCase.get(i).size()>1){
					ExcelPojoForSikuliGUI firstRowOfStep = actionItemListForTestCase.get(i).get(0);
					invokeMethod(_sikuliestMethods,SikuliTestMethods.class.getMethod(firstRowOfStep.getAction(),List.class),actionItemListForTestCase.get(i));
				}
				else{
					ExcelPojoForSikuliGUI step = actionItemListForTestCase.get(i).get(0);
					invokeMethod(_sikuliestMethods,SikuliTestMethods.class.getMethod(step.getAction(),List.class),actionItemListForTestCase.get(i));
				}
				countOfRowInDriver++;
				}
		}catch(Exception e){
			_sikuliestMethods.quit_Browser();
			e.printStackTrace();
			
		}
	} 

	@ AfterTest  
	public void tearDown() throws InterruptedException{
		_sikuliestMethods.quit_Browser();
	}


}