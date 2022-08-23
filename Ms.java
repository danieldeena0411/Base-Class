package org.smes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Ms {

public static WebDriver driver;
	
public static void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
	}
	
	public static void maxWindow() {
		
		driver.manage().window().maximize();
		
	}
	
	public static void launchUrl(String url) {
		
		driver.get(url);
}

	public static void passTxt(String text,WebElement ele) {
	
		ele.sendKeys(text);
			}
		
	public static void screenShot(String imgName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File sc = ts.getScreenshotAs(OutputType.FILE);
		
		File des  = new File ("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Img\\"+imgName+".png");
	
	FileUtils.copyFile(sc, des);
	}
}