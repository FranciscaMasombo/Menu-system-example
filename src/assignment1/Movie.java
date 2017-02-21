package assignment1;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Movie implements Serializable{

	private String title;
	private int runningTime;
	private String summary;
	private String director;

	public Movie(JTextField title, JTextField runningTime, JTextField summary, JTextField director) {
		this.title = "";
		this.runningTime = 0;
		this.summary = "";
		this.director = "";
	}

	public Movie(String title, int runningTime, String summary, String director)

	{

		this.title = title;
		this.runningTime = runningTime;
		this.summary = summary;
		this.director = director;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDirector() {

		return director;
	}

	public void setDirector(String director) {
		this.director = director;

	}

	public String toString() {
		return ("Title: " + title + "\n Length of this movie: " + runningTime + " minutes"
				+ "\n Summary: " + summary + "\n Director: " + director + "\n" + "\n");
	}

	public void display() {

		JOptionPane.showMessageDialog(null, "Title: " + title + ",\n Length of this movie: " + runningTime + " minutes"
				+ ",\n Summary: " + summary + ",\n Director: " + director);
	}

	public static void setElementAt(JTextField title2, JTextField title22) {
		// TODO Auto-generated method stub
		
	}

	public static void add(int i, JTextField title2) {
		// TODO Auto-generated method stub
		
	}

	public static void setTitle(int i, JTextField title2) {
		// TODO Auto-generated method stub
		
	}

}
