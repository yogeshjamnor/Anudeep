//Write a Java program that reads an input file from the file system and outputs the content of the file character by character. Use FileReader.read() method to read characters from the file. At the end, print the total number of characters present in the file. 
import java.io.FileReader;
import java.io.IOException;
public class ReadFilebyCharacter
{
    public static void main(String[] args) 
    {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\yoges\\OneDrive\\Desktop\\Lab\\filereadbycharacter.txt");
            int character;
            int count = 0;

            while ((character = fileReader.read()) != -1) 
            {
                System.out.print((char) character);
                count++;
                //count the total words in file
            }

            fileReader.close();     // closing file
            //printing files chracter
            System.out.println("\nTotal number of characters: " + count);
           
        	}
	        catch (IOException e)
            {
	        	//print file not found error 
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	}
}