![Minesweeper Icon](https://static.wikia.nocookie.net/logopedia/images/9/98/Minesweeper_1992.png/revision/latest?cb=20220716174154)

# Minesweeper

A Java CLI to play the classic game, Minesweeper.

## To-Do

### High Priority

- Receive user input through the console
- 'Open' a cell depending on the user's entered coordinates
- Prevent user error

### Low Priority

- Add a description on how to play Minesweeper when a game is initiated
- Allow the user to change the dimensions of the grid

## Task Completion History

### February 12, 2024

- Utilised a HashMap instead of ArrayList to store cells of a grid and cells containing bombs

I realised that ArrayLists have their limits. One of the biggest ones is that you cannot identify whether a value exists inside of an ArrayList unless you iterate through it whilst doing a comparison. A HashMap makes it so much easier as each value has an associated key which you can search for, instead of iterating through an ArrayList.

So, using HashMap, I've been able to generate unique random bomb coordinates, and updating their associated Cell's `hasBomb` property to `true`! The code is a little messy, but it still works. Refactoring will be a future goal.

### February 8, 2024

- Generated default bomb coordinates (top row of the grid)

I'm still running into the issue of duplicate bomb coordinates. So, for now, I'll put this concept on the backburner and just generate bomb coordinates in the first row of the grid.

### February 7, 2024

- Created the `Grid` and `Cell` classes
- Developed the `printGrid()` method to output the game's grid to the console
- Begun the `Cell` class with appropriate properties with default values, and created constructor & setter methods
- Modified the constructor of `Grid` to generate a grid of `Cell` objects

The `Grid` class is responsible for outputting the game's grid to the console. The displayed 'icon' of each cell depends on its corresponding value.

- ` ` - a cell that hasn't been selected by the user
- `x` - a cell that has been opened and doesn't have a bomb in it
- `<n>` - a cell that has been opened and has `n` number of bombs in the 8 surrounding cells

The `Grid` class has the properties `grid` and `length`, where `length` has a default value of `10`. For now, `grid` is an ArrayList of type `ArrayList<Integer>`, rather than `ArrayList<Cell>`. This was done to make development of the `Grid` class easier in the beginning. Additionally, I've created a method `printGrid()` to output an instantiated grid to the console, which includes column and row headers.

The `Cell` class represents a cell in a grid, and has properties such as `coordinates`, `hasBomb`, `hasBeenOpened` and `surroundingBombsCount` as this information is required for Minesweeper. With this class developed, I modified the constructor of `Grid` to generate a grid of `Cell` objects.

I ran into an issue regarding the generation of random bomb coordinates, while making sure they're unique. I added a variable `bombsCoordinates` that is of type `ArrayList<int[]>`, which I would call `contains()` on with a newly generated bomb coordinate. The issue lies with how `contains()` works. It checks whether the argument is an object in memory that exists in `bombsCoordinates`, rather than making a check based on value equality.
