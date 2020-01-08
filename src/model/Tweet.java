package model;

public class Tweet {
	private long idTweet;
	private String strUser;
	private String strDate;
	private String strContent;
	private String strUserRT;
	
	public Tweet(String idTweet, String strUser, String strDate, String strContent, String strUserRT)
	{
		try 
		{ 
			this.idTweet = Long.parseLong(idTweet);
			this.strUser = strUser;
			this.strDate = strDate;
			this.strContent = strContent;
			this.strUserRT = strUserRT;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Getters
	public long getIdTweet() {
		return idTweet;
	}
	
	public String getStrUser() {
		return strUser;
	}
	
	public String getStrDate() {
		return strDate;
	}
	
	public String getStrContent() {
		return strContent;
	}
	
	public String getStrUserRT() {
		return strUserRT;
	}
	
	//Setters
	
	public void setIdTweet(long pIdTweet) {
		this.idTweet = pIdTweet;
	}
	
	public void setStrUser(String pStrUser) {
		this.strUser = pStrUser;
	}
	
	public void setStrDate(String pStrDate) {
		this.strDate = pStrDate;
	}
	
	public void setStrContent(String pStrContent) {
		this.strContent = pStrContent;
	}
	
	public void setStrUserRT(String pStrUserRT) {
		this.strUserRT = pStrUserRT;
	}

	
	//Affichage
	
	public String toString() {
		return this.idTweet + this.strUser + this.strDate + this.strContent + this.strUserRT;
	}
}