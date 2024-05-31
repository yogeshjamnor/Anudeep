import java.time.Month;
public class MonthDay 
{
public static void main(String[] args)
		{
		// Loop through all months in the enum
		for (Month month : Month.values()) 
			{
			// Print the month name and total number of days
			// Using Month.length(boolean leapYear) to get the total number of days in the month
			// Passing false to ensure it doesn't consider a leap year
			System.out.println(month.toString() + ": " + month.length(false) + " days");
			}
		}
}