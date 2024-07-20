package com.AnudeepExam;
//Write a program to count the number of occurrences of each character 
//in a string and return the count as a map.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
	
public class Counter 
{
	public static void main(String[] args)
	{
		System.out.println("Enter word to check the occurance of characters:  ");
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		 Map<Character, Integer> charCountMap = new HashMap<>();

	        for (char c : word.toCharArray())
	        {
	            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
	        }

	        System.out.println(charCountMap);
	    }
}


