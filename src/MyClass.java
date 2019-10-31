import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class MyClass {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();


@Before public void setUp() throws Exception {
	
	// Create object of ChromeOption class
	ChromeOptions options = new ChromeOptions();
    // Disable notifications
	options.addArguments("--disable-notifications");

	
	//ChromeDriver
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\egoodman\\selenium-java-3.141.59\\chromedriver.exe");
	// Initialize browser with notifications disabled 
	driver=new ChromeDriver(options);
	// Open SalesForce
	driver.get("https://cte1926--qa.lightning.force.com/lightning/page/home");
	// Maximize browser
	driver.manage().window().maximize();
	//input user name and password
	WebElement userName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
	WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	userName.sendKeys("egoodman@carolinacat.com");
	password.sendKeys("Hulk0919!");
	//Log in
	WebElement logIn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
	logIn.click();
	
	/*
	if(userName.isDisplayed()) {
		System.out.println("Login has FAILED");
	} else {
		System.out.println("Log was SUCCESSFUL");
	}
	*/

}	

//Test1 - Open the Opportunities list in an Account
@Test public void Test1() throws Exception {
		

	System.out.println("-----------------------------");
	System.out.println("TEST 1 RESULTS: ");
	//Create menu element and click the menu item
	//WebElement Accounts = driver.findElement(By.id("Accounts"));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://cte1926--qa.lightning.force.com/lightning/o/Account/home");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//Opportunities selection
	WebElement opportunitiesButton = driver.findElement(By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/force-quick-link-container/article/div[2]/ul/li[12]/force-related-list-quick-link/div/div[2]/a"));
	opportunitiesButton.click();
	WebElement opportunities = driver.findElement(By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div/div[1]/div[1]/div[1]/div/div/h1"));
	if(opportunities.isDisplayed()) {
		System.out.println("The Opportunies page is open - Pass");
	}else {
		fail("The Opportunies page did not appear");
	}


}

//Test2 - Open the Installed Products list in an Account
@Test public void Test2() throws Exception {
		

	System.out.println("-----------------------------");
	System.out.println("TEST 2 RESULTS: ");
	//Create menu element and click the menu item
	//WebElement Accounts = driver.findElement(By.id("Accounts"));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://cte1926--qa.lightning.force.com/lightning/o/Account/home");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement accountName = driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a"));
	accountName.click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//Installed Product selection
	WebElement installedProdButton = driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/force-quick-link-container/article/div[2]/ul/li[6]"));
	installedProdButton.click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//Open installed product
	WebElement installedProd = driver.findElement(By.xpath("//*[text()='IMPAQ-Other-5988221']"));
	if(installedProd.isDisplayed()) {
		System.out.println("The Installed Product is Present - Pass");
		

	}else {
		fail("The installed Product is not present");
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	installedProd.click();
	Thread.sleep(5000);

	
}

@After public void tearDown() throws Exception {
	/*
	//Open the User Tab and Log Out of SalesForce 
	WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"tt-for-143:205;a\"]"));
	userMenu.click();
	WebElement logOut = driver.findElement(By.xpath("//*[@id=\"content_105:1067;a\"]/div/div[2]/div/a[2]"));
	logOut.click();
	*/
	driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
	}
	System.out.println("-----------------------------");
}

//action to check if element is present
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}