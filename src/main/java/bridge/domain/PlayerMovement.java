package bridge.domain;

import bridge.message.InputErrorMessage;

public class PlayerMovement {
    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private String playerMove;

    public String getPlayerMove() {
        return playerMove;
    }

    public void addPlayerMove(String move) {
        validate(move);
        this.playerMove = move;
    }
    private void validate(String move){
        if(!move.equals(UPPER) && !move.equals(LOWER)) {
            throw new IllegalArgumentException(InputErrorMessage.PLAYER_MOVEMENT_INPUT_ERROR);
        }
    }

}
