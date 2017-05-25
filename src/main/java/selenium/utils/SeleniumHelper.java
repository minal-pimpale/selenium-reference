package selenium.utils;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

	public static void WaitForPageLoad(long time){
		SeleniumWebDriver.Instance().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);	
	}
	
	public static boolean WaitForPresenceOfElementById(String id){
		//wait for 1 sec
		WebElement myDynamicElement = null;
		try{
			myDynamicElement= (new WebDriverWait(SeleniumWebDriver.Instance(), 1))
		  .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		}
		catch(Exception e){
			return false;
		}
		if (myDynamicElement != null)
			return true;
		return false;
	}
	
	public static boolean WaitForPresenceOfElementByXPath(String xPath){
		//wait for 1 sec
		WebElement myDynamicElement = null;
		try{
		myDynamicElement = (new WebDriverWait(SeleniumWebDriver.Instance(), 60))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		}
		catch(Exception e){
			return false;
		}
		if (myDynamicElement != null)
			return true;
		return false;
	}
	

	public static void Navigate(String url){
		System.out.println("instance is --"+SeleniumWebDriver.Instance());
		SeleniumWebDriver.Instance().navigate().to(url);
	}
	
	public static WebElement FindById(String id){
		WebElement elem = SeleniumWebDriver.Instance().findElement(By.id(id));
		return elem;
	}
	
	public static InputTextCommand InputText(String id){
		return new InputTextCommand(id);
	}
	
	public static DropDownCommand DropDown(String id){
		return new DropDownCommand(id);
	}
	
	public static ButtonCommand Button(String id){
		return new ButtonCommand(id);
	}
	
	public static LinkCommand Link(String id){
		return new LinkCommand(id);
	}
	
	public static DivCommand Div(String xPath){
		return new DivCommand(xPath);
	}
	
}
   
   


	

