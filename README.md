# Random Password Generator
A simple Java desktop application that generates secure, randomized passwords using a custom randomizer and a Swing-based user interface. Users choose the desired password length, generate a password, and optionally copy it directly to their clipboard.

## Features
- Java Swing GUI for easy interaction  
- Custom randomness logic using `Math.random()`  
- Four character categories:
  - Numbers (0–9)
  - Lowercase letters (a–z)
  - Uppercase letters (A–Z)
  - Symbols (punctuation and special characters)
- Clipboard copy button for quick use  
- Input validation to prevent non-numeric entries  

## How It Works
The password is generated one character at a time. For each position:

1. A random category (1–4) is selected using `Randomizer.generate(1, 4)`.
2. Based on the category:
   - **1:** Append a random number  
   - **2:** Append a random lowercase letter  
   - **3:** Append a random uppercase letter  
   - **4:** Append a random symbol  
3. The final password is returned as a `String`.

The randomizer:
  ```
  public static int generate(int min, int max) {
      return min + (int)(Math.random() * ((max - min) + 1));
  }
  ```
This ensures uniform distribution across the selected range.

# Project structure
  ```
  /src
    PasswordGenerator.java        # Core password generation logic
    Randomizer.java               # Custom random number generator
    RandomPasswordGenerater.java  # Swing GUI application
    manifest.txt
  
  /bin
    RandomPasswordGenerator.jar   # Packaged runnable JAR
  
  /.vscode
    launch.json                   # VS Code run configuration
  ```
# Running the program
## Run from source
  ```
  javac *.java
  java RandomPasswordGenerater
  ```
## Run from the packaged JAR
  `java -jar RandomPasswordGenerator.jar`
# Example output
  ```
  Your new randomly generated password is:
  A9f$kQ2!rB
  ```
# GUI Overview
- Enter desired password length
- Click Submit to generate
- Click Copy Password to copy to clipboard
- Error messages appear for invalid input
# Technologies
- Java (Swing GUI)
- Custom randomness logic
- Clipboard API `Toolkit.getDefaultToolkit().getSystemClipboard()`
