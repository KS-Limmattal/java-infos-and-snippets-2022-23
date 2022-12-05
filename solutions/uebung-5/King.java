import java.util.Arrays;

public class King extends ChessPiece {

    public King(Square square, Color color) {
        super(square, color);
    }

    @Override
    public Square[] reachableSquares() {
        Square[] squares = new Square[8];
        int count = 0;
        int[][] offsets = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
        for (int[] offset : offsets) {
            int file = this.square.getFile() + offset[0];
            int rank = this.square.getRank() + offset[1];
            if (0 <= file && file < 8 && 0 <= rank && rank < 8) {
                squares[count++] = new Square(file, rank);
            }
        }
        return Arrays.copyOf(squares, count);
    }

    @Override
    public Square[] validSquares(Square[] sameColor, Square[] oppositeColor) {
        Square[] squares = new Square[8];
        int count = 0;
        int[][] offsets = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
        for (int[] offset : offsets) {
            int file = this.square.getFile() + offset[0];
            int rank = this.square.getRank() + offset[1];
            if (0 <= file && file < 8 && 0 <= rank && rank < 8) {
                Square newSquare = new Square(file, rank);
                if (!newSquare.occupiedBy(sameColor)) {
                    squares[count++] = newSquare;
                }
            }
        }
        return Arrays.copyOf(squares, count);
    }

    @Override
    public String getName() {
        return "König";
    }
}
