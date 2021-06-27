# Sudoku Solver
<p>
Java program which takes a sudoku puzzle from the user through a GUI(graphical user interface) and solves it, then presents the solution to the user. It solves sudoku puzzles through a recursive backtracking algorithm, and it uses the Swing API to create a GUI to display the sudoku board and solved puzzle.
</p>

  <h3>Optimizations to be incorporated later:</h3>
  <ul>
    <li>https://norvig.com/sudoku.html</li>
    <li>https://en.wikipedia.org/wiki/Exact_cover#Sudoku</li>
  </ul>

<b>Cool Note:</b> 
<p>
  Solving an n x n sudoku puzzle is an iconic NP-complete problem(<a href="https://en.wikipedia.org/wiki/Exact_cover">Exact Cover</a>). It's runtime is exponential(9^n), and it's relatively fast to check that the solution is correct(81 steps, since we have to check the whole board).
</p>
