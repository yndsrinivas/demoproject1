package com.mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
WebDriver driver;
	
	@BeforeMethod()
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	@Test
	public void products()
	{
		driver.get("https://demo.opencart.com/index.php");
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a"));
		a.moveToElement(e).perform();
		WebElement subMenu=driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a"));
		a.moveToElement(subMenu);
		a.click().build().perform();
		List<WebElement> li=driver.findElements(By.xpath("//div[@class='caption']"));
		System.out.println(li.size());
		for(WebElement we:li)
		{
			System.out.println(we.getText());
			
		}
		WebElement count=driver.findElement(By.xpath("//*[@id=\"column-left\"]/div[1]/a[2]"));
		System.out.println(count.getText());
		
	}
	
	@Test
	public void gmail()
	{
		driver.navigate().to("https://www.google.com");
	}
	
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}
	

}
