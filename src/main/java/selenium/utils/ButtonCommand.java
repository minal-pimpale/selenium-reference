package selenium.utils;

import org.openqa.selenium.WebElement;

public class ButtonCommand {

	private String Id;

	public ButtonCommand(String id){
		this.Id = id;
	}
	
	public void Click(){
		WebElement elem = SeleniumHelper.FindById(Id);
		elem.click();
	}

}
