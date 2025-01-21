import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CreateArray {
    //Variables to store number of rows and columns so the array will be generated in appropriate size
    public static int numberOfRows;
    public static int numberOfColumns;

    //The method to read the city names from header of the given CSV file (first line)
    //and returns the header as a String array
    //Time complexity of this method is O(n)
    public static String[] getHeaderFromCsv(File filePath){
        //opens the file using Scanner with "try-with-resources"
        try (Scanner scanner = new Scanner(filePath)) {
            
            // Check if the file is empty or not
            if (scanner.hasNextLine()) {
                // Read the first line
                String line = scanner.nextLine();
                // Check if the line starts with a comma and remove it if true
                if (line.startsWith(",")) line = line.substring(1);

                /* Uses comma as delimiter to store the header elements in a String array called "header"
                The time complexity of this line depends on the number of comma seperated elements so time complexity is O(n) */
                String[] header = line.split(",");
                
                return header;
            }
            // If the file is empty, a warning message is printed and an empty array is returned
            else {
                System.err.println("WARNING!! File is empty! Returning an empty array!");
                return null;
            }        
        }
        catch (FileNotFoundException e) {
            System.err.println("WARNING!! File not found! Returning an empty array!");
            return null;
        }  
}


    // A method to create and return a 2D integer array toget distances from CSV file
    // Time complexity of this method is O(n^2)
    public static int[][] getDistancesFromCsv (File filePath) {
        
        // Opens the file using Scanner with "try-with-resources"    
        try (Scanner scanner = new Scanner(filePath)) {
        // This try block is used for calculating the required dimenisons for the 2D array to create
            // Check if the file is empty or not
            if (scanner.hasNextLine()) {
                String[] header = getHeaderFromCsv(filePath); // header is read from the file using the method above
                // number of elements in the header will be equal to number of columns
                numberOfColumns = header.length;
                // Since we are working with a square adjacency matrix, number of rows will be equal to number of columns
                numberOfRows = numberOfColumns;
            }
                
            else {
                System.err.println("WARNING!! File is empty! Returning an empty array!");
                return null;
            }       

            
            //An empty integer array is created with the proper dimensions
            int[][] distancesArray = new int[numberOfRows][numberOfColumns];
            

            //Changes scanner's delimiter to comma to properly seperate elements in CSV file
            scanner.useDelimiter("[,\\s]+");
            // This for loop is used to read the elements from the file and store them in the 2D array
            // Time complexity of this loop is O(n^2)
            for (int i = 0; i < numberOfRows; i++) {
                scanner.nextLine(); //Goes to next line for the next rows (Also, first line of the file is skipped since it only contains city names)
                scanner.next(); //The first element of all rows are skipped since it is a city name
                for (int j = 0; j < numberOfColumns; j++) {
                    if (scanner.hasNextInt()) {
                        distancesArray[i][j] = scanner.nextInt();
                    }
                    else {
                        System.out.print("Skipping non-integer character");
                    }
                }

            }
            return distancesArray; //Created integer distances 2D array is returned
        }
        // If the file is not found, a warning message is printed and an empty array is returned
        catch (FileNotFoundException e) {
            System.err.println("WARNING!! File not found! Returning an empty array!");
            return null;
        }
    }
}