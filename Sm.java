package org.smes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sm extends Ms {
	
public static void main(String[] args) throws IOException {
		
        browserLaunch();
		maxWindow();
		launchUrl("https://www.facebook.com/");
		
		
		
		screenShot("fb0");
		
		WebElement emailTxt = driver.findElement(By.name("email"));
		
		passTxt("deena", emailTxt);
		
		
		screenShot("fb2");
		
		WebElement pasTxt = driver.findElement(By.name("pass"));
		
		passTxt("745214", pasTxt);
		
		screenShot("fb3");
		
	}


}
