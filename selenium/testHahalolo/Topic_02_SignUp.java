package testHahalolo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_SignUp {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// name
	@Test
	public void TC_01_SignUpEmptyAll() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("");
		driver.findElement(By.name("nv103")).sendKeys("");
		driver.findElement(By.name("nv108")).sendKeys("");
		driver.findElement(By.name("nv109")).sendKeys("");
		driver.findElement(By.name("repeatPassword")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);
		String emptyFirstName = driver.findElement(By.xpath("//div[contains(text(),'Tên là bắt buộc.')]")).getText();
		AssertJUnit.assertEquals(emptyFirstName, "Tên là bắt buộc.");
		String emptyLastName = driver.findElement(By.xpath("//div[contains(text(),'Họ là bắt buộc.')]")).getText();
		AssertJUnit.assertEquals(emptyLastName, "Họ là bắt buộc.");
		String emptyAccout = driver.findElement(By.xpath("//div[contains(text(),'Tài khoản là bắt buộc.')]"))
				.getText();
		AssertJUnit.assertEquals(emptyAccout, "Tài khoản là bắt buộc.");
		String emptyPassword = driver.findElement(By.xpath("//div[contains(text(),'Mật khẩu là bắt buộc.')]"))
				.getText();
		AssertJUnit.assertEquals(emptyPassword, "Mật khẩu là bắt buộc.");
		String emptyConfirmPassword = driver
				.findElement(By.xpath("//div[contains(text(),'Mật khẩu xác nhận là bắt buộc.')]")).getText();
		AssertJUnit.assertEquals(emptyConfirmPassword, "Mật khẩu xác nhận là bắt buộc.");
	}

	@Test
	public void TC_02_SignUpNameContentNumber() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("12324");
		driver.findElement(By.name("nv103")).sendKeys("12344");
		driver.findElement(By.name("nv108")).sendKeys("phanthithuong@gmail.com");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);
		String firstNameContentNumber = driver.findElement(By.xpath("//div[contains(text(),'Tên không chứa số.')]"))
				.getText();
		AssertJUnit.assertEquals(firstNameContentNumber, "Tên không chứa số.");
		String lastNameContentNumber = driver.findElement(By.xpath("//div[contains(text(),'Họ không chứa số.')]"))
				.getText();
		AssertJUnit.assertEquals(lastNameContentNumber, "Họ không chứa số.");
	}

	@Test
	public void TC_03_SignUpNameContentSpecialChar() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("!@##$%^");
		driver.findElement(By.name("nv103")).sendKeys("!@#$%^&");
		driver.findElement(By.name("nv108")).sendKeys("phanthithuong@gmail.com");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);
		String firstNameContentSpecialChar = driver
				.findElement(By.xpath("//div[contains(text(),'Tên không chứa ký tự đặc biệt.')]")).getText();
		AssertJUnit.assertEquals(firstNameContentSpecialChar, "Tên không chứa ký tự đặc biệt.");
		String lastNameContentSpecialChar = driver
				.findElement(By.xpath("//div[contains(text(),'Họ không chứa ký tự đặc biệt.')]")).getText();
		AssertJUnit.assertEquals(lastNameContentSpecialChar, "Họ không chứa ký tự đặc biệt.");
	}

	// mail and number
	@Test
	public void TC_04_SignUpAccInValid() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("nhat@mailinator.com");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

		String accInValid = driver.findElement(By.xpath("//div[contains(text(),'Số điện thoại không hợp lệ.')]"))
				.getText();
		AssertJUnit.assertEquals(accInValid, "Số điện thoại không hợp lệ.");
	}

	@Test
	public void TC_05_SignUpAccExists() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("0962029520");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

		String accInValid = driver
				.findElement(By.xpath("//div[contains(text(),'Tài khoản đã tồn tại trên hệ thống Hahalolo')]"))
				.getText();
		AssertJUnit.assertEquals(accInValid, "Tài khoản đã tồn tại trên hệ thống Hahalolo");
	}

	@Test
	public void TC_06_SignUpAccInvalid() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("abc");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

		String accInValid = driver.findElement(By.xpath("//div[contains(text(),'Tài khoản không hợp lệ.')]"))
				.getText();
		AssertJUnit.assertEquals(accInValid, "Tài khoản không hợp lệ.");
	}

	// password
	@Test
	public void TC_06_SignUpPasswordLess6Char() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("phanthithuong@gmail.com");
		driver.findElement(By.name("nv109")).sendKeys("1234");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

		String passwordLess6Char = driver
				.findElement(By.xpath("//div[contains(text(),'Giới hạn tối thiểu của Mật khẩu là 6 kí tự.')]"))
				.getText();
		AssertJUnit.assertEquals(passwordLess6Char, "Giới hạn tối thiểu của Mật khẩu là 6 kí tự.");
	}

	// confirm password
	@Test
	public void TC_07_SignUpConfirmPasswordNotMatch() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("phanthithuong@gmail.com");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

		String confirmPasswordNotMatch = driver
				.findElement(By.xpath("//div[contains(text(),'Mật khẩu xác nhận phải trùng với Mật khẩu')]"))
				.getText();
		AssertJUnit.assertEquals(confirmPasswordNotMatch, "Mật khẩu xác nhận phải trùng với Mật khẩu");
	}

	// successfully
	@Test
	public void TC_08_SignUpSuccess() throws InterruptedException {
		driver.get("https://www.hahalolo.com/auth/signin");
		driver.findElement(By.name("nv104")).sendKeys("Phan");
		driver.findElement(By.name("nv103")).sendKeys("Anh");
		driver.findElement(By.name("nv108")).sendKeys("phanthithuong@gmail.com");
		driver.findElement(By.name("nv109")).sendKeys("thuong1");
		driver.findElement(By.name("repeatPassword")).sendKeys("thuong1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='signUpButton']")).click();
		Thread.sleep(3000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
