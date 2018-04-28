package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ParameterizePatientLogin {
	private WebDriver driver;		
    String exePath = "C://Users//Rasika//Desktop//chromedriver.exe";
	
    String ActualTitle = "";
    String ExpectedTitle = "You're on Patient Details Page";
    
	@Test(dataProvider="testMethod",dataProviderClass=DataPrviderClass.class)
	public void testMethod(String username,String password) throws InterruptedException {
	 
	
		 //Go to login page
		
		 driver.findElement(By.xpath("//*[@id=\'uid\']")).sendKeys(username);
		 driver.findElement(By.xpath("/html/body/div/form/div/label/inputBox")).sendKeys(password);
		 driver.findElement(By.name("LoginButton")).click();
		 //check if landing page has been displayed
		 
		 ActualTitle = driver.getTitle();
		 System.out.println(ActualTitle);
		    if(ActualTitle.contentEquals(ExpectedTitle)) {
		    System.out.println("Test Passed: You're logged in");
		 }
		    else {
		   	System.out.println("Tests failed:You're not logged in");
		 }        
		 driver.findElement(By.cssSelector("body > ul > li:nth-child(2) > a")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", exePath);
	  driver = new ChromeDriver();  
	  //System.setProperty("webdriver.chrome.driver", exePath);
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  String baseUrl = "http://localhost/Refactoring/OnlineDentist/Login_Page.php";
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
