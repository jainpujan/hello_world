package sikuli;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.runners.Parameterized.Parameter;



//@RunWith(Parameterized.class)
public class RunTenTimes implements IAnnotationTransformer{
//    @Parameter.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[10][0]);
    }

    final static int io=method1();
    
    public RunTenTimes() {
    }
    private static int method1() {
		return 90;
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println("I am here before loop");
		if ("runsTenTimes".equals(testMethod.getName())) {
			System.out.println("I am here in loop");
			annotation.setInvocationCount(10);
		}
	}

//    @Test(invocationCount=10)
    @Test()
    public void runsTenTimes() {
//    	transform(ITestAnnotation annotation, "RunTenTimes", "RunTenTimes", "runsTenTimes");
        System.out.println("run");
    }

}