package selenium.utils;

import org.openqa.selenium.WebElement;

public class InputTextCommand {
	
	private String Id;

	public InputTextCommand(String id){
		this.Id = id;
	}

	public void Value(String value){
		WebElement elem = SeleniumHelper.FindById(Id);
		elem.sendKeys(value);
	}
	
	public boolean IsPresent(){
		WebElement elem = SeleniumHelper.FindById(Id);
		if (elem != null)
			return true;
		return false;
	}
}
