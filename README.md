# assignment1
 
Edit the activity_main.xml to present a UI similar to mine (consider including additional text output information - such as number of wins, or number of rounds).
All resource values should be handled in the appropriate resource file.
The app must run in both portrait and landscape modes.
The Button class contains all model logic for handling a Button. A button should know:
Whether or not it has been selected;
What color it contains.
The ColorMatchGame class contains all game logic. You may use Lights Out as a model; you should include the following methods:
newGame()
chooseWinningCombination() - a method to randomly choose the two winning buttons 
isButtonSelected() - to determine if a button has been selected
toggleButtonSelection() - to mark a button selected or unselected
isGameOver() - to determine if the player has won
The MainActivity class contains all controller logic. It activates the model and view as necessary. You may model this on the Lights Out app.
You need not modify the ColorUtilities class. It is provided for your use in blending button colors.
