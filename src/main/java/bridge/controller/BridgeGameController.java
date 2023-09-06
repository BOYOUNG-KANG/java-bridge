package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.PlayerMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame(){
        //initSetup
        BridgeMap bridgeMap = new BridgeMap();

        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridgeBlock = bridgeMaker.makeBridge(bridgeSize);

    }



}
