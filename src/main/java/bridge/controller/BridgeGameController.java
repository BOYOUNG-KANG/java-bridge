package bridge.controller;

import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    public void startGame(){
        outputView.startGame();
    }
}
