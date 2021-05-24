# Sudoku Solver
<p>
Java program which takes a sudoku puzzle from the user through a GUI(graphical user interface) and solves it, then presents the solution to the user. It solves sudoku puzzles through a recursive backtracking algorithm, and it uses the Swing API to create a GUI to display the sudoku board and solved puzzle.
</p>
<header><h3>Brief algorithm analysis</h3><header>
<p>
  My algorithm runs, in the worst possible case(where we are unable to find a solution to the board), O(9^n), where n = number of open spots at the start. This is because I use recursive backtracking, and the worst scenario occurs when we exhaust eeeevvvvveerrrryyy possible combination of numbers on the board. Since each spot has 9 different possible choices, the runtime is 9^(number of spots).
</p>

