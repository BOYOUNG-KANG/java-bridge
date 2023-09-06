package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.PlayerMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void startGame(){
        //initSetup
        PlayerMovement playerMovement = new PlayerMovement();
        String failYn = "N";

        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        System.out.println();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridgeBlock = bridgeMaker.makeBridge(bridgeSize);

        for(int i = 1; i <= bridgeSize; i ++) {
            if(failYn.equals("N")) {
                failYn = playGame(i, bridgeBlock, playerMovement);
            }
        }
        
    }
    private String playGame(int size, List<String> block, PlayerMovement playerMovement){
        System.out.println();
        playerMovement.addPlayerMove(inputView.readMoving());
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(size, playerMovement.getPlayerMove(), block);

        outputView.printMap(bridgeMap.getUpperBridgeMap(), bridgeMap.getLowerBridgeMap());
        return bridgeMap.getFailYn();
    }
}
