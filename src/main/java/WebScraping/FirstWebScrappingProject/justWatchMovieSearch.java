package WebScraping.FirstWebScrappingProject;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class justWatchMovieSearch {
public static void main(String[] args) throws IOException, InterruptedException {
	String movie="hellboy";
	String[] urls= {"https://www.justwatch.com/ar/pelicula/","https://www.justwatch.com/au/movie/","https://www.justwatch.com/at/Film/","https://www.justwatch.com/be/film/","https://www.justwatch.com/br/serie/","https://www.justwatch.com/ca/movie/","https://www.justwatch.com/cl/pelicula/","https://www.justwatch.com/co/pelicula/","https://www.justwatch.com/dk/movie/","https://www.justwatch.com/ec/pelicula/","https://www.justwatch.com/fi/elokuva/","https://www.justwatch.com/fr/film/","https://www.justwatch.com/de/Film/","https://www.justwatch.com/in/movie/","https://www.justwatch.com/ie/movie/","https://www.justwatch.com/it/film/","https://www.justwatch.com/jp/%E6%98%A0%E7%94%BB/","https://www.justwatch.com/lt/movie/","https://www.justwatch.com/mx/pelicula/","https://www.justwatch.com/nl/movie/","https://www.justwatch.com/nz/movie/","https://www.justwatch.com/no/movie/","https://www.justwatch.com/pe/pelicula/","https://www.justwatch.com/ro/film/","https://www.justwatch.com/kr/%EC%98%81%ED%99%94/","https://www.justwatch.com/es/pelicula/","https://www.justwatch.com/se/movie/","https://www.justwatch.com/ch/Film/","https://www.justwatch.com/uk/movie/","https://www.justwatch.com/us/movie/","https://www.justwatch.com/ve/pelicula/"};
	myChromeDriver myDriver=new myChromeDriver();
	WebDriver client=myDriver.driver;
	List<WebElement> elements;
	Pattern pattern=Pattern.compile("title=\"[\\w\\s]*\"");
	String text;
	Matcher matcher;
	String countryWiseStream="";
	for(String url:urls)
	{
	//get just watch page
	String country=url.substring(26, 28);
	countryWiseStream+=country.toUpperCase()+"\n";
	
	try {
	client.get(url+movie);
	Thread.sleep(5000);
	elements=client.findElements(By.xpath("//div[@class='price-comparison__grid__row price-comparison__grid__row--stream']"));
		text=elements.get(0).getAttribute("innerHTML");
		matcher=pattern.matcher(text);
        while(matcher.find())
        {
        	countryWiseStream+=matcher.group()+"\n";
        }
	}
	catch (Exception e) {
		// TODO: handle exception
		countryWiseStream+="no Stremaing in your country"+"\n";
	}
	}
	System.out.println(countryWiseStream);
}
}
