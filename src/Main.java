import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> mapPos = new HashMap<>();

        // initializing players
        Player player1 = new Player(mapPos, 100, "john");
        Player player2 = new Player(mapPos, 100, "bob");

        // map string input to arraylist variables
        player1.setMapVars();
        player2.setMapVars();

        // put pieces in default positions
        player1.setDefaultPos();
        System.out.println("def positions: " + player1.getPiecePos().toString());
        player2.setDefaultPos();
        System.out.println("def positions: " + player2.getPiecePos().toString());
        
        // mapping positions to selected piece
        int turn = 0;
        if (player1.getId() == player2.getId()) {
            System.out.println("Found a player, Starting match...");
            while (true) {
                turn++;
                if (turn % 2 == 0) {
                    System.out.printf("It's %s turn \n", player1.getName() + "'s");
                    player1.turn(sc);
                    player1.movePiecePos(mapPos, mapVars);
                    System.out.printf("%s moved to %s", player1.getPiece(), player1.getPiecePos(player1.getMapVars().get(player1.getPiece()).get(player1.getNumber())));
                } else {
                    System.out.printf("It's %s turn \n", player2.getName() + "'s");
                    player1.turn(sc);
                    player2.movePiecePos(mapPos, mapVars);
                    System.out.printf("%s moved to %s", player2.getPiece(), player2.getPiecePos(player1.getMapVars().get(player2.getPiece()).get(player2.getNumber())));
                }
            }
        }
    }
}
