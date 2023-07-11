/**
 * <p>Title: Library Class</p>
 * <p>Description: This class models a fully functional library
 * system that allows the user to insert books, checkout books,
 * find books, and even mark books to be overdue. </p>
 * 
 * @author Felix Taveras 
 *
 */
public class Library 
{
	private Book[] theBooks; 
	private int numBooks;
	
	/**
	 * Default constructor--
	 * Creates storage for at most 50 books, and sets the number 
	 * of numBooks to 0
	 */
	public Library()
	{
		theBooks = new Book[50];
		numBooks = 0;
	}
	
	/**
	 * insertBook method--
	 * Allows book objects to be stored within the theBooks array for
	 * as long as numBooks is less than the array length. numBooks
	 * also increased by 1 each time a book object is inserted
	 * @param nBook the book object to be stored within the aray
	 */
	public void insertBook(Book nBook)
	{
		if (numBooks < theBooks.length)
		{
			theBooks[numBooks] = nBook;
			numBooks++;
		}
	}
	
	/**
	 * findBookByTitle method--
	 * Allows position of the book object to be found within the 
	 * array by inserting the title
	 * @param title of the book to be found
	 * @return the position of the book
	 */
	public int findBookByTitle(String title)
	{
		int pos = -1;
		for (int i = 0; i < numBooks; i++)
		{
			if (title.equals(theBooks[i].getTitle()))
			{
				pos = i;
			}
		}
		return pos;
	}
	
	/**
	 * checkBookOut method--
	 * Allows the a book object to be checked out for as 
	 * long as the book object's status is "available"
	 * @param title of the book to check out
	 * @return true if the book is available, false 
	 * if it is not available
	 */
	public boolean checkBookOut(String title)
	{
		int find = this.findBookByTitle(title);
		for(int i = 0; i < numBooks; i++)
		{
			if (find < 0) 
			{
				return false;
			}
			else if(theBooks[find].getStatus().equals("Available"))
				theBooks[find].setStatus("Out");
			return true;
		}
			return false;
	
	}
	
	/**
	 * returnBook method--
	 * The book object will be returned as "available" for as
	 * long as its status is set to either "out" or "overdue"
	 * @param title of the book object to return
	 * @return true if the book can be returned, false
	 * if it cannot
	 */
	public boolean returnBook(String title)
	{
		int find = this.findBookByTitle(title);
		for (int i = 0; i < numBooks; i++)
		{
			if (find < 0)
			{
				return false;
			}
			
			else if(theBooks[find].getStatus().equals("Out") ||
					theBooks[find].getStatus().equals("Overdue"))
			{
				theBooks[find].setStatus("Available");
				return true;
			}
		}
		return true;
	}
	
	/**
	 * markOverdue method--
	 * The status of the book object will be marked "overdue"
	 * if the status is already set to "out"
	 * @param title of the book to be marked overdue
	 * @return true if the book can be marked "overdue",
	 * false if the book cannot
	 */
	public boolean markOverdue(String title)
	{
		int find = this.findBookByTitle(title);
		for (int i = 0; i < numBooks; i++)
		{
			if  (find < 0)
			{
				return false;
			}
			else if(theBooks[find].getStatus().equals("Out") || 
					theBooks[find].getStatus().equals("Overdue"))
			{
				theBooks[find].setStatus("Overdue");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * findBookByStatus method--
	 * Allows a book object to be found within the array
	 * depending on status
	 * @param status of the book to be found
	 * @return the book object found
	 */
	public String findBookByStatus(String status)
	{
		String str = "";
		for (int i = 0; i < numBooks; i++)
		{
			if (theBooks[i].getStatus().equals(status))
			{
				str += theBooks[i].toString() + "\n";
			}
		}
		return str;
	}
	
	/**
	 * toString method--
	 * Returns a String representing the state of the Library
	 * @return a reference to the string containing all the
	 * books in the library
	 */
	public String toString()
	{	
		String str = "";
		for(int i = 0; i < numBooks; i++)
		{
			str += theBooks[i].toString() + "\n";
		}
		return str;
	}
}
