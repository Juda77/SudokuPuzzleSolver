import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI {

	public static void main(String[] args) {

		SudokuGUI gui = new SudokuGUI();
		gui.setupGUI(new int[9][9], gui);
	}

	public void setupGUI(int[][] board, SudokuGUI gui) {

		JFrame frame = new JFrame("Sudoku Solver"); //main window
		JPanel panel = new JPanel();
		JTextField[][] textFields = new JTextField[9][9];

		panel.setLayout(new GridLayout(10, 9));
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				textFields[row][col] = new JTextField();
				panel.add(textFields[row][col]);
			}
		}

		JButton submitButton = new JButton("Solve this Sudoku puzzle!");
		panel.add(submitButton);
		frame.add(panel);

		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //activates the red cross button
		frame.setVisible(true); //makes JFrame visible

		//if the submit button is pressed, take all input from the textfields
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == submitButton) {

					boolean givenValidPuzzle = true;
					for (int row = 0; row < 9; row++) {
						for (int col = 0; col < 9; col++) {

							String textFieldValue = textFields[row][col].getText();
							int currCell = 0;
							try {

								currCell = Integer.parseInt(textFieldValue);

							} catch(Exception e) {

								givenValidPuzzle = false;
								System.out.println("hi");
								System.out.println("Cell " + row + ", " + col + " is not a valid number");

							}

							if (currCell < 0 || 10 <= currCell) {

								givenValidPuzzle = false;
								System.out.println("hi");
								System.out.println("Cell " + row + ", " + col + " is not a valid number");
							} else {
								board[row][col] = currCell;
							}

						}

					}

					if (givenValidPuzzle) {
						SudokuSolver.solveSudoku(board, gui);
					}

				}

			}

		});

	}

	//method which presents user with the solved sudoku board
	public void presentSolvedPuzzleGUI(int[][] board) {

		JFrame frame = new JFrame("Sudoku Puzzle Solved"); //main window
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(10, 9));
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {

				JTextField textField = new JTextField();
				textField.setText(board[row][col] + "");
				panel.add(textField);
			}
		}

		frame.add(panel);

		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //activates the red cross button
		frame.setVisible(true); //makes JFrame visible
	}
}
