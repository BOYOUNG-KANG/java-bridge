package bridge.controller;

import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    
    PlayerMovement playerMovement = new PlayerMovement();
    public void startGame(){
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        playerMovement.addPlayerMove(inputView.readMoving());

    }
}
