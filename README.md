# Sudoku Solver
<p>
Java program which takes a sudoku puzzle from the user through a GUI(graphical user interface) and solves it, then presents the solution to the user. It solves sudoku puzzles through a recursive backtracking algorithm, and it uses the Swing API to create a GUI to display the sudoku board and solved puzzle.
</p>
<header><h3>Brief Algorithm Analysis</h3><header>
<p>
  My algorithm runs, in the worst possible case(where we are unable to find a solution to the board), <b>O(9^n)</b>, where n = number of open spots at the start. This is because I use recursive backtracking, and the worst scenario occurs when we exhaust eeeevvvvveerrrryyy possible combination of numbers on the board. Since each spot has 9 different possible choices, the runtime is <b>9^(number of spots)</b>. There are also three constant factors involved: 
</p>
  <ul>
    <li>Traversing the GUI to obtain the input board values</li>
    <li>Traversing the input board values to initialize our sets</li>
    <li>Traversing the outcome board to display the solution on the GUI</li>
  </ul>
<p>
  But, since those constant factors cumulate to a total and constant factor of 243(3 * 81, since there are 81 spots on a sudoku board, and we're traversing it three times), then 
  we can simply ignore that factor, since it pales in comparison to the exponential runtime factor.
</p>

