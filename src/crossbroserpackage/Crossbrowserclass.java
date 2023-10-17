package crossbroserpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowserclass 
{
	private WebDriver driver;
	private String URL="https://www.facebook.com/";
	@Parameters("browser")
	@BeforeTest
	public void luanchapp(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.out.println("Executing on CHROME");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakhi\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			System.out.println("Executing on edge");
			System.setProperty("webdriver.edge.driver", "C:\\Users\\rakhi\\Desktop\\Automation\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
		}
		else 
		{
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	@Test
	public void test() 
	{
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		username.sendKeys("rakhikrishnanr09@gmail.com");
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys("12344");
		WebElement loginbutton=driver.findElement(By.name("login"));
		loginbutton.click();
	}
	@AfterTest
	public void aftertest()
	
	{
		driver.get(URL);
	}
}

