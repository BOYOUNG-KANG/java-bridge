package bridge.view;

import bridge.message.OutputMessage;

public class OutputView {

    public void startGame(){
        System.out.println(OutputMessage.GAME_START_MESSAGE);
        System.out.println();
    }

    public void printMap(String upperBridge, String lowerBridge) {
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
        System.out.println();
    }

    public void printResult(String upperBridge, String lowerBridge, String successYn, int tryCount) {
        System.out.println(OutputMessage.GAME_END);
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
        System.out.println();

        System.out.println(OutputMessage.GAME_SUCCESS_YN + successYn);
        System.out.println(OutputMessage.TRY_COUNT + tryCount);
    }
}
