import java.util.Scanner;

public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 2D arrays for the solution and puzzle (8 rows, 20 columns)
        char[][] solution = new char[8][20]; // Solution array
        char[][] puzzle = new char[8][20];   // Puzzle array

        // This initialize arrays with blank spaces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {
                solution[i][j] = '_';
                puzzle[i][j] = '_';
            }
        }

        int choice;
        do {
            // This Displays a menu for the options
            System.out.println("Choose an option:");
            System.out.println("1) Create a crossword puzzle");
            System.out.println("2) View crossword puzzle with solutions");
            System.out.println("3) View crossword puzzle without solutions");
            System.out.println("4) Quit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumes newline character
            
            switch (choice) {
                case 1:
                    // This creates the crossword puzzle by asking the user for input
                    createPuzzle(solution, puzzle, scanner);
                    break;
                case 2:
                    // This display the puzzle with solutions
                    displayPuzzle(solution);
                    break;
                case 3:
                    // This display the puzzle without solutions
                    displayPuzzle(puzzle);
                    break;
                case 4:
                    // This quits the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // This handle invalid input
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        } while (choice != 4); // Continues until the user chooses to quit
        scanner.close();
    }

    // This method is to create the crossword puzzle
    public static void createPuzzle(char[][] solution, char[][] puzzle, Scanner scanner) {
        System.out.println("Enter up to 8 words (max 8 characters each):");

        // Loop to accept up to 8 words
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter word " + (i + 1) + " (or press Enter to skip): ");
            String word = scanner.nextLine().toUpperCase();

            if (word.length() > 8) {
                System.out.println("Word too long! Max 8 characters allowed.");
                i--; // Retry the same word input if it's too long
                continue;
            }
            
            // If a word was entered, places it in the solution and hides it in the puzzle
            if (!word.isEmpty()) {
                for (int j = 0; j < word.length(); j++) {
                    solution[i][j] = word.charAt(j); // Adds to solution array
                    puzzle[i][j] = '_';              // To hide in puzzle array
                }
            } else {
                break; // This stops accepting words if the user presses Enter
            }
        }
    }

    // This method is to display the crossword puzzle (with or without solutions)
    public static void displayPuzzle(char[][] puzzle) {
        // Displays each row of the 2D array
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println(); // Makes a Newline after each row
        }
    }
}

