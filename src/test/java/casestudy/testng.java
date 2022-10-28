package casestudy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng {
	
	String curl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void test1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(curl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority=0)
	public void test2() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(enabled=true,priority=1)
	public void test3() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> lp=driver.findElements(By.tagName("a"));
		int sizes=lp.size();
		System.out.println("Total links of the page:"+sizes);
	}
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority=2)
	public void test5() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> li=driver.findElements(By.xpath("//*[@role='row']"));
		int size=li.size();
		System.out.println("Total size of the webelements:"+size);
		for(int i=0;i<=size;i++) 
		{
			if(i==6) {
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(i).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(i).click();
				driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@AfterTest
	public void test4() {
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.close();
	}
	
	
	
	
	
	
	

}
