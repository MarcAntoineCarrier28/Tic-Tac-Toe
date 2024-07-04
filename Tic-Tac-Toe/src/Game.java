import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    int turn;
    char[][] moveList;

    public Game(Player playerOne, Player playerTwo) {
        player1 = playerOne;
        player2 = playerTwo;
        turn = 0;
        moveList = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    public void run(){
        while (turn < 9){
            generateGrid();
            makeMove();
            if (turn >= 5){
                if(checkForWinner()){
                    generateGrid();
                    System.out.println("We have a winner!");
                    break;
                }
            }

        }
    }

    private boolean checkForWinner(){
        for (int i = 0; i < 2; i++){
            //Check rows
            if (moveList[i][0] != ' ' && moveList[i][0] == moveList[i][1] && moveList[i][0] == moveList[i][2]){
                return true;
            }

            //Check columns
            if (moveList[0][i] != ' ' && moveList[0][i] == moveList[1][i] && moveList[0][i] == moveList[2][i]){
                return true;
            }
        }
        if (moveList[0][0] != ' ' && moveList[0][0] == moveList[1][1] && moveList[0][0] == moveList[2][2]){
            return true;
        }
        if (moveList[0][2] != ' ' && moveList[0][2] == moveList[1][1] && moveList[0][2] == moveList[2][0]){
            return true;
        }

        return false;
    }

    private void generateGrid() {
        System.out.println("    1   2   3  ");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + moveList[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  -------------");
        }
    }

    private void makeMove(){
        Scanner in = new Scanner(System.in);
        if ((turn % 2) == 0) {
            System.out.println(player1.name + " Make a move! Enter the number of the row and column you want to mark");
            int row = Integer.parseInt(in.nextLine()) - 1;
            int column = Integer.parseInt(in.nextLine()) - 1;
            if (moveList[row][column] == 'O' || moveList[row][column] == 'X'){
                System.out.println("That spot has already been marked!");
            }
            else {
                moveList[row][column] = 'X';
                turn = turn + 1;
            }
        } else {
            System.out.println(player2.name + " Make a move! Enter the number of the row and column you want to mark");
            int row = Integer.parseInt(in.nextLine()) - 1;
            int column = Integer.parseInt(in.nextLine()) - 1;
            if (moveList[row][column] == 'O' || moveList[row][column] == 'X'){
                System.out.println("That spot has already been marked!");
            }
            else {
                moveList[row][column] = 'O';
                turn = turn + 1;
            }
        }
    }

}
