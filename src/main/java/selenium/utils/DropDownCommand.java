package selenium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownCommand {

	private String Id;

	public DropDownCommand(String id){
		this.Id = id;
	}

	public void Value(String value){
		
		WebElement elem = SeleniumHelper.FindById(Id);
		Select dropdown = new Select(elem);
		dropdown.selectByVisibleText(value);
	}
}
