# --- requirements.txt ---
"""
No external dependencies. Uses Python standard library only.
"""

# --- maze.py ---

from __future__ import annotations

from dataclasses import dataclass
from typing import List, Tuple, Optional, Deque, Set
from collections import deque
import unittest

Coord = Tuple[int, int]


@dataclass
class Maze:
    """
    Represents a simple rectangular maze.

    grid:
        List of strings, each string is a row. Characters:
        - 'S' start
        - 'E' exit
        - '.' free space
        - '#' wall
    start:
        Starting coordinate (row, col).
    exit:
        Exit coordinate (row, col).
    """
    grid: List[str]
    start: Coord
    exit: Coord

    def in_bounds(self, pos: Coord) -> bool:
        """Return True if pos lies inside the grid."""
        r, c = pos
        rows = len(self.grid)
        cols = len(self.grid[0]) if rows else 0
        return 0 <= r < rows and 0 <= c < cols

    def is_wall(self, pos: Coord) -> bool:
        """True if the cell at pos is a wall."""
        r, c = pos
        return self.grid[r][c] == "#"

    def is_exit(self, pos: Coord) -> bool:
        """True if pos is the exit cell."""
        return pos == self.exit

    def shortest_path_length(self, from_pos: Optional[Coord] = None) -> Optional[int]:
        """
        Returns the length (number of steps) of the shortest path from from_pos
        to the exit, moving only DOWN or RIGHT, or None if no path exists.

        Uses a simple breadth-first search over reachable cells.
        """
        if from_pos is None:
            from_pos = self.start

        visited: Set[Coord] = set()
        queue: Deque[tuple[Coord, int]] = deque()
        queue.append((from_pos, 0))
        visited.add(from_pos)

        while queue:
            (r, c), dist = queue.popleft()
            if (r, c) == self.exit:
                return dist

            # Neighbours considered for path finding.
            for dr, dc in ((1, 0), (0, 1)):
                nr, nc = r + dr, c + dc
                nxt = (nr, nc)
                if not self.in_bounds(nxt):
                    continue
                if self.is_wall(nxt):
                    continue
                if nxt in visited:
                    continue
                visited.add(nxt)
                queue.append((nxt, dist + 1))

        return None


@dataclass
class MazeGame:
    """
    Simple game wrapper around a Maze.

    Tracks:
    - current position
    - steps taken

    Movement rules:
    - 'U' up, 'D' down, 'L' left, 'R' right (case-insensitive).
    - Out-of-bounds moves should be rejected without changing position or steps.
    - Moving into walls should be rejected without changing position or steps.
    - Valid moves update position and increment steps.
    """
    maze: Maze
    position: Coord
    steps_taken: int = 0

    def move(self, direction: str) -> str:
        """
        Apply a move in the given direction.

        Returns a short user-facing message.
        """
        if not direction:
            return "Please provide a direction."

        d = direction.upper()
        if d not in ("U", "D", "L", "R"):
            return "Invalid direction. Use U, D, L or R."

        delta = {
            "U": (-1, 0),
            "D": (1, 0),
            "L": (0, -1),
            "R": (0, 1),
        }[d]

        new_pos = (self.position[0] + delta[0], self.position[1] + delta[1])

        if not self.maze.in_bounds(new_pos):
            return "Move is out of bounds."

        if self.maze.is_wall(new_pos):
            # self.position = new_pos
            # self.steps_taken += 1
            return "You hit a wall."

        self.position = new_pos
        self.steps_taken += 1

        if self.maze.is_exit(self.position):
            return "You reached the exit!"
        return "Moved."

    def at_exit(self) -> bool:
        """True if the player is currently on the exit cell."""
        return self.maze.is_exit(self.position)

    def reveal_path_from_here(self) -> Optional[int]:
        """
        Convenience helper: returns the shortest path length from the
        current position to the exit, or None if no path exists.
        """
        return self.maze.shortest_path_length(self.position)

    def compute_score(self) -> int:
        """
        Deterministic, non-negative. Higher if steps_taken is close to the
        shortest possible path from start to exit.

        Intended behaviour (see tests for details):
        - If there is no path from start to exit, score should be 0.
        - If the game is not finished, calling this should raise a ValueError.
        - If the player reached the exit, the score should reflect how
          efficient the path was compared to the shortest path.

        The exact formula is up to you, as long as tests pass.
        """
        # raise NotImplementedError("Scoring not implemented yet.")
        L = self.maze.shortest_path_length(self.maze.start)
        if L is None:
            return 0
        if not self.at_exit():
            raise ValueError("Game not finished.")
        S = self.steps_taken
        # Perfect path: 100, each extra step: -10 points, never negative
        return max(0, 100 - 10 * (S - L))

        

# --- tests/test_maze.py ---


