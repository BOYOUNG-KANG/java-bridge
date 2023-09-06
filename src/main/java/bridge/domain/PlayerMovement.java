package bridge.domain;

import bridge.message.InputErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class PlayerMovement {
    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private List<String> playerMove = new ArrayList<>();

    public List<String> getPlayerMove() {
        return playerMove;
    }

    public void addPlayerMove(String move) {
        validate(move);
        if(move.equals(UPPER)) {
            this.playerMove.add("U");
        }
        if(move.equals(LOWER)) {
            this.playerMove.add("D");
        }
    }
    private void validate(String move){
        if(!move.equals(UPPER) && !move.equals(LOWER)) {
            throw new IllegalArgumentException(InputErrorMessage.PLAYER_MOVEMENT_INPUT_ERROR);
        }
    }
}