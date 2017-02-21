package assignment1;

import javax.swing.table.TableModel;

import java.util.Vector;
import java.util.List;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.*;

public class CinemaManager extends Display{
	private static Icon myIcon = new ImageIcon("..\\Assignment 1 2016\\images\\c.jpg");
	private static Icon anIcon = new ImageIcon();

	public Vector<Movie> movieList = new Vector<Movie>();

	/*
	 * //for (Movie x : movieList) //System.out.println(x);
	 * //System.out.println("You have added "+movieList.size()
	 * +" to the Cinema app!"); //JOptionPane.showMessageDialog(null,
	 * movieList);
	 * 
	 * }
	 */

	public int menuMain()

	{
		if (movieList.isEmpty()) {

			Movie a = new Movie("Star Wars", 120, "...", "......");
			movieList.add(a);
			Movie b = new Movie("Lord of The Rings", 180, "....", "...");
			movieList.add(b);
			Movie c = new Movie("Avengers", 115, "....", "...");
			movieList.add(c);
		}
		int option = 0;

		String opt1 = new String("                          Welcome to Empire Cinemas ");
		String opt2 = new String("Please from choose one of the following options below (1-5): ");
		String opt3 = new String("\n");
		String opt4 = new String("1. Add a new movie");
		String opt5 = new String("2. Show existing movies in the cinema app");
		String opt6 = new String("3. Show details of a specific movie");
		String opt7 = new String("4. Update a specific movie's details");
		String opt8 = new String("5. Delete a specific movie");
		String opt9 = new String("6. Exit App");
		String msg = new String("Enter Option:");
		JTextField opt = new JTextField("");

		Object message[] = new Object[12];
		message[0] = myIcon;
		message[1] = opt1;
		message[2] = opt2;
		message[3] = opt3;
		message[4] = opt4;
		message[5] = opt5;
		message[6] = opt6;
		message[7] = opt7;
		message[8] = opt8;
		message[9] = opt9;
		message[10] = msg;
		message[11] = opt;

		int response = JOptionPane.showConfirmDialog(null, message, "Empire Cinema (Staff Admin)",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE /* anIcon */);

		if (response == JOptionPane.CANCEL_OPTION || response == JOptionPane.CLOSED_OPTION)
			option = 6;
		else {
			try {
				option = Integer.parseInt(opt.getText());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"You cannot leave the fields empty. Please enter a number between 1 and 6 (Inclusive).");
			}
		}

