package WebScraping.FirstWebScrappingProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.ObjectUtils.Null;import org.eclipse.jetty.util.IteratingNestedCallback;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;


public class justWatchSearchAuto implements Runnable {
	String country;
	static String temp_url="https://www.justwatch.com/";    //site url
	static String movie="oldboy";  //movie name
	static BufferedWriter writer;
	public justWatchSearchAuto(String country)
	{
		this.country=country;
	}
	public void run() {
		try {
			getPage(temp_url,country,movie,writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void getPage(String url,String country,String movieName,BufferedWriter writer) throws IOException, InterruptedException {

		myChromeDriver myDriver=new myChromeDriver();     //chrome driver instance
		WebDriver client=myDriver.driver;
		client.get(url+country);          //get page
		WebDriverWait wait=new WebDriverWait(client, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input")));	
		WebElement search_bar=client.findElements(By.tagName("input")).get(0); 
		search_bar.sendKeys(movieName);   //Entering movie name in the search bar
		search_bar.sendKeys(Keys.ENTER);   //pressing enter
		search_bar.sendKeys(Keys.RETURN);
		Thread.sleep(15000);
		
		List<WebElement> movies_list=client.findElements(By.xpath("//ion-col"));
		int index=0;
		String text="<h1> Country Name: "+country+"</h1>";
		for(WebElement tElement:movies_list)
		{   if(index%2!=0)
			text+=tElement.findElement(By.xpath("//div[@class='price-comparison__grid__row price-comparison__grid__row--stream']")).getAttribute("outerHTML");
		else {
			text+=tElement.getAttribute("outerHTML");
		}
			if(++index>=6)
				break;
		}
		writer.append(text);
		client.close();
		client.quit();
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		String html_code="<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"<body>\r\n" + 
				"";
		writer=new BufferedWriter(new FileWriter("justWatchGlobal.html"));
		writer.write(html_code);
		ExecutorService executorService=Executors.newFixedThreadPool(5);
	    String[] CountryList= {"ar","au","at","be","br","ca","cl","co","dk","ec","fi","fr","de","in","ie","it","jp","lt","mx","nl","nz","no","pe","ro","kr","es","se","ch","uk","us","ve"};
		for(String s:CountryList)
		{
			Runnable worker=new justWatchSearchAuto(s);
			executorService.execute(worker);
		}
		executorService.shutdown();  
        while (!executorService.isTerminated()) {   }  
        System.out.println("Finished all threads");  
		writer.append("</body>");
		writer.append("</html>");
		writer.close();
		}
}