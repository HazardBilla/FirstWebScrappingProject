package WebScraping.FirstWebScrappingProject;

import com.gargoylesoftware.htmlunit.WebClient;

public class readWebPageHtmlUnit
{
       String base_url;
        WebClient webClient;
        readWebPageHtmlUnit(String url)
        {
        	this.base_url=url;
        	webClient=new WebClient();
        	webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
        }
}
