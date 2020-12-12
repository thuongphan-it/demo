package exercise;

import org.testng.annotations.Test;

import bsh.ParseException;

import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;

public class Topic_07_08_Textbox_TextArea_Dropdown_CustomDropdown {
	WebDriver driver;
	WebElement element;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

//	public static String randomEmail() {
//		String userName = "thithi";
//		String domain = "@gmail.com";
//		Random random = new Random();
//
//		return userName + random.nextInt(2000) + domain;
//	}
//
//	public String converDateForFormat(String dateRequest) throws ParseException {
//		// constructor is called while creating object
//		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = null;
//		try {
//			date = (Date) formatter.parse(dateRequest);
//		} catch (java.text.ParseException e) {
//			e.printStackTrace();
//		}
//		SimpleDateFormat newformater = new SimpleDateFormat("yyyy-MM-dd");
//		return newformater.format(date);
//	}
//
//	@Test
//	public void TC_01_Handle_Textbox_Testarea() throws InterruptedException, ParseException {
//		// step1
//		driver.get("http://demo.guru99.com/v4/");
//		// step2
//		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr299095");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("EvAqedY");
//		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
//		Thread.sleep(3000);
//		// step 3
//		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
//		Thread.sleep(3000);
//		// step 4
//		String name = "Selenium Online";
//		String gender = "male";
//		String dob = "06-06-2020";
//		String addr = "123 Address";
//		String city = "Ho Chi Minh";
//		String state = "Thu Duc";
//		String pinno = "123456";
//		String phone = "1234567897";
//		String email = randomEmail();
//		String pass = "123456";
//		driver.findElement(By.name("name")).sendKeys(name);
//		WebElement genderMale = driver.findElement(By.xpath("//input[@value='m']"));
//		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);
//		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(addr);
//		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
//		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
//		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pinno);
//		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(phone);
//		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
//		if (genderMale.isSelected()) {
//
//		} else {
//			genderMale.click();
//		}
//
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='sub']")).click();
//		Thread.sleep(3000);
//		// step5
//		String id = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
//		System.out.println(id);
//
//		// step 6 verify
//		String newDob = converDateForFormat(dob);
//		Assert.assertEquals(name,
//				driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
//		Assert.assertEquals(gender,
//				driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText());
//		Assert.assertEquals(newDob,
//				driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
//		Assert.assertEquals(addr,
//				driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
//		Assert.assertEquals(city, driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
//		Assert.assertEquals(state,
//				driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
//		Assert.assertEquals(pinno, driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
//		Assert.assertEquals(phone,
//				driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
//		Assert.assertEquals(email,
//				driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
//		// step 7
//		driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
//		driver.findElement(By.name("cusid")).sendKeys(id);
//		Thread.sleep(3000);
//		driver.findElement(By.name("AccSubmit")).click();
//		// step 8
//		Assert.assertEquals(name, driver.findElement(By.name("name")).getAttribute("value"));
//		Assert.assertEquals(addr, driver.findElement(By.name("addr")).getText());
//		Thread.sleep(3000);
//		// step9
//		String editAddr = "400 Phan Thiet";
//		String editCity = "Phan Thiet";
//		String editState = "Binh Tan";
//		String editPin = "098765";
//		String editPhone = "09876543321";
//		String editEmail = "nini@gmail.com";
//		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
//		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(editAddr);
//		driver.findElement(By.xpath("//input[@name='city']")).clear();
//		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(editCity);
//		driver.findElement(By.xpath("//input[@name='state']")).clear();
//		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(editState);
//		driver.findElement(By.xpath("//input[@name='pinno']")).clear();
//		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(editPin);
//		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();
//		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(editPhone);
//		driver.findElement(By.xpath("//input[@name='emailid']")).clear();
//		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(editEmail);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
//		// step 10
//		Assert.assertEquals(editAddr,
//				driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
//		Assert.assertEquals(editCity,
//				driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
//		Assert.assertEquals(editState,
//				driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
//		Assert.assertEquals(editPin,
//				driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
//		Assert.assertEquals(editPhone,
//				driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
//		Assert.assertEquals(editEmail,
//				driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
//
//	}
//
	@Test
	public void TC_02_Handle_HTML_Dropdown_List_1() throws InterruptedException {
		//step 1
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//step 2
		Select select=new Select(driver.findElement(By.id("job1")));
		Assert.assertFalse(select.isMultiple());
		select.selectByVisibleText("Mobile Testing");
		
		Assert.assertEquals("Mobile Testing", select.getFirstSelectedOption().getText());
		
		select.selectByValue("manual");
		Assert.assertEquals("Manual Testing", select.getFirstSelectedOption().getText());
		
		select.selectByIndex(9);
		Assert.assertEquals("Functional UI Testing", select.getFirstSelectedOption().getText());
		
		Assert.assertEquals(10, select.getOptions().size());
		Select select2=new Select(driver.findElement(By.id("job2")));
		Assert.assertTrue(select2.isMultiple());
		select2.selectByVisibleText("Automation");
		select2.selectByVisibleText("Mobile");
		Thread.sleep(3000);
		select2.selectByVisibleText("Desktop");
		Thread.sleep(3000);
	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
