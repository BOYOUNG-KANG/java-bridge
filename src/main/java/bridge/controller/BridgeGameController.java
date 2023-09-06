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
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    public void playGame(){
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridgeBlock = bridgeMaker.makeBridge(bridgeSize);

        startGame(bridgeSize, bridgeBlock);
    }

    public void startGame(int bridgeSize, List<String> bridgeBlock){
        //initSetup
        PlayerMovement playerMovement = new PlayerMovement();
        String failYn = "N";

        for(int i = 1; i <= bridgeSize; i ++) {
            if(failYn.equals("N")) {
                failYn = progressGame(i, bridgeBlock, playerMovement);
            }
        }
        restartGame(bridgeSize, bridgeBlock);
    }
    private String progressGame(int size, List<String> block, PlayerMovement playerMovement){
        System.out.println();
        playerMovement.addPlayerMove(inputView.readMoving());
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(size, playerMovement.getPlayerMove(), block);

        outputView.printMap(bridgeMap.getUpperBridgeMap(), bridgeMap.getLowerBridgeMap());
        return bridgeMap.getFailYn();
    }
    private void restartGame(int bridgeSize, List<String> bridgeBlock){
        String restartYn = inputView.readGameCommand();
        if (restartYn.equals(RESTART)) {
            startGame(bridgeSize, bridgeBlock);
        }

    }
}
