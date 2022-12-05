public class Square {
    private int file;
    private int rank;

    public Square(int file, int rank) {
        setFile(file);
        setRank(rank);
    }

    public Square(String name) {
        setFile(name.charAt(0) - (int) 'A');
        setRank(name.charAt(1) - (int) '1');
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public void setFile(int file) {
        if (file < 0 || file > 7) {
            this.rank = 0;
            System.out.println("Ungültige Reihe, setze sie zu 0");
        }
        this.file = file;
    }

    public void setRank(int rank) {
        if (rank < 0 || rank > 7) {
            this.rank = 0;
            System.out.println("Ungültige Reihe, setze sie zu 0");
        }
        this.rank = rank;
    }

    public boolean occupiedBy(Square[] squares) {
        for (Square occupied : squares) {
            if (occupied.getFile() == file && occupied.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "" + (char) (file + (int) 'A') + (rank + 1);
    }
}