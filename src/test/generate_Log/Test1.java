package generate_Log;

import java.util.concurrent.TimeUnit;

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
	@BeforeMethod
	public String InititaliseBrowser(String url) 
	{
		System.setProperty("webdriver.chrome.driver", ".\\Browsers\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);

		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return url;


	}
	@Test
	public void Titletest() {
		String ActTitle = driver.getTitle();
		System.out.println(ActTitle);
		String Exptitle = "Google";
		org.testng.Assert.assertEquals("ActTitle and ExpTitle are not Equal", Exptitle, ActTitle);

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
