/**
 * File: RadioGaGa.java
 * Author: Li Jingwei
 * Date: November 18, 2015
 * Purpose: CSCI 1110, Assignment 8
 * 
 * Description: This program reads in a song database, and a sequence of song requests, spanning
 * multiple days, and outputs a long play-list of specified length for each following day.
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the RadioGaGa class of the program containing all the program code.
 * It implements the play list order of songs.
 */
public class RadioGaGa {

	/**
	 * This method is called when the program starts running.
	 * It reads in a number of lines from the console, instantiate the song
	 * list and output the result sorted.
	 */
	public static void main(String[] args) 
	{
		// Instantiate new scanner to read from the console.
		Scanner keyboard = new Scanner(System.in);
		
		// Get the number of songs.
		int n = keyboard.nextInt();
		
		// Define the map.
		MyMap<String,Song> map = new MyMap<String,Song>();
		
		// Define the array for songs.
		Song[] songs = new Song[n];
		
		// Create variables for storing input from the console.
		String name;
		int time;
		double pop;
		Song song;
		
		// Get the input variables and define the map of songs.
		for ( int i = 0; i < n; i++)
		{
			// Get the input from the console.
			name = keyboard.next();
			time = keyboard.nextInt();
			pop = keyboard.nextDouble();
			
			// Define the song variable.
			song = new Song(name, time, pop);
			
			// Store the values in the map.
			songs[i] = song;
			map.put(name, songs[i]);
		}
		
		// Create the variables.
		int maxSec = keyboard.nextInt() * 60;
		int sec = maxSec;
		double alpha = keyboard.nextDouble();
		int day = keyboard.nextInt();
		int[] days = new int[day];
		String request;
		
		// Define the string array list for storing requests.
		ArrayList<String> requests = new ArrayList<String>();
		
		// Get the requests input.
		for ( int i = 0; i < day; i++)
		{
			// Get the number of song requests.
			days[i] = keyboard.nextInt();
			
			// Get the song requests.
			for ( int m = 0; m < days[i]; m++)
			{
				// Get the input from the console.
				request = keyboard.next();
				
				// Add the input string into the array list.
				requests.add(request);
			}
		}
		
		// Sort the songs in order.
		Arrays.sort(songs);
		
		// Create the loop number.
		int m = 0;
		
		// Print the songs played on each day.
		for ( int i = 0; i <= day; i++)
		{
			// Print the day number and the space.
			System.out.print(i);
			
			// Loop through the song list.
			while ( m < n )
			{
				// Judge if the time left is enough for the next song.
				if (songs[m].time < sec)
				{
					// Print the song's name.
					System.out.print(" " + songs[m].name);
					
					// Calculate the time left.
					sec -= songs[m].time;
				}
				
				// Increment the loop number.
				m++;		
			}
			
			// Judge if the loop number reaches the maximum.
			if ( i != day )
			{
				// Reset the seconds number.
				sec = maxSec;
			
				// Calculate and get the next day songs' list.
				for ( int p = 0; p < days[i]; p++)
				{
					song = map.get(requests.get(0));
					song.request++;
					requests.remove(0);
				}
			
				// Loop through the songs' list.
				for ( m = 0; m < n; m++)
				{
					songs[m].pop = (double)songs[m].request / (double)days[i] * alpha + 
							( 1 - alpha ) * songs[m].pop;
				}
			
				// Sort the songs.
				Arrays.sort(songs);
			
				// Reset all the request number in the song class to zero.
				for ( m = 0; m < n; m++)
				{
					songs[m].request = 0;
				}
				
				// Reset the loop number.
				m = 0;
			}
			
			// Change the line.
			System.out.println();
		}
	}
	
	// This class stores the values in each song.
	private static class Song implements Comparable<Song>
	{
		// Create the variables.
		String name;
		int time;
		double pop;
		int request = 0;
		
		Song( String name, int time, double popularity)
		{
			this.name = name;
			this.time = time;
			pop = popularity;
		}
		
		// Method for comparing song classes.
		public int compareTo( Song com )
		{
			// Judge the popularity of the songs.
			if ( this.pop > com.pop )
			{
				// Return -1 if this song is more popular than the input song.
				return -1;
			}
			else if ( this.pop < com.pop)
			{
				// Return 1 if the input song is more popular than this song.
				return 1;
			}
			else 
			{
				// Compare the time of songs when the popularity is the same.
				if ( this.time < com.time )
				{
					return -1;
				}
				else if ( this.time > com.time )
				{
					return 1;
				}
				else 
				{
					return this.name.compareTo(com.name);
				}
			}
		}
	}

}
