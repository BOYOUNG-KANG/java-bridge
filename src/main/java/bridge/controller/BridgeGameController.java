package bridge.controller;

import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void startGame(){
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
    }
}
