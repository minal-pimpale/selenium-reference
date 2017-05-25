package selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DivCommand {

	private String XPath;
	

	public DivCommand(String xpath){
		this.XPath = xpath;
	}
	public String Text(){
		WebElement div = null;
		try{
			div = SeleniumWebDriver.Instance().findElement(By.xpath(this.XPath));
		}
		catch(Exception e){
			div = null;
		}
		
		if (div != null)
			return div.getText();
		
		return "";
	}
}
