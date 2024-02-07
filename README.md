# Minesweeper

## Task Completion History

### February 7, 2024

- Created the `Grid` and `Cell` classes
- Developed the `printGrid()` method to output the game's grid to the console

The `Grid` class is reponsible for outputting the game's grid to the console. The displayed 'icon' of each cell depends on its corresponding value.

- ` ` - a cell that hasn't been selected by the user
- `x` - a cell that has been opened and doesn't have a bomb in it
- `<n>` - a cell that has been opened and has `n` number of bombs in the 8 surrounding cells

The `Grid` class has the properties `grid` and `length`, where `length` has a default value of `10`. For now, `grid` is an ArrayList of type `ArrayList<Integer>`, rather than `ArrayList<Cell>`. This was done to make development of the `Grid` class easier in the beginning. Additionally, I've created a method `printGrid()` to output an instantiated grid to the console, which includes column and row headers.
