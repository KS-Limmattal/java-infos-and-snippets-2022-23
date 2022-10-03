public class TicTacToe {

    public static void main(String[] args) {
        char[][] playfield = { { 'X', 'X', 'O' }, { 'O', 'O', 'X' }, { 'X', 'O', 'O' } };
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(playfield[x][y]);
            }
            System.out.println("");
        }
    }
}