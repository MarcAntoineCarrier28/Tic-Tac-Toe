import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to Tic-Tac-Toe!");

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter Player 1's name:");
        String name1 = in.nextLine();
        System.out.println("Please enter Player 2's name:");
        String name2 = in.nextLine();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        System.out.println("Hello " + player1.name + " And " + player2.name);


        newGame(player1, player2);

    }

    private static void newGame(Player player1, Player player2){
        Scanner in = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            System.out.println("Would you like to start a new game? Y/N");
            String response = in.nextLine();
            if(response.equals("Y")) {
                System.out.println("Let's play!");
                Game game = new Game(player1, player2);
                game.run();
            }
            else if (response.equals("N")) {
                System.out.println("Thanks for playing!");
                check = true;
            }
        }
    }

}