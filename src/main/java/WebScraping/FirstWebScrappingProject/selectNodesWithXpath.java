package WebScraping.FirstWebScrappingProject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class selectNodesWithXpath {

	public static void main(String[] args) throws IOException{
		
		readWebPageHtmlUnit instance_readPage=new readWebPageHtmlUnit("https://news.ycombinator.com/");
		HtmlPage page=instance_readPage.webClient.getPage(instance_readPage.base_url);
		List<HtmlElement> itemList=page.getByXPath("//tr[@class='athing']");
		if(itemList.isEmpty())
		{
			System.out.println("No items found!!!");
			return;
		}
		for(HtmlElement htmlItem: itemList)
		{
			int position=Integer.parseInt(((HtmlElement)htmlItem.getFirstByXPath("./td/span")).asText()
					     .replace(".", ""));
			int id=Integer.parseInt(htmlItem.getAttribute("ID"));
			String title=((HtmlElement)htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']"))
					.asText();
			String url=((HtmlElement)htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']/a"))
					.asText();
			String author=((HtmlElement)htmlItem.getFirstByXPath("./following-sibling::tr/td[@class='subtext']/a[@class='hnuser']"))
					.asText();
			int score=Integer.parseInt(((HtmlElement)htmlItem.getFirstByXPath("./following-sibling::tr/td[@class='subtext']/span[@class='score']"))
							.asText().replace(" points", ""));
			
			hackerNewsItem hackerNewsItemInstance=new hackerNewsItem(title,url,author,score,position,id);
			ObjectMapper objectMapper=new ObjectMapper();
			String jsonString=objectMapper.writeValueAsString(hackerNewsItemInstance);
			System.out.println(jsonString);
		}
		 
	}
}
