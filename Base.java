package org.smes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base { 
	
	public static WebDriver driver;
	
	//1
	public static  void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	//2
	public void firefoxLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	//3
	public void ieLaunch() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
	
	//4
	public static void edgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
	}
	
	//5
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	//6
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	//7
	public void sendTxt (WebElement targettxt, String value) {
		targettxt.sendKeys(value);
		}
	
	//8
	public static void click(WebElement targetelement) {
		targetelement.click();
	}
	
	//9
	public void getCrntUrl(WebElement target) {
		String CurrentUrl = driver.getCurrentUrl();
	}
	
	//10
	public static String getTitle() {
		String title = driver.getTitle();
		return title; 
		
	}
	
	//11
	public static void CloseWin() {
		driver.close();
	}

	//12
	public void CloseAllWin() {
		driver.quit();
	}
	
	//13
	public static void getText(WebElement target) {
		String text = target.getText();
		System.out.println("Text:"+text);
	}
	
	//14
	public void getAttribute(WebElement target,String name) {
		String attribute = target.getAttribute(name);
		System.out.println("Attribute:"+attribute);
	}
	
	//15
	public void timeDelay(int arg) throws InterruptedException {
		Thread.sleep(arg);
	}
	
	//16
	public static void mouseover(WebElement Target) {
		Actions action = new Actions(driver);
		action.moveToElement(Target).perform();
	}
	
	//17
	public static void dragAndDrop(WebElement sourde,WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	//18
	public void doubleClick(WebElement target) {
		Actions action = new Actions(driver);
		action.doubleClick(target).perform();
	}
	
	//19
	public static void contextClick(WebElement target) {
		Actions action = new Actions(driver);
		action.contextClick(target).perform();
	}
	
	//20
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	//21
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	//22
	public void acceptPromptAlert(String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.accept();
	}
	
	//23
	public void dismissPromptAlert(String KeysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(KeysToSend);
		alert.dismiss();
	}
	
	//24
	public void sendTxWithJS(String JAVASCRIPTcommand, WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(JAVASCRIPTcommand, target);
	}
	
	//25
	public void clickWithJS(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", target);
	}
	
	//26
	public void ScrollUp(WebElement target) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", target);
	}
	
	//27
	public void scrollDown(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", target);
	}
	
	//28
	public void screensnap(String path)throws IOException  {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		 File src = screenshot.getScreenshotAs(OutputType.FILE);
		 File des = new File(path);
		 FileUtils.copyDirectory(src, des);
		 	}
	
	//29
	public void goToFrameWithName(String name) {
		driver.switchTo().frame(name);
	}
	
	//30
	public void goToFrameWithId(String Id) {
		driver.switchTo().frame(Id);
		}
	
	//31
	public void goToFrameWithIndex(String Index) {
		driver.switchTo().frame(Index);
	}
	
	//32
	public void goToFrameWithWebElement(String webElement) {
		driver.switchTo().frame(webElement);
	}
	
	//33
	public void goToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	//34
	public void goToDefaultPage() {
		driver.switchTo().defaultContent();
	}
	
	//35
	public void gotoChildWindow() {
		String parWin = driver.getWindowHandle();
		Set<String> childWin = driver.getWindowHandles();
		for (String string :childWin) {
			if (string == parWin) {
				driver.switchTo().window(string);
			}
			}
	}
	
	//36
	public static void goToParentWindow() {
		String parWin = driver.getWindowHandle();
		Set<String> childWin = driver.getWindowHandles();
		for(String string : childWin) {
			driver.switchTo().window(string);
		}
	}
	
	
	//37
	public static void multipleWindows(int arg) {
	Set<String> allWin = driver.getWindowHandles();
	List<String> prtclrWindow = new ArrayList<String>();
	prtclrWindow.addAll(allWin);
	String string = prtclrWindow.get(arg);
	driver.switchTo().window(string);
	}
	
	//38
	public static void dropDownSelectByValue(WebElement target,String Value) {
		Select select = new Select(target);
		select.selectByValue(Value);
		}
	
	//39
	public static void dropDownSelectByVisible(WebElement target,String Text) {
		Select select = new Select(target);
		select.selectByVisibleText(Text);
	}

	//40
	public static void dropDownSelectByIndex(WebElement target,int index) {
		Select select = new Select(target);
		select.selectByIndex(index);;
	}
	
	//41
	public static void dropDownSelectBygetOptions(WebElement target,int index) {
		Select select = new Select(target);
		List<WebElement> options = select.getAllSelectedOptions();
		System.out.println("All Data in DropDown : "+options);
}
	
	//42
	public static void dropDownIsMultiple(WebElement target) {
		Select select = new Select(target);
		boolean multiple = select.isMultiple();
		System.out.println("We can Select Multiple option :"+multiple);
	}
	
	//43
	public static void dropDownAllSelected(WebElement target) {
		Select select = new Select(target);
		 List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		System.out.println("All Selected Options in Dropdown :"+allSelectedOptions);
	}

	//44
	public static void dropDownFirstSelected(WebElement target) {
		Select select = new Select(target);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println("First Selected option :"+firstSelectedOption);
	}
	
	//45
	public static void dropDownDeselectByValue(WebElement target,String Value) {
		Select select = new Select(target);
		select.deselectByValue(Value);
	}
	
	//46
	public static void dropDownDeselectByVisible(WebElement target,String Text) {
		Select select = new Select(target);
		select.deselectByVisibleText(Text);
		}
	
	//47
	public static void dropDownDeselectByIndex(WebElement target,int index) {
		Select select = new Select(target);
		select.deselectByIndex(index);
	}
	
	//48
	public static void dropDownDeselectByAll(WebElement target) {
		Select select = new Select(target);
		select.deselectAll();
	}
	
	//49
	public static FluentWait<WebDriver> wait;
	public static void elementToBeClickable(String path) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofNanos(10)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	}
	
	//50
	public static void alertIsPresent() {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofNanos(10)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.alertIsPresent());
		}
	
	//51
	public static void frameToBeAvailableAndSwitchToIt(WebElement ref) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofNanos(10)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ref));
}
	//52
	public static void presenceOfElementLocated(String path) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofNanos(10)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}
	

