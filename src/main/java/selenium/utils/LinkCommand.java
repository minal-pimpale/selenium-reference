package selenium.utils;

import org.openqa.selenium.WebElement;

public class LinkCommand {
	private String Id;

	public LinkCommand(String id){
		this.Id = id;
	}
	
	public void Click(){
		WebElement elem = SeleniumHelper.FindById(Id);
		elem.click();
	}
}
