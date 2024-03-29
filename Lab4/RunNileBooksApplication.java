import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * A class that connects to PostgreSQL and disconnects.
 * You will need to change your credentials below, to match the usename and password of your account
 * in the PostgreSQL server.
 * The name of your database in the server is the same as your username.
 * You are asked to include code that tests the methods of the NileBooksApplication class
 * in a similar manner to the sample RunStoresApplication.java program.
*/


public class RunNileBooksApplication
{
    public static void main(String[] args) {

    	Connection connection = null;
    	try {
    	    //Register the driver
    		Class.forName("org.postgresql.Driver");
    	    // Make the connection.
            // You will need to fill in your real username
            // and password for your Postgres account in the arguments of the
            // getConnection method below.
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://cmps180-db.lt.ucsc.edu/rabhatna",
                                                     "rabhatna",
                                                     "Rbh97!15");

            if (connection != null)
                System.out.println("Connected to the database!");

            //Creating instance of NileBooksApplication
            NileBooksApplication nba = new NileBooksApplication(connection);

            List output1 = nba.getAuthorsWithManyReviewedBooks(3);
            /*Output of getAuthorsWithManyReviewedBooks
              When the parameters numberReviewedBooks is 3
              [111, 2192]
             */

            int output2 = nba.fixTotalOrdered(94519);
            /* Output of fixTotalOrdered when the
               aPublisherIDtoFix is 94519
               9
             */

            int output3 = nba.increasePublishersPrices(98035,2);
            System.out.println(numberUpdated);
            /* Output of increasePublishersPrices when
               publisherID is 98035 and theCount is 2
               2
            */
            
            int output4 = nba.increasePublishersPrices(98035,4);
            /* Output of increasePublishersPrices when
               publisherID is 98035 and theCount is 4
               4
            */

            connection.close();

    	}
    	catch (SQLException | ClassNotFoundException e) {
    		System.out.println("Error while connecting to database: " + e);
    		e.printStackTrace();
    	}
    	finally {
    		if (connection != null) {
    			// Closing Connection
    			try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection: " + e);
					e.printStackTrace();
				}
    		}
    	}
    }
}
