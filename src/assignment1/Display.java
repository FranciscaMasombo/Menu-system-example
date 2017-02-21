/**
 * 
 */
package assignment1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Francisca
 *
 */
public class Display  {
	  public Display() {
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

	    public static void main(String[] args) {
	        new Display();
	        
	        
	        
	    }
}
