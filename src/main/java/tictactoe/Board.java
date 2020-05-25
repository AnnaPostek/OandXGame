package tictactoe;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Board {
    Sign[] signs = new Sign[9];
    Sign currentSign;

    static List<String> WIN_POSITIONS = Arrays.asList(
            "W--W--W--",
            "-W--W--W-",
            "--W--W--W",
            "WWW------",
            "---WWW---",
            "------WWW",
            "W---W---W",
            "--W-W-W--"
    );

    public Board(Sign currentSign) {
        this.currentSign = currentSign;
    }

    public Sign[] getSigns() {
        return signs;
    }

    public void setSigns(Sign[] signs) {
        this.signs = signs;
    }

    public Sign getCurrentSign() {
        return currentSign;
    }

    public void setCurrentSign(Sign currentSign) {
        this.currentSign = currentSign;
    }

    public void placeSign(Sign sign, int position) {
        Preconditions.checkNotNull(sign);
        Preconditions.checkArgument(sign.equals(currentSign), "Not your turn, on game is %s", currentSign.name());
        Preconditions.checkArgument(position>=0 && position<=8, "Please choose position 0-8, not %d", position);
        Preconditions.checkArgument(signs[position]==null);
        signs[position] = sign;
        currentSign=currentSign.revers();
    }
    
    public void printBoard(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < signs.length; i++) {
            if(signs[i] == null) {
                stringBuilder.append(i);
            }
            else {
                stringBuilder.append(signs[i].name());
            }
            if(i==2 || i==5 || i==8) {
                stringBuilder.append("\n");
            } else {
                stringBuilder.append("|");
            }
        }
        System.out.println(stringBuilder.toString());
    }

public boolean isBoardFull(){
        return Arrays.stream(signs).noneMatch(Objects::isNull);
}

    public boolean checkWinner(Sign sign) {
        String boardView = getBoardView();
        for (String winPosition : WIN_POSITIONS) {
            int winningPotionsTaken = 0;
            int it = 0;
            for (char c : winPosition.toCharArray()) {
                if(c=='W') {
                    if(boardView.charAt(it) == sign.name().charAt(0)){
                        winningPotionsTaken++;
                    }
                }
                it++;
            }  if(winningPotionsTaken==3) {
                return true;
            }
        } return false;
    }

    private String getBoardView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sign sign : signs) {
            if(sign==null) {
                stringBuilder.append("-");
            } else {
                stringBuilder.append(sign.name());
            }
        }
            return stringBuilder.toString();
        }
    }
