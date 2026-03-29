Maze Game – Debugging & Scoring
You’ve been given the code for a tiny maze game engine.

Conceptually, the project consists of:

Maze / grid logic – core maze representation and path-finding.
Game logic – movement rules, step counting, and scoring.
Unit tests – automated tests exercising the behaviour of the maze and game logic.
For this exercise, all of the code has been placed into one source file, with comments marking the original file boundaries (for example: a section for the maze logic, a section for the game logic, and a section for the tests).

The maze is a grid of characters:

S – start position
E – exit
. – free cell
# – wall
The player:

Starts at S.
Can move using four directions: up, down, left, and right.
Constraint: While the player may move up/down/left/right, the game’s path-finding helper and scoring intentionally evaluate shortest paths using Down/Right-only movement.
Cannot leave the grid.
Cannot walk through walls.
The engine tracks:

The current position of the player.
The number of steps taken.
Whether the player has reached the exit.
There is also:

A helper that computes the shortest path length from a given position to the exit, restricted to moving only down or right.
A scoring function that rewards paths that are closer to the optimal shortest path as computed by the helper from start to exit.
Your task:

Run the unit tests.
Use the failing tests to identify bugs or missing behaviour.
Fix the code so that all tests pass.
Keep your changes as small and focused as possible.
Treat the tests as the specification of the correct behaviour for the maze game.