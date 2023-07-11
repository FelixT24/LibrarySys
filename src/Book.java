/**
 * <p>Title: Book Class</p>
 * <p>Description: Contains methods in which book information can be stored
 * and changed. The title, author, and status of the book can all be stored. </p>
 * 
 * @author Felix Taveras
 *
 */
public class Book 
{
	private String title;
	private String author;
	private String status;
	
	/**
	 * Parameterized Constructor 
	 * Stores the parameters into the appropriate instance variables.
	 * @param aTitle - the String value too be stored in title
	 * @param aAuthor - the String value to be stored in author
	 * @param aStatus - the String value to be stored in status
	 */
	public Book(String aTitle, String aAuthor, String aStatus)
	{
		title = aTitle;
		author = aAuthor;
		status = aStatus;
	}
	
	/**
	 * getTitle method - accessor method for title
	 * @return - a reference to the instance variable title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * getAuthor method - accessor method for author
	 * @return - a reference to the instance variable author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * getStatus method - accessor method for the status
	 * @return - a reference to the instance variable status
	 */
	public String getStatus()
	{
		String str = "";
		if (status.equals("Out") || status.equals("Overdue") ||
			status.equals("Available"))
		{
			str = status;
		}
		return str;
	}
	
	/**
	 * setTitle method - mutator method for title
	 * @param nTitle the value to be stored in the instance variable title
	 */
	public void setTitle(String nTitle)
	{
		title = nTitle;
	}
	
	/**
	 * setAuthor method - mutator method for author
	 * @param nAuthor the value to be stored within the instance variable author
	 */
	public void setAuthor(String nAuthor)
	{
		author = nAuthor;
	}
	
	/**
	 * setStatus method - mutator method for status
	 * @param nStatus the value to be stored within the instance variable status
	 */
	public void setStatus(String nStatus)
	{
		if (nStatus.equals("Available") || nStatus.equals("Out")
			|| nStatus.equals("Overdue"));
		{
			status = nStatus;
		}	
			
	}
	
	/**
	 * toString method - create and return a String with the instance variable values
	 * @return a reference to a String containing title, author, and the status.
	 */
	public String toString()
	{
		return title + " by " + author + " is currently " + status;  
	}

}
