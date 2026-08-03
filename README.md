# Random Placement of Grid
A Java Swing application that randomly places a single special object (`A`) on a user‑defined grid, with optional extra placements. The program supports rerolling the grid, resetting the UI, and ensures that at least one `A` appears even in edge cases.

## Features
- Java Swing GUI with step‑by‑step input:
  - Number of rows  
  - Number of columns  
  - Number of extra placements  
- Random placement of:
  - `A` → special object  
  - `H` → regular grid cell  
- Reroll button to regenerate a new randomized grid  
- Reset button to restart the entire input flow  
- Input validation for all numeric fields  
- Ensures at least one `A` appears even if randomness fails  

## How It Works
The grid is generated using a threshold‑based random selection:

1. Compute a threshold: 
  \[\text{threshold} = \frac{rows \times columns + extras}{2}\]
2. For each grid cell:
   - Generate a random number between `0` and `threshold`
   - If the number equals `threshold` **and** `A` has not yet been placed:
     - Place `A`
     - Mark that `A` has been placed (`temp = false`)
   - Otherwise:
     - Place `H`
3. After filling the grid, extra placements are added using the same logic.
4. If no `A` was placed at all:
   - A fallback placement is generated:
     ```
     A placed at (col, row) to ensure appearance.
     ```

This guarantees that the special object always appears at least once.

## Project Structure
  ```
  /src
  RandomPlacementOfGrid.java     # Main Swing GUI + grid logic
  RandomNumberGenerator.java     # Custom random number generator
  
  /icon.png                        # Window icon (if included)
  ```

## Running the Program
Compile and run using Java:
  ```bash
    javac *.java
    java RandomPlacementOfGrid
  ```
# Example Output
  ```
  H H H H H 
  H A H H H 
  H H H H H 
  H H H H H 
  ```
Or with extras
```
H H H H H 
H H H H H 
H H H H H 
H H H H H
A H H
```
# GUI Flow
1. Enter number of rows → Submit
2. Enter number of columns → Submit
3. Enter number of extras → Submit
4. Grid appears
5. Buttons:
  - Reroll → regenerate grid
  - Reset → restart input sequence
# Technologies
- Java (Swing GUI)
- Custom randomness logic
- Dynamic grid generation
- HTML‑formatted JLabel rendering
