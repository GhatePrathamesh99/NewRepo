package GenerateLog;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1  {

	// 1.What is Log ? --> capturing info/activities during program execution!!
	// 2.Types Of logs ?-->
		// 1. Info
		// 2.warning
		// 3.error
		// 4.fatal

	// 3.How to generate log ?--> using apache log4j API!!
	// 4.How it works ?-->it reads configuration provided in log4j.properties file!
	// 5. Where to create ? ---> create inside resources folder!!
	
	WebDriver driver;
	Logger log = Logger.getLogger(Test1.class);
	
	
	
	@BeforeMethod
	public void InititaliseBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("launching chrome browser");
		driver.get("https://google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("entering into Url");
		log.warn("hey this is just a small warning");
		log.fatal("hey this is just a fatal error massage ");
		log.debug("hey this is just debug massage");
	}
	@Test
	public void Titletest() {
		String ActTitle = driver.getTitle();
		log.info("login page title is--->"+ActTitle);
		String Exptitle = "Google";
		org.testng.Assert.assertEquals(ActTitle, Exptitle, "ActTitle and ExpTitle are not Equal");

	}

	@Test
	public void Linktest() {
		boolean Link = driver.findElement(By.xpath("//a[text()='हिन्दी']")).isEnabled();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
