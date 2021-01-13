package WebScraping.FirstWebScrappingProject;



public class hackerNewsItem 
{
	String title,url, author;
	int score, position, id;
	hackerNewsItem(String title, String url, String author,int score, int position, int id)
	{
		this.title=title;
		this.id=id;
		this.url=url;
		this.score=score;
		this.position=position;
		this.author=author;
	}
	public String getTitle() {
		return title;
	}
	public String getUrl() {
		return url;
	}
	public String getAuthor() {
		return author;
	}
	public int getScore() {
		return score;
	}
	public int getPosition() {
		return position;
	}
	public int getId() {
		return id;
	}
}