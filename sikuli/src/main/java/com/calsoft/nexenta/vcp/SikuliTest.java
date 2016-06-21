package com.calsoft.nexenta.vcp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SikuliTest extends SikuliTestBase{

	@ BeforeTest
	public void setUp(){  
		_sikuliestMethods.open_Browser("chrome");
		_sikuliestMethods.open_URL("https://172.17.111.66:9443/vsphere-client/#");
		_sikuliestMethods.enter_Text(contextResourceDir+"username.PNG", "root");
		_sikuliestMethods.enter_Text(contextResourceDir+"password.PNG", "vmware");
		_sikuliestMethods.click_Image(contextResourceDir + "login.PNG");
		_sikuliestMethods.verify_Image(contextResourceDir + "verifyHome.PNG");
	}  

	@Test  
	public void testLogo() throws Exception{  
		_sikuliestMethods.click_Image(contextResourceDir + "Home.PNG");
		_sikuliestMethods.click_Image(contextResourceDir + "NexentaConfig.PNG");
		_sikuliestMethods.click_Image(contextResourceDir + "AddNexentaConfig.PNG");
		_sikuliestMethods.select_Dropdown(contextResourceDir + "protocol.PNG");
		_sikuliestMethods.enter_Text(contextResourceDir + "IPAddressInput.PNG", "172.17.111.108");
		_sikuliestMethods.enter_Text(contextResourceDir + "portNumber.PNG", "8457");
		_sikuliestMethods.enter_Text(contextResourceDir + "HostUserName.PNG", "admin");
		_sikuliestMethods.enter_Text(contextResourceDir + "HostPassword.PNG", "nexenta");
		_sikuliestMethods.click_Image(contextResourceDir + "createNexentaCofig.PNG");
		_sikuliestMethods.click_Image(contextResourceDir + "OK.PNG");
		_sikuliestMethods.verify_Image(contextResourceDir + "VerifyIPAddition.PNG");
	} 

	@ AfterTest  
	public void tearDown() throws InterruptedException{
		_sikuliestMethods.click_Image(contextResourceDir + "deleteHost.PNG");
		_sikuliestMethods.click_Image(contextResourceDir + "DeleteConfirmation.PNG");
		_sikuliestMethods.click_Image(contextResourceDir + "OK.PNG");
		_sikuliestMethods.quit_Browser();
	}  
}