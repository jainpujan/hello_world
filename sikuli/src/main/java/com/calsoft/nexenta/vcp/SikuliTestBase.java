package com.calsoft.nexenta.vcp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTestBase {

	protected static String contextResourceDir=	System.getProperty("user.dir")+ "/src/test/resources/Images/";
	protected static String inputFilePathForTestCase=	System.getProperty("user.dir")+ "/src/test/resources/TestCase/";
	protected static String inputFilePathForDriver=	System.getProperty("user.dir")+ "/src/test/resources/Driver/";
	protected Screen m_screen;  
	WebDriver driver ;
	SikuliTestMethods _sikuliestMethods = new SikuliTestMethods();
	Map<Integer, ExcelPojoForSikuliGUI> actionItemListForDriver;
	Map<Integer, List<ExcelPojoForSikuliGUI>> actionItemListForTestCase;
	ExcelReadingUtilityForSikuli _excelReadingUtilityForSikuli = new ExcelReadingUtilityForSikuli();


	protected static Object invokeMethod(final Object object, final Method method, final Object... args) {
		return invokeMethodsInSequence(object, method, new LinkedList<Object[]>() {{ add(args); }} );
	}


	protected static Object invokeMethodsInSequence(final Object object, final Method method, final LinkedList<Object[]> listOfArgs) {
		Object returnValue = null;
		try {
			for (Object[] args : listOfArgs) {
				returnValue = method.invoke(object, args);
			}
		} catch (Throwable exception) {
			handleException(exception);
		}
		return returnValue;
	}

	private static void handleException(Throwable exception) {
		if (exception instanceof InvocationTargetException) {
			Throwable cause = exception.getCause();
			System.out.println(cause);
			throw new RuntimeException(exception);
		} else if (exception != null) {
			throw new RuntimeException("Failed to invoke method.", exception);
		}
	}

}
