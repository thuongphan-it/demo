package exercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_06_WebElement {
	WebDriver driver;
	WebElement element;

	@Test
	public void TC_01_Check_Element_Displayed() throws InterruptedException {
		// step1
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// step 2
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));

		WebElement ageRadioBtn = driver.findElement(By.xpath("//input[@id='under_18']"));

		WebElement educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']"));
		if (emailTextbox.isDisplayed() && ageRadioBtn.isDisplayed() && educationTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing");
			ageRadioBtn.click();
			educationTextbox.sendKeys("Automation Testing");
			Thread.sleep(3000);
			System.out.print("Element is displayed\n");
		} else {
			System.out.print("Element is not displayed\n");
		}

	}

//
	@Test
	public void TC_02_Check_Element_Enabled_Disabled() throws InterruptedException {
		// step1
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// step 2
		// mail
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));

		// age under 18
		WebElement ageRadioBtn = driver.findElement(By.xpath("//input[@id='under_18']"));

		// education
		WebElement educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']"));

		// job role 01
		WebElement jobOneDropdown = driver.findElement(By.xpath("//select[@id='job1']"));

		// job role 02
		WebElement jobTwoDropdown = driver.findElement(By.xpath("//select[@id='job2']"));

		//
		WebElement interestChecbox = driver.findElement(By.xpath("//input[@id='development']"));

		//
		WebElement sliderOne = driver.findElement(By.xpath("//input[@id='slider-1']"));
		// disabled
		WebElement passwordTextbox = driver.findElement(By.xpath("//div[@class='container']//input[@id='password']"));
		WebElement ageRadioBtnDisable = driver
				.findElement(By.xpath("//div[@class='container']//input[@id='radio-disabled']"));
		WebElement bioTextArea = driver.findElement(By.xpath("//div[@class='container']//textarea[@id='bio']"));
		WebElement jobThreeDropdown = driver.findElement(By.xpath("//div[@class='container']//select[@id='job3']"));
		WebElement interestChecboxDisable = driver
				.findElement(By.xpath("//div[@class='container']//input[@id='check-disbaled']"));
		WebElement sliderTwo = driver.findElement(By.xpath("//div[@class='container']//input[@id='slider-2']"));
		if (emailTextbox.isEnabled() && ageRadioBtn.isEnabled() && educationTextbox.isEnabled()
				&& jobOneDropdown.isEnabled() && jobTwoDropdown.isEnabled() && interestChecbox.isEnabled()
				&& sliderOne.isEnabled()) {
			System.out.print("Element is enabled\n");
		} else {
			System.out.print("Element is not enabled\n");
		}
		if (passwordTextbox.isEnabled() && ageRadioBtnDisable.isEnabled() && bioTextArea.isEnabled()
				&& interestChecboxDisable.isEnabled() && sliderTwo.isEnabled() && jobThreeDropdown.isEnabled()) {
			System.out.print("Element is enabled\n");
		} else {
			System.out.print("Element is not enabled\n");
		}

	}

	@Test
	public void TC_03_Check_Element_Selected() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement ageUnderRadioBtn = driver.findElement(By.xpath("//input[@id='under_18']"));
		ageUnderRadioBtn.click();
		WebElement languaJavaChecbox = driver.findElement(By.xpath("//input[@id='java']"));
		languaJavaChecbox.click();
		Thread.sleep(3000);
		//

		if (ageUnderRadioBtn.isSelected() && languaJavaChecbox.isSelected()) {
			System.out.print("Element is selected\n");
		} else {
			System.out.print("Element is de-selected\n");
		}
		if (languaJavaChecbox.isSelected()) {
			languaJavaChecbox.click();
		}
		Thread.sleep(3000);

		if (languaJavaChecbox.isSelected()) {
			System.out.print("Element is selected\n");
		} else {
			System.out.print("Element is de-selected\n");
		}

	}

	@Test
	public void TC_04_Register_Function_At_MailChimp() throws InterruptedException {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("phanthithi@gmail.com");
		driver.findElement(By.xpath("//input[@id='new_username']")).sendKeys("Thi Thi");
		WebElement passTextbox = driver.findElement(By.xpath("//input[@id='new_password']"));
		// provision
		WebElement lowercase = driver.findElement(By.xpath("//li[contains(text(),'One lowercase character')]"));
		WebElement uppercase = driver.findElement(By.xpath("//li[contains(text(),'One uppercase character')]"));
		WebElement number = driver.findElement(By.xpath("//li[contains(text(),'One number')]"));
		WebElement special = driver.findElement(By.xpath("//li[contains(text(),'One special character')]"));
		WebElement character = driver.findElement(By.xpath("//li[contains(text(),'8 characters minimum')]"));
		// btn Sign Up
		WebElement signupBtn = driver.findElement(By.xpath("//button[@id='create-account']"));
		// checkbox
		WebElement marketingCheckbox = driver.findElement(By.xpath("//input[@id='marketing_newsletter']"));

		passTextbox.sendKeys("Thuong123@");

		if (lowercase.getAttribute("class").contains("complete") && uppercase.getAttribute("class").contains("complete")
				&& number.getAttribute("class").contains("complete")
				&& special.getAttribute("class").contains("complete")
				&& character.getAttribute("class").contains("complete")) {
			System.out.println("All is disable");
		} else {
			System.out.println("All is enable");
		}

		if (signupBtn.isEnabled()) {
			System.out.println("Sign Up is enable");
		} else {
			System.out.println("Sign Up is disable");
		}
		marketingCheckbox.click();
		Thread.sleep(3000);
		if (marketingCheckbox.isSelected()) {
			System.out.println("Check box is selected");
		} else {
			System.out.println("Check box is not selected");
		}
		signupBtn.click();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
