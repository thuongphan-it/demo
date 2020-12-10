package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;

@Test
public class Topic_01_Locator_selenium {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// open browser
		driver = new ChromeDriver();
		// wait for action
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// phong to browser
		driver.manage().window().maximize();

	}

	public void TC_01_LoginWithEmptyEmailAndPassword() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.id("signin-identity")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);
		String emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'Tài khoản là bắt buộc.')]"))
				.getText();
		Assert.assertEquals(emailErrorMessage, "Tài khoản là bắt buộc.");
		String passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'Mật khẩu là bắt buộc.')]"))
				.getText();
		Assert.assertEquals(passwordErrorMessage, "Mật khẩu là bắt buộc.");
	}

	public void TC_02_LoginWithIncorrectEmail() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.id("signin-identity")).sendKeys("0962029526");
		driver.findElement(By.id("password")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);
		String emailError = driver.findElement(By.xpath("//div[@id='js-error-login']")).getText();
		Assert.assertEquals(emailError, "Tên tài khoản hoặc mật khẩu sai");

	}

	public void TC_03_LoginWithPasswordLess6Characters() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.id("signin-identity")).sendKeys("0962029520");
		driver.findElement(By.id("password")).sendKeys("thuon");
		Thread.sleep(3000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);
		String nameLessSixChar = driver
				.findElement(By.xpath("//div[contains(text(),'Giới hạn tối thiểu của Mật khẩu là 6 kí tự.')]"))
				.getText();
		Assert.assertEquals(nameLessSixChar, "Giới hạn tối thiểu của Mật khẩu là 6 kí tự.");

	}

	public void TC_04_LoginWithInvalidEmail() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.id("signin-identity")).sendKeys("ádsadsadasdasd");
		driver.findElement(By.id("password")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);
		String invalidEmail = driver.findElement(By.xpath("//div[contains(text(),'Tài khoản không hợp lệ.')]"))
				.getText();
		Assert.assertEquals(invalidEmail, "Tài khoản không hợp lệ.");

	}

	public void TC_05_LoginWithValidEmailAndPassword() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.id("signin-identity")).sendKeys("0962029520");
		driver.findElement(By.id("password")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.className("btn-login")).click();
		Thread.sleep(3000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
