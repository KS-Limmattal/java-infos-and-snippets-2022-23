import java.util.Arrays;

public class Rook extends ChessPiece {
    public Rook(Square square, Color color) {
        super(square, color);
    }

    @Override
    public Square[] reachableSquares() {
        Square[] squares = new Square[14];
        int count = 0;
        for (int rank = 0; rank < 8; rank++) {
            if (rank != this.square.getRank()) {
                squares[count++] = new Square(this.square.getFile(), rank);
            }
        }
        for (int file = 0; file < 8; file++) {
            if (file != this.square.getFile()) {
                squares[count++] = new Square(file, this.square.getRank());

            }
        }
        return squares;
    }

    @Override
    public Square[] validSquares(Square[] sameColor, Square[] oppositeColor) {
        Square[] squares = new Square[14];
        int count = 0;
        for (int fileOffset = 1; fileOffset < 8 - square.getFile(); fileOffset++) {
            int file = square.getFile() + fileOffset;
            Square newSquare = new Square(file, square.getRank());
            if (!newSquare.occupiedBy(sameColor)) {
                squares[count++] = newSquare;
            } else {
                break;
            }
            if (newSquare.occupiedBy(oppositeColor)) {
                break;
            }
        }

        for (int fileOffset = 1; fileOffset <= square.getFile(); fileOffset++) {
            int file = square.getFile() - fileOffset;
            Square newSquare = new Square(file, square.getRank());
            if (!newSquare.occupiedBy(sameColor)) {
                squares[count++] = newSquare;
            } else {
                break;
            }
            if (newSquare.occupiedBy(oppositeColor)) {
                break;
            }
        }

        for (int rankOffset = 1; rankOffset < 8 - square.getRank(); rankOffset++) {
            int rank = square.getRank() + rankOffset;
            Square newSquare = new Square(square.getFile(), rank);
            if (!newSquare.occupiedBy(sameColor)) {
                squares[count++] = newSquare;
            } else {
                break;
            }
            if (newSquare.occupiedBy(oppositeColor)) {
                break;
            }
        }

        for (int rankOffset = 1; rankOffset <= square.getRank(); rankOffset++) {
            int rank = square.getRank() - rankOffset;
            Square newSquare = new Square(square.getFile(), rank);
            if (!newSquare.occupiedBy(sameColor)) {
                squares[count++] = newSquare;
            } else {
                break;
            }
            if (newSquare.occupiedBy(oppositeColor)) {
                break;
            }
        }

        return Arrays.copyOf(squares, count);
    }

    @Override
    public String getName() {
        return "Turm";
    }
}
