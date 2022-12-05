public class Chess {
    public static void main(String[] args) {
        King wKing = new King(new Square("D2"), Color.WHITE);
        King bKing = new King(new Square("H4"), Color.BLACK);
        Rook wRook = new Rook(new Square("C3"), Color.WHITE);
        ChessPiece[] pieces = { wKing, bKing, wRook };
        for (ChessPiece piece : pieces) {
            Square[] sameColor;
            Square[] oppositeColor;
            sameColor = new Square[] { wKing.square, wRook.square };
            if (piece.color == Color.WHITE) {
                sameColor = new Square[] { wKing.square, wRook.square };
                oppositeColor = new Square[] { bKing.square };
            } else {
                oppositeColor = new Square[] { wKing.square, wRook.square };
                sameColor = new Square[] { bKing.square };
            }
            System.out.println("Die Figur " + piece + " hat die folgenden erreichbaren Felder auf leerem Brett: ");
            for (Square square : piece.reachableSquares()) {
                System.out.print(square + ", ");
            }
            System.out.println();

            System.out.println("Die Figur " + piece + " hat die folgenden gültigen Felder auf besetztem Brett: ");
            for (Square square : piece.validSquares(sameColor, oppositeColor)) {
                System.out.print(square + ", ");
            }
            System.out.println();
        }
    }
}
