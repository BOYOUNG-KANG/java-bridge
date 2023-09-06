package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.InputProvider;
import bridge.OutputProvider;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.PlayerMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void playGame(){
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridgeBlock = bridgeMaker.makeBridge(bridgeSize);

        startGame(bridgeSize, bridgeBlock);
    }

    public void startGame(int bridgeSize, List<String> bridgeBlock){
        PlayerMovement playerMovement = new PlayerMovement();
        BridgeGame bridgeGame = new BridgeGame();
        String failYn = "N";

        for(int i = 1; i <= bridgeSize; i ++) {
            if(failYn.equals("N")) {
                failYn = progressGame(i, bridgeBlock, playerMovement, bridgeGame);
            }
        }
        bridgeGame.updateTryCount();
        bridgeGame.updateSuccessYn(failYn);
        if (bridgeGame.getSuccessYn().equals(OutputProvider.FAIL)) {
            restartGame(bridgeSize, bridgeBlock,bridgeGame);
        }
        if (bridgeGame.getSuccessYn().equals(OutputProvider.SUCCESS)) {
            finishGame(bridgeGame);
        }
    }
    private String progressGame(int size, List<String> block, PlayerMovement playerMovement, BridgeGame bridgeGame){
        playerMovement.addPlayerMove(inputView.readMoving());
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(size, playerMovement.getPlayerMove(), block);
        bridgeGame.updateFinalUpperBridge(bridgeMap.getUpperBridgeMap());
        bridgeGame.updateFinalLowerBridge(bridgeMap.getLowerBridgeMap());

        outputView.printMap(bridgeMap.getUpperBridgeMap(), bridgeMap.getLowerBridgeMap());
        return bridgeMap.getFailYn();
    }
    private void restartGame(int bridgeSize, List<String> bridgeBlock, BridgeGame bridgeGame){
        String restartYn = inputView.readGameCommand();
        bridgeGame.retry(restartYn);

        if (restartYn.equals(InputProvider.RESTART)) {
            startGame(bridgeSize, bridgeBlock);
        }
        if (restartYn.equals(InputProvider.QUIT)) {
            finishGame(bridgeGame);
        }
    }
    private void finishGame(BridgeGame bridgeGame){
        outputView.printResult(bridgeGame.getFinalUpperBridge(), bridgeGame.getFinalLowerBridge(), bridgeGame.getSuccessYn(), bridgeGame.getTryCount());
    }
}