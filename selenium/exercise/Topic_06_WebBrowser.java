package exercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_WebBrowser {
	WebDriver driver;

	@Test
	public void TC_01_Verify_Url() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[(@title='My Account')]")).click();
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, "http://live.demoguru99.com/index.php/customer/account/login/");

		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a[@title='Create an Account']")).click();
		String accUrl = driver.getCurrentUrl();
		Assert.assertEquals(accUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[(@title='My Account')]")).click();
		String loginUrl = driver.getTitle();
		Assert.assertEquals(loginUrl, "Customer Login");

		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a[@title='Create an Account']")).click();
		String accUrl = driver.getTitle();
		Assert.assertEquals(accUrl, "Create New Customer Account");

	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[(@title='My Account')]")).click();
		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a[@title='Create an Account']")).click();
		String accUrl = driver.getCurrentUrl();
		Assert.assertEquals(accUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
		driver.navigate().back();
		String loginUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginUrl, "http://live.demoguru99.com/index.php/customer/account/login/");
		driver.navigate().forward();
		String accTitle = driver.getTitle();
		Assert.assertEquals(accTitle, "Create New Customer Account");
	}

	@Test
	public void TC_04_Get_Page_Source_Code() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[(@title='My Account')]")).click();
		String loginUrl = driver.getPageSource();

		loginUrl.contains("Login or Create an Account");
		System.out.print(loginUrl);

		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a[@title='Create an Account']")).click();
		String accUrl = driver.getPageSource();
		accUrl.contains("Create an Account");
	}

	@BeforeClass
	public void beforeClass() {
		// open
		driver = new ChromeDriver();
		// waiting
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// zoom creen
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
