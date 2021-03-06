/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package me.kalicinski.sudoku.engine

data class SudokuGame(var board: SudokuBoard, val seed: Long) {

    lateinit var solvedBoard: SudokuBoard

    fun calculateSolution() {
            val startingBoard = board.copy()
            for (i in 0 until SudokuBoard.BOARD_SIZE) {
                with(startingBoard) {
                    if (!isStartingValue(i)) {
                        clearValues(i)
                    }
                }
            }
            val solutions = SudokuSolver(SudokuSolver.defaultSolvers).solve(startingBoard)
            if (solutions.isNotEmpty()) {
                solvedBoard = solutions[0]
        }
    }
}