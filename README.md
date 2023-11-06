# SnakeGame
 SnakeGame

The game we have created used WASD keys to move around followed by the enter key. We admit having to use the enter key isnt optimal but given your rules that the snake had to move at a certain speed there was no way to do this without using external libraries.

For now our program runs using two threads (in game class). One awaits user input and changes the snakes direction when input is detected. The other is responsible for the rest of the game logic as well as plotting the actual visuals on the console.