		return option;

	}

	////////////////////////////////////////////////////////////////////////////////////////
	public void addMovie() {

		String msg1 = new String("1. Enter the title of the movie below: ");
		String msg2 = new String("2. Enter the length of the movie below (in minutes): ");
		String msg3 = new String("3. Enter a quick summary of the movie below:");
		String msg4 = new String("4. Enter the director of the movie below:");
		JTextField title = new JTextField("");
		JTextField runningTime = new JTextField("");
		JTextField summary = new JTextField("");
		JTextField director = new JTextField("");
		JCheckBox cb = new JCheckBox("Over 18?");

		Object message[] = new Object[10];
		message[0] = myIcon;
		message[1] = msg1;
		message[2] = title;
		message[3] = msg2;
		message[4] = runningTime;
		message[5] = msg3;
		message[6] = summary;
		message[7] = msg4;
		message[8] = director;
		message[9] = cb;

		int response = JOptionPane.showConfirmDialog(null, message, "Enter new movie details:",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE /* anIcon */);

		if (response == JOptionPane.CANCEL_OPTION)
			;

		else {
			try {
				Movie aMovie = new Movie(title, runningTime, summary, director);
				aMovie.setTitle(title.getText());
				aMovie.setRunningTime(Integer.parseInt(runningTime.getText()));
				aMovie.setSummary(summary.getText());
				aMovie.setDirector(director.getText());

				addMovieToList(aMovie);

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null,
						"Sorry, there was an error in adding that movie. You've either: \n 1. Entered a number that is not a whole number(e.g 120), or \n 2. You've left a field blank."
								+ "\nPlease check and try again.");
			}

		}
	}

	/////////////////////////////////////////////////////////////////////////////////////

	private void addMovieToList(Movie aMovie) {
		try {

			movieList.add(aMovie);

			JOptionPane.showMessageDialog(null, "The movie has been added to the cinema app successfully.");

		}

		catch (Exception sqle) {
			JOptionPane.showMessageDialog(null, "Insert Into List Error" + sqle);
		}
	}

	//////////////////////////////////////////////////////////////////////////

	public void showSpecificMovie() {

		String textTitle = JOptionPane
				.showInputDialog("Please enter the title of the specific movie you're looking for: ");
		JTextField title = new JTextField(textTitle);

		boolean found = false;
		int i = 0;

		while (!found && i < movieList.size()) {

			if (movieList.get(i).getTitle().equalsIgnoreCase(textTitle)) {
				movieList.get(i).display();
				found = true;
			}
			i++;

		}

		if (!found)
			JOptionPane.showMessageDialog(null, "Sorry, that movie does not exist..");

	}

	////////////////////////////////////////////////////////////////////////////////////

	public void showAllMovies() {
		JOptionPane.showMessageDialog(null, "There are currently " + movieList.size() + " movies in the movie app.");
		JOptionPane.showMessageDialog(null, movieList.Display());
	}  
	
	
	public void removeSpecificMovie() {

		String textTitle = JOptionPane
				.showInputDialog("Please enter the title of the specific movie you want to delete: ");
		JTextField title = new JTextField(textTitle);

		boolean found = false;
		int i = 0;

		int removeIndex = 0;

		for (i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getTitle().equalsIgnoreCase(textTitle)) {

				found = true;
				removeIndex = i;

			}

		}

		if (!found)
			JOptionPane.showMessageDialog(null, "Sorry, that movie does not exist..");
		else {
			movieList.remove(removeIndex);
			JOptionPane.showMessageDialog(null, "The movie has been deleted from the cinema app successfully.");
		}

	}

	 public void Display(){
	        JFrame frame = new JFrame("JTable Test Display");

	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());

	        JTable table = new JTable();

	        JScrollPane tableContainer = new JScrollPane(table);

	        panel.add(tableContainer, BorderLayout.CENTER);
	        frame.getContentPane().add(panel);

	        frame.pack();
	        frame.setVisible(true);
	    }

	public void updateSpecificMovie(){


		try {

			String msg=JOptionPane.showInputDialog(null, "Enter movie name you want to Update");
			String name = msg;

			for(Movie a : movieList){
				if(a.getTitle()==name) {

					JTextField title = new JTextField(a.getTitle() ); 
					JTextField runningTime = new JTextField(a.getRunningTime());
					JTextField summary = new JTextField(a.getSummary());
					JTextField director = new JTextField(a.getDirector());


					Object message[] = new Object[8];

					message[0]=new String(" Name:");
					message[1]=title;
					message[2]=new String("time:");
					message[3]=runningTime;
					message[4]=new String("summary:");;
					message[5]=summary;
					message[6]=new String("director:");
					message[7]=director;

					int response = JOptionPane.showConfirmDialog(null, message, "Empire Cinema (Staff Admin)",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE /* anIcon */);

					if( response==JOptionPane.OK_OPTION) {
					}
					else {
						try {

							Movie aMovie = new Movie(
									a.setTitle(title.getText()),
									a.setRunningTime(Integer.parseInt(runningTime.getText()),
											a.setSummary( summary.getText()),
											a.setDirector(director.getText()));
									addMovieToList(aMovie);
						} catch (Exception e) 
						{
							JOptionPane.showMessageDialog(null,
									"Sorry, there was an error in adding that movie. You've either: \n 1. Entered a number that is not a whole number(e.g 120), or \n 2. You've left a field blank." + "\nPlease check and try again.");
						}
					}
					
				
			}
				}
			}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
