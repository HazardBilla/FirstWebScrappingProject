package WebScraping.FirstWebScrappingProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class myChromeDriver {
   String chromeDriver;
   ChromeOptions options;
   WebDriver driver;
 public myChromeDriver() {
	// TODO Auto-generated constructor stub
	 chromeDriver="C:\\Users\\sai.reddy\\Downloads\\chromedriver_win32\\chromedriver.exe";
	 System.setProperty("webdriver.chrome.driver", chromeDriver);
	 options=new ChromeOptions();
	 options.addArguments("--headless","--disable-gpu","--window-size=1920,1200","--ignore-cirtificate-eroors");
	 driver=new ChromeDriver(options);
}
 
}
