import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Library library = new Library();
            //Imports "libraryHoldings.txt"
            File f = new File("libraryHoldings.txt");
            Scanner fileScan = new Scanner(f);
            String author;
            String title;
            String status;
            String sNumStudents;
            int numStudents;

            // Scans and stores the first line
            // (number of books) as a String
            sNumStudents = fileScan.nextLine();
            // Converts the String into an integer
            numStudents = Integer.parseInt(sNumStudents);

            // Stores each line of the file and stores them within
            // their respective variables used to create a book
            // object and stored within the library
            for (int i = 0; i < numStudents; i++) {
                title = fileScan.nextLine();
                author = fileScan.nextLine();
                status = fileScan.nextLine();
                Book books = new Book(title, author, status);
                library.insertBook(books);
            }
            fileScan.close();

            int options;

            // The do-while loop will continue to loop the program until the user selects option 4
            do {
                // First set of choices to be presented to the user
                String[] choices = {"Check Out Book", "Return Book", "Mark Book as Overdue",
                        "Show Books", "Quit"};

                options = JOptionPane.showOptionDialog(null, "Enter your choice...", "Main Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        choices, choices[0]);
                //Will allow user to check book out
                if (options == 0)
                {
                    String findBook = JOptionPane.showInputDialog("Enter the title of the book to"
                                                                    + " check out:");
                    library.checkBookOut(findBook);
                    //returns true if the book can be checked out
                    if (library.checkBookOut(findBook) == true)
                    {
                        JOptionPane.showMessageDialog(null, "The book " + findBook 
                                                        + " was checked out.", "Result of checked out",
                                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    //returns false if the book cannot be checked out
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "The book " + findBook + " could not be checked out"
                                                        , "Result of checked out", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            
                //will allow user to return a book
                else if (options == 1)
                {
                    String returnBook = JOptionPane.showInputDialog("Enter the title of the book to return: ");
                    library.returnBook(returnBook);
                    
                    //returns true if the book can be returned 
                    if (library.returnBook(returnBook) == true)
                    {
                        JOptionPane.showMessageDialog(null, "The book " + returnBook + " was returned.",
                                                        "Result of book return", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //returns false if the book cannot be returned
                    else
                    {
                        JOptionPane.showMessageDialog(null,  "The book " + returnBook + " could not be returned.");
                    }
                
                }
            
                //will allow a user to mark a book as overdue
                else if (options == 2)
                {
                    String bookOverdue = JOptionPane.showInputDialog("Enter the title of the book to mark overdue: ");
                    library.markOverdue(bookOverdue);
                    
                    //returns true if books are successfully marked overdue
                    if (library.markOverdue(bookOverdue) == true)
                    {
                        JOptionPane.showMessageDialog(null, "The book " + bookOverdue + " was marked overdue.",
                                                        "Result of mark book overdue", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //returns false if books cannot be marked overdue
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "The book " + bookOverdue + " could not be marked "
                                                        + "overdue.", "Result of mark book overdue", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            
                //will allow a user to see books based on status
                else if (options == 3)
                {
                    String[] statusChoice = {"Overdue", "Out", "Available"};
                    int statusChoiceUser = JOptionPane.showOptionDialog(null, "Enter your status choice...",
                                                                        "Main Menu", JOptionPane.DEFAULT_OPTION,
                                                                        JOptionPane.QUESTION_MESSAGE, null, 
                                                                        statusChoice, statusChoice[0]);
                
                    //displays books that are overdue
                    if(statusChoiceUser == 0)
                    {
                        JOptionPane.showMessageDialog(null, library.findBookByStatus("Overdue"), "Books by status", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    //displays books that are out
                    else if(statusChoiceUser == 1)
                    {
                        JOptionPane.showMessageDialog(null, library.findBookByStatus("Out"), "Books by status",
                                                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    //displays books that are available
                    else if(statusChoiceUser == 2)
                    {
                        JOptionPane.showMessageDialog(null, library.findBookByStatus("Available"), "Books by status",
                                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } while(options != 4);
        // Handle when red x is pressed 
        } catch (HeadlessException e) {
            System.out.println("Red X button clicked!");
            System.exit(0);
        }
	}
}
