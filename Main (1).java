import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("What big of a board (enter even number only)");
        int size = input.nextInt();
        while(!isEven(size)) {
            System.out.println("Please enter an even number only");
            size = input.nextInt();
        }

        WordGame game = new WordGame(size);
        int row1, row2;
        int col1, col2;
        game.printBoard(size);
        while (!game.allRevealed(size)){
            System.out.println("Enter first row");
            row1 = input.nextInt();
            System.out.println("Enter first column");
            col1 = input.nextInt();
            game.showPosition(row1, col1);
            game.printBoard(size);

            System.out.println("Enter second row");
            row2 = input.nextInt();
            System.out.println("Enter second column");
            col2 = input.nextInt();
            game.showPosition(row2, col2);
            game.printBoard(size);

            if(!game.match(row1, col1, row2, col2)){
                game.hidePosition(row1, col1);
                game.hidePosition(row2, col2);
                game.printBoard(size);
            }
        }

        game.printRevealedBoard(size);
        game.printBoard(size);
    }

    static boolean isEven(int number){
        if(number % 2 == 1){
            return false;
        }
        else
            return true;
        }
    }


