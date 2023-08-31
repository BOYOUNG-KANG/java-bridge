package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.PlayerMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    PlayerMovement playerMovement = new PlayerMovement();
    public void startGame(){
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        playerMovement.addPlayerMove(inputView.readMoving());
        bridgeMaker.makeBridge(bridgeSize);
    }
}
