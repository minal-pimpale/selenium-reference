package selenium.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;

public class SeleniumWebDriver {

	private static  WebDriver driver;
	private final static String chromeDriverLocation = "\\lib\\chromedriver.exe";
	public static WebDriver Instance() {
		
		InitializeDriver();
		
		return driver;
	}
	
	private static String getChromeDriverLocation(){
		String workingdirectory = System.getProperty("user.dir");
		String chromeDriveLocation  = workingdirectory + chromeDriverLocation;
		return chromeDriveLocation;
	}
	
	public static void InitializeDriver(){
		if (driver == null){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
		
			String chromeDriverLocation = getChromeDriverLocation();
			System.setProperty("webdriver.chrome.driver",chromeDriverLocation);
			driver = new ChromeDriver(options);
		}

	}
	
	public static void InitializeFirefoxDriver(){
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//	
//		String chromeDriverLocation = getChromeDriverLocation();
//		System.setProperty("webdriver.chrome.driver",chromeDriverLocation);
//		driver = new ChromeDriver(options);
		
//		driver = new FirefoxDriver();
		//System.setProperty("webdriver.firefox.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
//		WebDriver driver=new FirefoxDriver();  
	      System.out.println("Hello Google...");  
	      driver.get("http://google.com");
		
	}
	
public static void InitializeIEDriver(){
		
	System.setProperty("webdriver.ie.driver", "D:\\myWork\\IEDriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();;
//		WebDriver driver=new FirefoxDriver();  
	      System.out.println("Hello Google...");  
	      driver.get("http://test.dealvector.com");
		
	}
	
	public static void CloseDriver(){
		driver.close();
		driver = null;
	}
	
	public static void QuitDriver(){
		driver.quit();
		driver = null; 
	}
}