class TestMovementAndBounds(unittest.TestCase):
    def test_valid_move_updates_position_and_steps(self):
        grid = ["SE"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 1))
        game = MazeGame(maze=maze, position=maze.start)
        msg = game.move("R")
        self.assertEqual(game.position, (0, 1))
        self.assertEqual(game.steps_taken, 1)
        # Any non-empty message is acceptable here
        self.assertTrue(isinstance(msg, str) and msg)

    def test_move_out_of_bounds_does_not_change_position_or_steps(self):
        grid = ["SE"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 1))
        game = MazeGame(maze=maze, position=(0, 1))
        before_pos = game.position
        before_steps = game.steps_taken
        msg = game.move("R")  # off the right edge
        self.assertEqual(game.position, before_pos)
        self.assertEqual(
            game.steps_taken,
            before_steps,
            "Out-of-bounds move should not consume steps.",
        )
        self.assertIn("bounds", msg.lower())


class TestWalls(unittest.TestCase):
    def test_move_into_wall_does_not_move(self):
        grid = ["S#E"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 2))
        game = MazeGame(maze=maze, position=maze.start)
        msg = game.move("R")
        self.assertEqual(game.position, (0, 0))
        self.assertEqual(
            game.steps_taken,
            0,
            "Moving into a wall should not consume steps.",
        )
        self.assertIn("wall", msg.lower())

    def test_move_around_wall_reaches_exit(self):
        grid = [
            "S#.",
            "..E",
        ]
        maze = Maze(grid=grid, start=(0, 0), exit=(1, 2))
        game = MazeGame(maze=maze, position=maze.start)
        game.move("D")
        game.move("R")
        msg = game.move("R")
        self.assertTrue(game.at_exit())
        self.assertEqual(game.position, (1, 2))
        self.assertEqual(game.steps_taken, 3)
        self.assertIn("exit", msg.lower())


class TestShortestPath(unittest.TestCase):
    def test_shortest_path_simple_maze(self):
        grid = ["S.E"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 2))
        self.assertEqual(maze.shortest_path_length(), 2)

    def test_shortest_path_respects_down_and_right_only(self):
        grid = [
            "E..",
            "...",
            "..S",
        ]
        maze = Maze(grid=grid, start=(2, 2), exit=(0, 0))
        length = maze.shortest_path_length()
        self.assertIsNone(
            length,
            "From this start, there is no path that only moves down/right towards the exit.",
        )

    def test_shortest_path_none_when_blocked(self):
        grid = ["S#E"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 2))
        self.assertIsNone(maze.shortest_path_length())

    def test_reveal_path_from_here_matches_maze_shortest_path(self):
        grid = [
            "S..",
            "..E",
        ]
        maze = Maze(grid=grid, start=(0, 0), exit=(1, 2))
        game = MazeGame(maze=maze, position=maze.start)
        game.move("R")  # now at (0,1)
        expected = maze.shortest_path_length(game.position)
        self.assertEqual(game.reveal_path_from_here(), expected)


class TestScoring(unittest.TestCase):
    def test_score_perfect_path_higher_than_longer_path(self):
        grid = [
            "S..",
            "...",
            "..E",
        ]
        maze = Maze(grid=grid, start=(0, 0), exit=(2, 2))

        # Perfect path: exactly shortest path length
        perfect = MazeGame(maze=maze, position=maze.start)
        for d in ("R", "R", "D", "D"):
            perfect.move(d)
        self.assertTrue(perfect.at_exit())
        perfect_score = perfect.compute_score()

        # Longer, less efficient path that still reaches the exit
        longer = MazeGame(maze=maze, position=maze.start)
        for d in ("R", "D", "L", "R", "R", "D"):
            longer.move(d)
        self.assertTrue(longer.at_exit())
        longer_score = longer.compute_score()

        self.assertGreater(
            perfect_score,
            longer_score,
            "Perfect path should yield a higher score than a longer, inefficient path.",
        )

    def test_score_non_negative(self):
        grid = [
            "S..",
            "...",
            "..E",
        ]
        maze = Maze(grid=grid, start=(0, 0), exit=(2, 2))
        game = MazeGame(maze=maze, position=maze.start)
        for d in ("R", "D", "L", "R", "R", "D"):
            game.move(d)
        self.assertTrue(game.at_exit())
        score = game.compute_score()
        self.assertGreaterEqual(score, 0)

    def test_score_raises_if_game_not_finished(self):
        grid = ["S.E"]
        maze = Maze(grid=grid, start=(0, 0), exit=(0, 2))
        game = MazeGame(maze=maze, position=maze.start)
        game.move("R")
        self.assertFalse(game.at_exit())
        with self.assertRaises(ValueError):
            game.compute_score()


if __name__ == "__main__":
    unittest.main()