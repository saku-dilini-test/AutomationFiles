package TestNGTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Rest_password {
 
	public String baseURL = "https://appmakercms.otenro.com/app/login";//"https://appmaker.otenro.com/home/";
	public String ResetPasswordURL = "https://appmaker.otenro.com/app/resetPassword/eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjVkOTJmNDAwMTZlYmUyNmQ1YjhiOGVmZCIsImVtYWlsIjoic2FrdW50aGFsYW5mbUBnbWFpbC5jb20iLCJpYXQiOjE1NzAwOTIwMDB9.kr02qnxDVijmzwhnrb717czXZA7Hf99ikGgrcd3XQZg";
	String driverPath = "C:\\Appmaker Automation\\ChromD\\chromedriver.exe";
	public WebDriver driver;
	public String Appname;

	/*
	 * Login to the CMS Create new app Add new Category Add new page Add logo Change
	 * background color Font color Engage full section after app installation
	 * publish full section test
	 */

	@BeforeTest
	public void VerifyFrames() throws Exception {
		

		System.out.println("Launching Chrome Browser ");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Test case TC01 = Log in to the system with correct credentials
	@Test(priority = 1 )
	public void SendResetPasswordLink() throws Exception {
		
		driver.get(baseURL);
		Thread.sleep(4000);
		
		driver.findElement(By.name("forget password")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.name("email")).sendKeys("sdasdasdasd");
		System.out.println("Incorrect Email entered");
		Thread.sleep(4000);
		
		 String actual_msgA = driver.findElement(By.cssSelector(".error:nth-child(4)")).getAttribute("innerHTML");
			String expectA= "Enter a proper email";
			
			if (actual_msgA.contains(expectA)) {
				System.out.println("---->Validation passed = " + actual_msgA);
			} else {
				System.out.println("---->Test Case Failed = " + actual_msgA);
			}
			Thread.sleep(2000);
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("sakud74@gmail.com");
		Thread.sleep(4000);
		
		driver.findElement(By.name("Send me a verification link")).click();
		Thread.sleep(4000);
		
	}
	
	@Test(priority = 2 )
	public void LoginToGmail() throws Exception {
		

		  driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		  Thread.sleep(4000);
	      driver.findElement(By.name("identifier")).sendKeys("sakud74@gmail.com",Keys.ENTER);
	      System.out.println("Email entered");
	      Thread.sleep(3000);
	      driver.findElement(By.name("password")).sendKeys("Saku@123",Keys.ENTER);
	      System.out.println("Password Entred");
	      Thread.sleep(6000);
	      
	      driver.findElement(By.id(":2f")).click();
	      System.out.println("Email clicked");
	      Thread.sleep(4000);
	      
	      driver.findElement(By.linkText("Click here to verify your email link.")).click();
	      System.out.println("Password reset link clicked");
	      Thread.sleep(6000);
	      

	}
	
	@Test(priority = 3 )
	public void CheckNewPasswordValidation() throws Exception {
		
		
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(0));
		    driver.close();
		    driver.switchTo().window(tabs2.get(1));
		
			driver.findElement(By.name("password")).sendKeys("saku");
			System.out.println("Incorrect New Password entred");
			Thread.sleep(2000);
	      
	      String actual_msg1 = driver.findElement(By.cssSelector(".password-area:nth-child(2) > .help-block:nth-child(5) > .error")).getAttribute("innerHTML");
			String expect1= "Password should have at least 7 characters.";
			
			if (actual_msg1.contains(expect1)) {
				System.out.println("---->Validation passed = " + actual_msg1);
			} else {
				System.out.println("---->Test Case Failed = " + actual_msg1);
			}
			Thread.sleep(2000);
			
			driver.findElement(By.name("password")).sendKeys("sakusdfdsdfsdfsdf");
			System.out.println("Incorrect New Password entred to check pssword pattern");
			Thread.sleep(2000);
		      
		      String actual_msg2 = driver.findElement(By.cssSelector(".help-block:nth-child(6) > .error")).getAttribute("innerHTML");
				String expect2= "Password should have at least one lower or Upper letter and one number";
				
				if (actual_msg2.contains(expect2)) {
					System.out.println("---->Validation passed = " + actual_msg2);
				} else {
					System.out.println("---->Test Case Failed = " + actual_msg2);
				}
				Thread.sleep(2000);
				
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys("Saku@1234");
				System.out.println("correct New Password entred");
				Thread.sleep(2000);
	}	      
	      
	@Test(priority = 4 )
	public void CheckConfirmPasswordValidation() throws Exception {	      
	      
	      driver.findElement(By.name("password_confirm")).sendKeys("Saku@123ddd");
	      System.out.println("Incorrect Confirm Password entred");
	      Thread.sleep(4000);
	      
	      String actual_msg2 = driver.findElement(By.cssSelector(".reset-margin-right .error")).getAttribute("innerHTML");
			String expect2= "Password must match.";
			
			if (actual_msg2.contains(expect2)) {
				System.out.println("---->Validation passed = " + actual_msg2);
			} else {
				System.out.println("---->Test Case Failed = " + actual_msg2);
			}
			Thread.sleep(2000);
	      
		  driver.findElement(By.name("password_confirm")).clear();
		  driver.findElement(By.name("password_confirm")).sendKeys("Saku@1234");
		  System.out.println("correct Confirm Password entred");
		  Thread.sleep(4000);
	      
	      driver.findElement(By.name("Ok_Button")).click();
	      System.out.println("Ok_Button clicked");
	      Thread.sleep(4000);
	      
	      String actual_msgA = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div/div[2]")).getAttribute("innerHTML");
			String expectA= "Password successfully changed";
			
			if (actual_msgA.contains(expectA)) {
				System.out.println("---->Validation passed = " + actual_msgA);
			} else {
				System.out.println("---->Test Case Failed = " + actual_msgA);
			}
			Thread.sleep(2000);
	      
		
	}
	
}
