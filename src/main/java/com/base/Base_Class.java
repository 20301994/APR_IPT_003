package com.base;

import static org.junit.Assert.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {

	public static WebDriver driver;
	
	protected static WebDriver launchBrowser(String browsername) {
	    try {
			if (browsername.equalsIgnoreCase("chrome")) {
				driver =new ChromeDriver();
			}else if (browsername.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
	    	
		} catch (Exception e) {
		     Assert.fail("ERROR : OCCURE DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
		}
	
	
	  protected static void launchurl(String url) {
		  try {
			driver.get(url);
		} catch (Exception e) {
		    Assert.fail("ERROR:OCCURE DURING URL LAUNCH");  
		}
	  }
	    protected static void passInput(WebElement element,String value) {
	    	
	    	try {
				element.sendKeys(value);
			} catch (Exception e) {
			     Assert.fail("ERROR : OCCURE DURING VALUE PASSING");
			}
	    	
 }
	      	
	  protected static void clickOnElement (WebElement element) {
		  try {
			element.click();
		} catch (Exception e) {
		     Assert.fail("ERROR :OCCURE DURING ELEMENT CLICK");
		}
	  }
	
	 protected static void browserTermination() {
		 try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING BROWSER TERMINATION");
		}
	 }
	
	protected static void selectOption(WebElement element, String type,String value) {
		Select select = new Select(element);
        try {
			if (type.equalsIgnoreCase("Text")) {
				select.selectByVisibleText(value);
			}else if (type.equalsIgnoreCase("Index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (Exception e) {
		    Assert.fail("ERROR : OCCURE DURING VALUSE SELECTION");
		}
	}
		
	protected static void deselectOption(WebElement element, String type,String value) {
		Select select = new Select(element);
        try {
			if (type.equalsIgnoreCase("Text")) {
				select.deselectByVisibleText(value);
			}else if (type.equalsIgnoreCase("Index")) {
				select.deselectByIndex(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}
		} catch (Exception e) {
		    Assert.fail("ERROR : OCCURE DURING VALUSE DESELECTION");
		}
	}	
			
	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
		     Assert.fail("ERROR:OCCURE DURING NAVIGATION TO URL");	
		}
	}
	protected static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
	        Assert.fail("ERROR:OCCURE DURING NAVIGATION BACK");
		}
	}
	
	protected static void navigateforward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
		    Assert.fail("ERROR : OCCURE DURING NAVIGATION FORWARD");	
		}
	}

	protected static void navigaterefreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURE DURING PAGE REFRESH");
			
	}
	}
	protected static void checkIsDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("element is displayed");
			}
			else {
				System.out.println("Element is not displayed");
			}
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURE DURING ELEMENT DISPLAYED CHECK");
		}
	}
		
	protected static void checkIsEnabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				System.out.println("Element is enabled");
			}
			else {
				System.out.println("element is not enabled");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING ELEMENT ENABLED CHECK");
		}
	}

	protected static void checkIsSelected(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Element is selected");
			}
			else {
				System.out.println("Element is not selectes");
			}
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURE DURING ELEMENT SELECTED CHECK");
		}
	}

	protected static void handleAlert(String action, String gettext) {
		try {
			if (action.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			}else if (action.equalsIgnoreCase("Dismiss")) {
				driver.switchTo().alert().dismiss();
			}else if (action.equalsIgnoreCase("gettext")) {
				driver.switchTo().alert().getText();
			}else if (action.equalsIgnoreCase("sendkeys")) {
				driver.switchTo().alert().sendKeys(gettext);
			}
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURE DURING ALERT HANDLING");
		}
	}

     protected static void firstSelectedOption(WebElement element) {
    	 try {
			Select select = new Select(element);
			WebElement firstoption = select.getFirstSelectedOption();
			System.out.println("First selected option:"+firstoption.getText());
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURED DURING FIRST OPTION SELECT");
		}
     }

     protected static void explicitWait(WebDriverWait wait,WebElement element,int seconds) {
    	 try {
			wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING EXPLICIT WAIT ");
		}
     }


     protected static void implicitTWait(int seconds) {
    	 try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURED DURING IMPLICIT WAIT");
		}
     }

     protected static void takeScreenshot(String filename){
    	 try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshots/" +filename +".png");
			FileHandler.copy(source, destination);
		} catch (Exception e) {
			Assert.fail("ERROR :OCCURED DURING SCREENSHOT CAPTURE");
		}
    	 
     }



}