public static String readExcel (int rowNum, int cellNum  ) throws IOException  {
	//1.Mention excel file path location
	
			File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Excel\\sample.xlsx");
			
			//2.read the file
			
			FileInputStream fis = new FileInputStream(f); //FileNotFoundException
			
			
			//3. read the exact file format
			
			Workbook w = new XSSFWorkbook(fis); //IOException
			
			//4 . To get the sheet from workbook
			
			Sheet mySheet = w.getSheet("Sample");
			
			Row r = mySheet .getRow(rowNum);
			Cell c = r.getCell(cellNum);
			int cellType = c.getCellType();
			
			// by default cellType == 1 --> that is string cell
			//cellType otherthan 1--> that is Date cell or Numeric cell
			
			String value = "";
			
			if(cellType==1) {
				value = c.getStringCellValue();
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd MMM yyyy");
				value = s.format(d);
				
			} else {
				double dd = c.getNumericCellValue();
			
			long l =(long) dd;
			 value = String.valueOf(1);
}
			return value;
}
			
			
	

	
	

	

//  create Excel File

public static void createExcel(int creRow, int creCell, String setData) throws IOException  {

	File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Excel\\NewExcels.xlsx");
	
	Workbook w = new XSSFWorkbook();
	
	Sheet newSheet = w.createSheet("Samples");
	
	Row newRow = newSheet.createRow(creRow);
	
	Cell newCell = newRow.createCell(creCell);
	
	newCell.setCellValue(setData);
	
	FileOutputStream fos = new FileOutputStream(f);
	
	w.write(fos);
	
	System.out.println("Writed");
}
	

// Create Cell Only
	public static void createCellOnly(int getTheRow, int creCell, String setData) throws IOException {

		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Excel\\NewExcels.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet newSheet = w.getSheet("Samples");
		
		Row newRow = newSheet.getRow(getTheRow);
		
		Cell newCell = newRow.createCell(creCell);
		
		newCell.setCellValue(setData);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		w.write(fos);
		
		System.out.println("writed");
	}
	
	//Create the row
	
	public static void createRowOnly(int creRow, int creCell, String setData) throws IOException {

		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Excel\\NewExcels.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet newSheet = w.getSheet("Samples");
		
		Row newRow = newSheet.createRow(creRow);
		
		Cell newCell = newRow.createCell(creCell);
		
		newCell.setCellValue(setData);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		w.write(fos);
		
		System.out.println("writed");
	}
	
	
	// update the excel file
	
	public static void updateTheExcel(int getTheRow, int getTheCell, String setTheData) throws IOException {

		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\Mv1\\Excel\\NewExcels.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet newSheet = w.getSheet("Samples");
		
		Row newRow = newSheet.createRow(getTheRow);
		
		Cell newCell = newRow.createCell(getTheCell);
		
		newCell.setCellValue(setTheData);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		w.write(fos);
		
		System.out.println("writed");
	}
	
	//pass
	public static void passTxt(String text,WebElement ele) {
		ele.sendKeys(text);
		
			}
	
	
public static void passNum(CharSequence value,WebElement ele) {
		
		ele.sendKeys(value);
			}


	


}

