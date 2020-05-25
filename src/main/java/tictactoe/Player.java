package tictactoe;



public class Player {
    Sign sign;

    public Player(Sign sign) {
        this.sign = sign;
    }

    public void placeSign(Board board, int position) {
        board.placeSign(sign,position);
    }

    @Override
    public String toString() {
        return "Player=" + sign.name();
    }

}
