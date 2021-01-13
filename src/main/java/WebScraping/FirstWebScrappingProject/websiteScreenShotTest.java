package WebScraping.FirstWebScrappingProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class websiteScreenShotTest {
public static void main(String[] args) throws IOException, InterruptedException{
	myChromeDriver myDriver=new myChromeDriver();
	//get the web page
    myDriver.driver.get("https://www.justwatch.com/us/movie/death-race");
    Thread.sleep(10000);
    //take screen shot
    File screenShot=((TakesScreenshot)myDriver.driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenShot, new File("websiteScreenShot.png"));
    myDriver.driver.close();
    myDriver.driver.quit();
}
}
