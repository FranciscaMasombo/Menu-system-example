package assignment1;

public class CinemaApp {

	public static void main(String args[]) {
		int option;

		CinemaManager manager = new CinemaManager();
		
		do {
			option = manager.menuMain();

			switch (option) {
			case 1:
				manager.addMovie();
				break;
			case 2:
				manager.showAllMovies();
				break;
			case 3:
				manager.showSpecificMovie();
				break;

			case 4 : manager.updateSpecificMovie();
		 break;
			case 5:
				manager.removeSpecificMovie();
				break;
			case 6:
				break;
			default:
				break;
			}
		} while (option != 6);

		FileHandling d = new FileHandling();
		d.writeArrayListToFile();
		d.readArrayListFromFile();
	}
}
