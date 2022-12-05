public abstract class ChessPiece {
    protected Square square;
    public Color color;

    public ChessPiece(Square square, Color color) {
        this.square = square;
        this.color = color;
    }

    public abstract Square[] reachableSquares();

    public abstract Square[] validSquares(Square[] sameColor, Square[] oppositeColor);

    public abstract String getName();

    public String toString() {
        return this.color.name() + " " + this.getName() + " " + square;
    }
}