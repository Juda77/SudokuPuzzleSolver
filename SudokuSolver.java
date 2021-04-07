import java.util.HashSet;

public class SudokuSolver {
 
    static HashSet<Integer>[] rowSets = new HashSet[9];
    static HashSet<Integer>[] colSets = new HashSet[9];
    static HashSet<Integer>[] boxSets = new HashSet[9];
 
    public static void main(String[] args) {}

    public static void solveSudoku(int[][] board, SudokuGUI gui) {
        
        initializeSets(board);
        
        boolean sudokuPuzzleIsSolvable = traverseBoard(board, 0, 0);
        if (sudokuPuzzleIsSolvable) {
  
        	gui.presentSolvedPuzzleGUI(board);

        } else {
            System.out.println("Sudoku puzzle is not solvable");
        }
 
    }
    
    private static boolean traverseBoard(int[][] board, int row, int col) {
        
        if (row == 9) {
            return true;
        } else if (col == 9) {
            return traverseBoard(board, row + 1, 0);
        } else if (board[row][col] != 0) {
            return traverseBoard(board, row, col + 1);
        } else if (board[row][col] == 0) {
            
            int boxIndex = determineBox(row, col);
            //find a valid current spot
            for (int numChoice = 1; numChoice <= 9; numChoice++) {
    
                boolean numChoiceIsValid = !rowSets[row].contains(numChoice) 
                    && !colSets[col].contains(numChoice) 
                    && !boxSets[boxIndex].contains(numChoice);
                
                boolean allChoicesBeyondAreValid = false;
                if (numChoiceIsValid) {
                    board[row][col] = numChoice;
                    rowSets[row].add(numChoice);
                    colSets[col].add(numChoice);
                    boxSets[boxIndex].add(numChoice);
                    allChoicesBeyondAreValid = traverseBoard(board, row, col + 1);
                    if (allChoicesBeyondAreValid) {
                        return true;
                    } else {
                        board[row][col] = 0;
                        rowSets[row].remove(numChoice);
                        colSets[col].remove(numChoice);
                        boxSets[boxIndex].remove(numChoice);

                    }
                }
                
            }
                       
        }
        
        return false;
    	
    }

    private static int determineBox(int row, int col) {

        boolean rowIsIn1stTriSection = row <= 2;
        boolean rowIsIn2ndTriSection = 3 <= row && row <= 5;
        boolean rowIsIn3rdTriSection = 6 <= row;

        boolean colIsIn1stTriSection = col <= 2;
        boolean colIsIn2ndTriSection = 3 <= col && col <= 5;
        boolean colIsIn3rdTriSection = 6 <= col;

        if (rowIsIn1stTriSection && colIsIn1stTriSection) {
            return 0;
        } else if (rowIsIn1stTriSection && colIsIn2ndTriSection) {
            return 1;
        } else if (rowIsIn1stTriSection && colIsIn3rdTriSection) {
            return 2;
        } else if (rowIsIn2ndTriSection && colIsIn1stTriSection) {
            return 3;
        } else if (rowIsIn2ndTriSection && colIsIn2ndTriSection) {
            return 4;
        } else if (rowIsIn2ndTriSection && colIsIn3rdTriSection) {
            return 5;
        } else if (rowIsIn3rdTriSection && colIsIn1stTriSection) {
            return 6;
        } else if (rowIsIn3rdTriSection && colIsIn2ndTriSection) {
            return 7;
        } else {
            return 8;
        }
        
    }

    private static void initializeSets(int[][] board) {

        for (int i = 0; i < 9; i++) {

            rowSets[i] = new HashSet<Integer>();
            colSets[i] = new HashSet<Integer>();
            boxSets[i] = new HashSet<Integer>();

        }
    
        for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			
    			int cell = board[i][j];
    			if (cell != 0) {
    				
    				rowSets[i].add(cell);
    				colSets[j].add(cell);
    				boxSets[determineBox(i, j)].add(cell);
    				
    			}
    			
    		}
    		
    	}
        
    }

}
