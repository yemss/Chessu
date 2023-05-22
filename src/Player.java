import java.util.*;

public class Player {
    String[][] chessBoard = {{"A", "B", "C", "D", "E", "F", "G", "H"}, {"1", "2", "3", "4", "5", "6", "7", "8"}};
    HashMap<Integer, String> piecePos;
    HashMap<String, ArrayList<Integer>> mapVars;
    ArrayList<Integer> pawn = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    ArrayList<Integer> bishop = new ArrayList<>(Arrays.asList(1, 2));
    ArrayList<Integer> knight = new ArrayList<>(bishop);
    ArrayList<Integer> rook = new ArrayList<>(bishop);
    ArrayList<Integer> queen = new ArrayList<>(List.of(1));
    ArrayList<Integer> king = new ArrayList<>(queen);


    int id, number;

    String name, piece, position = "";

    public Player(HashMap<Integer, String> piecePos, int id, String name) {
        this.piecePos = piecePos;
        this.id = id;
        this.name = name;
    }

    public String getPiecePos(Integer indexOfPiece) {
        return piecePos.get(indexOfPiece);
    }

    public HashMap<Integer, String> getPiecePos() {
        return piecePos;
    }

    public void movePiecePos(HashMap<Integer, String> piecePos, HashMap<String, ArrayList<Integer>> mapVars) {
        System.out.println(" knight: " + piecePos.get(knight.get(0)) + " pawn: " + piecePos.get(pawn.get(0)));
        piecePos.replace((mapVars.get(piece.toLowerCase())).get(number), position.toUpperCase());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // getter functions for turn() (player's input)
    public String getPiece() {
        return piece;
    }

    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public void turn(Scanner sc) {

        System.out.println("Choose a piece:");
        setPiece(sc.next());
        System.out.println("Choose an index for the piece:");
        setNumber(sc.nextInt());

        System.out.println("Move the piece:");
        setPosition(sc.next());

    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /* public ArrayList<Integer> getPawn() {
        return pawn;
    }

    public ArrayList<Integer> getBishop() {
        return bishop;
    }

    public ArrayList<Integer> getKnight() {
        return knight;
    }

    public ArrayList<Integer> getRook() {
        return rook;
    }

    public ArrayList<Integer> getKing() {
        return king;
    }

    public ArrayList<Integer> getQueen() {
        return queen;
    }
   */
    
    public HashMap<String, ArrayList<Integer>> getMapVars() {
        return mapVars;
    }

    public void setDefaultPos() {
        for (int i = 0; i < chessBoard[0].length; i++) {
            piecePos.put(getMapVars("pawn").get(i), chessBoard[0][i] + chessBoard[1][1]);
        }

        piecePos.put(getMapVars("rook").get(0), chessBoard[0][0] + chessBoard[1][0]);
        piecePos.put(getMapVars("rook").get(1), chessBoard[0][7] + chessBoard[1][7]);

        piecePos.put(getMapVars("knight").get(0), chessBoard[0][1] + chessBoard[1][1]);
        piecePos.put(getMapVars("knight").get(1), chessBoard[0][6] + chessBoard[1][6]);

        piecePos.put(getMapVars("bishop").get(0), chessBoard[0][2] + chessBoard[1][2]);
        piecePos.put(getMapVars("bishop").get(1), chessBoard[0][5] + chessBoard[1][5]);

        piecePos.put(getMapVars("queen").get(0), chessBoard[0][3] + chessBoard[1][3]);

        piecePos.put(getMapVars("king").get(0), chessBoard[0][4] + chessBoard[1][4]);
    }

    public void setMapVars() {
            mapVars.put("pawn", pawn);
            mapVars.put("bishop", bishop);
            mapVars.put("knight", knight);
            mapVars.put("rook", rook);
            mapVars.put("queen", queen);
            mapVars.put("king", king);
    }
    public ArrayList<Integer> getMapVars(String str) {
        return mapVars.get(str);
    }
}


