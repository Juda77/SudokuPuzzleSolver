"use strict";
(function() {


  /** "hash sets"(represented as JS objects) which track
   * which choices are taken for each row, column, and box
   */
  let rowSets = []
  let colSets = []
  let boxSets = []


  window.addEventListener("load", init);


  function init() {
    let solveButton = id("solve-button");
    solveButton.addEventListener("click", getSudokuPuzzle);
  }

  /**
   * Get the sudoku puzzle from the DOM and
   * into 2D array form
   */
  function getSudokuPuzzle() {


  }

  /**
   * Solve the sudoku puzzle using recursive backtracking
   * @param {2D array} board - sudoku puzzle represented as a 2D array
   * @param {int} row - current row index
   * @param {int} col - current col index
   * @returns {boolean} - return boolean representing whether or not
   * we were able to find a valid choice for the current spot
   */
  function solveSudoku(board, row, col) {

    const FILLED_BOARD = row === 9;
    const SPOT_IS_EMPTY = board[row][col] === 0;
    const MUST_START_NEXT_ROW = col === 9;
    const SPOT_ALREADY_FILLED = board[row][col] !== 0;
    if (FILLED_BOARD) {
      return true;
    } else if (MUST_START_NEXT_ROW){
      return solveSudoku(board, row + 1, 0);
    } else if (SPOT_ALREADY_FILLED) {
      return solveSudoku(board, row, col + 1);
    } else if (SPOT_IS_EMPTY) {

      // iterate through all possible choices
      for (let choice = 1; choice <= 9; choice++) {




      }

    }

  }

  /**
   * Check if the choice for the current spot is valid
   * @param {int} choice - choice of int for the spot
   * @param {int} row - curr row
   * @param {int} col - curr column
   * @returns {boolean} - return a boolean representing
   * whether or not the choice for the spot is valid
   */
  function choiceIsValid(choice, row, col) {

  }

  // The below 4 functions serve as helper functions related to DOM interaction
  function id(elementID) {
    return document.getElementById(elementID);
  }

  function qs(selector) {
    return document.querySelector(selector);
  }

  function qsa(selector) {
    return document.querySelectorAll(selector);
  }

  function gen(tag) {
    return document.createElement(tag);
  }

})();
