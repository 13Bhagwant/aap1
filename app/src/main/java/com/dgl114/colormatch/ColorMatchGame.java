package com.dgl114.colormatch;
import java.util.Random;

import android.graphics.Color;

public class ColorMatchGame {

        public static final int NUM_ROWS = 3;
        public static final int NUM_COLS = 3;

        private Button[][] mButtons;

        public ColorMatchGame() {mButtons = new Button[NUM_ROWS][NUM_COLS]; }

        public void newGame() {
            // Declaration of the target button instances
            Random randomNumGenerator = new Random();
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    //replace randomNumGenerator.nextBoolean() with some way to create a new button
                    mButtons[row][col] = randomNumGenerator.nextBoolean();
                }
            }
            //Assign the color values from two buttons in the grid to the target Button instances;
            // use to chooseWinningCombination()
        }
        // modify it to become isButtonSelected
        public boolean isLightOn(int row, int col) {
            return mButtons[row][col];
        }

        public void selectLight(int row, int col) {
            mLights[row][col] = !mLights[row][col];
            if (row > 0) {
                mLights[row - 1][col] = !mLights[row - 1][col];
            }
            if (row < NUM_ROWS - 1) {
                mLights[row + 1][col] = !mLights[row + 1][col];
            }
            if (col > 0) {
                mLights[row][col - 1] = !mLights[row][col - 1];
            }
            if (col < NUM_COLS - 1) {
                mLights[row][col + 1] = !mLights[row][col + 1];
            }
        }

        public boolean isGameOver() {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    if (mLights[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public String getState() {
            StringBuilder boardString = new StringBuilder();
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    char value = mLights[row][col] ? 'T' : 'F';
                    boardString.append(value);
                }
            }

            return boardString.toString();
        }

        public void setState(String gameState) {
            int index = 0;
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    mLights[row][col] = gameState.charAt(index) == 'T';
                    index++;
                }
            }
        }

}
