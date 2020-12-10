package exercise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic_04_05_Xpath_And_CSS {
	WebDriver driver;

	@Test

	public void TC1_LoginWithEmptyEmailAndPassword() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.name("login[username]")).sendKeys("");
		driver.findElement(By.name("login[password]")).sendKeys("");
		driver.findElement(By.id("send2")).click();
		String errorEmailMessenge = driver.findElement(By.id("advice-required-entry-email")).getText();
		AssertJUnit.assertEquals(errorEmailMessenge, "This is a required field.");
		String errorPassMessenge = driver.findElement(By.id("advice-required-entry-pass")).getText();
		AssertJUnit.assertEquals(errorPassMessenge, "This is a required field.");
		Thread.sleep(3000);

	}

	@Test
	public void TC2_LoginWithInvalidEmail() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.name("login[username]")).sendKeys("1234@123.123");
		driver.findElement(By.name("login[password]")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		String errorEmailInvalid = driver.findElement(By.id("advice-validate-email-email")).getText();
		AssertJUnit.assertEquals(errorEmailInvalid,
				"Please enter a valid email address. For example johndoe@domain.com.");

		Thread.sleep(3000);

	}

	@Test
	public void TC3_LoginWithPasswordLess6Characters() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123");
		driver.findElement(By.id("send2")).click();
		String passLess6Characters = driver.findElement(By.id("advice-validate-password-pass")).getText();
		AssertJUnit.assertEquals(passLess6Characters,
				"Please enter 6 or more characters without leading or trailing spaces.");

		Thread.sleep(3000);

	}

	@Test
	public void TC4_LoginWithIncorrectEmailPassword() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123123123");
		driver.findElement(By.id("send2")).click();
		String incorrectEmailPassword = driver
				.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText();
		AssertJUnit.assertEquals(incorrectEmailPassword, "Invalid login or password.");

		Thread.sleep(3000);

	}

	public static String randomEmail() {
		String userName = "thuongphan";
		String domainEmail = "@gmail.com";
		Random random = new Random();

		return userName + random.nextInt(2000000) + domainEmail;
	}

	String firstName = "Thuong", middeName = "Thi", lastName = "Phan";
	String email = randomEmail();

	@Test
	public void TC5_CreateANewAccount() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(
				By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/a[1]")).click();
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("middlename")).sendKeys(middeName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(randomEmail());
		driver.findElement(By.id("password")).sendKeys("thuong");
		driver.findElement(By.id("confirmation")).sendKeys("thuong");
		driver.findElement(By.id("is_subscribed")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();

		String message = driver
				.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]"))
				.getText();
		AssertJUnit.assertEquals(message, "Thank you for registering with Main Website Store.");
		// step7 String name =
		driver.findElement(By.xpath("//div[@class='box-content']//p[contains(.,'Thuong Thi Phan')]")).getText();
		Thread.sleep(3000);

	}

	@Test
	public void TC6_LoginWithValidEmailPassword() throws InterruptedException {
		driver.get("http://live.demoguru99.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/a[1]/span[2]")).click();
		driver.findElement(By.xpath("//header/div[1]/div[5]/div[1]/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("login[username]")).sendKeys(randomEmail());
		driver.findElement(By.name("login[password]")).sendKeys("thuong");
		Thread.sleep(5000);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
		String myDashboardtext = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		Assert.assertEquals(myDashboardtext, "MY DASHBOARD");
		// or
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(),
				"Hello, Thuong Thi Phan");
		String contactInformationText = driver
				.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']//p")).getText();
		Assert.assertTrue(contactInformationText.contains("Thuong Thi Phan"));

//		driver.findElement(By.xpath("//div[@class='box-content']//p[contains(.,'Thuong Thi Phan')]")).getText();
//		
//		driver.findElement(By.xpath("//div[@class='box-content']//p[contains(.,email]")).getText();
//		
		Assert.assertTrue(contactInformationText.contains(email));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();

		Thread.sleep(3000);

	}

	@BeforeClass
	public void beforeClass() {
		// open broser
		driver = new ChromeDriver();

		// waiting
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// zoom the screen
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
