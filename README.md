# Sudoku Solver
<p>
Java program which takes a sudoku puzzle from the user through a GUI(graphical user interface) and solves it, then presents the solution to the user. It solves sudoku puzzles through a recursive backtracking algorithm, and it uses the Swing API to create a GUI to display the sudoku board and solved puzzle.
</p>
<header><h3>Brief Runtime Analysis</h3><header>
<p>
  My algorithm runs, in the worst possible case(where we are unable to find a solution to the board), in <b>O(9^n)</b> time, where n = number of open spots at the start. This is because I use recursive backtracking, and the worst scenario occurs when we exhaust eeeevvvvveerrrryyy possible combination of numbers on the board. Since each spot has 9 different possible choices, the runtime is <b>9^(number of spots)</b>. There are also constant factors involved(like traversing the GUI to get the user's input board and traversing the GUI again to present the solution to the user), but those factors pale in comparison to the exponential runtime factor, so they are ignored.
</p>
  <h3>Optimizations to be incorporated later:</h3>
  <ul>
    <li>https://norvig.com/sudoku.html</li>
    <li>https://en.wikipedia.org/wiki/Exact_cover#Sudoku</li>
  </ul>

<b>Cool Note:</b> 
<p>
  Solving an n x n sudoku puzzle is an iconic NP-complete problem(<a href="https://en.wikipedia.org/wiki/Exact_cover">Exact Cover</a>) because its runtime is exponential(9^n), and it's relatively fast to check that the solution is correct(81 steps, since we have to check the whole board).
</p>
