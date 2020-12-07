package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Topic_01_Check_Environment {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		driver= new ChromeDriver();
		driver.get("https://www.hahalolo.com/auth/signin");

	}

}
