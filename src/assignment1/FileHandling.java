package assignment1;

import java.util.Vector;
import java.io.*;

public class FileHandling {

	public void writeArrayListToFile() {

		Vector<Movie> movieList = new Vector<Movie>();
		
		Movie a = new Movie("Star Wars", 120, "...", "......");
		movieList.add(a);
		Movie b = new Movie("Lord of The Rings", 180, "....", "...");
		movieList.add(b);
		Movie c = new Movie("Avengers", 115, "....", "...");
		movieList.add(c);
		

		try {
			File f = new File("CinemaApplication.doc");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(movieList);

			System.out.println("Written to file!");
			
			
			oos.close();
			fos.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		    for (Movie n : movieList)			
			System.out.println(n);
	}

	public void readArrayListFromFile() {
		Vector<Movie> movieList =  null;
		

		try {
			File f = new File("CinemaApplication.doc");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Vector<Movie> readObject = (Vector<Movie>) ois.readObject();
			movieList = readObject;

			System.out.println("Read from file!");
			
			
			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		   for (Movie n : movieList)
			System.out.println(n);
	}
}
