package bridge.domain;

import bridge.BridgeProvider;

import java.util.List;

public class BridgeMap {
    private final StringBuilder upperBridgeMap = new StringBuilder();
    private final StringBuilder lowerBridgeMap = new StringBuilder();
    private String failYn = "N";

    public void createBridge(int size, List<String> playerMovement, List<String> block){
        if(size == 1) {
            createBridgeOfSize1(block.get(0), playerMovement);
        }
        if (size != 1) {
            createBridgeOfSizeN(size, playerMovement, block);
        }
    }

    private void createBridgeOfSizeN(int size, List<String> playerMovement, List<String> block) {
        upperBridgeMap.append(BridgeProvider.LEFT_SIDE);
        lowerBridgeMap.append(BridgeProvider.LEFT_SIDE);

        for(int i = 0; i < size; i++) {
            boolean isEqual = playerMovement.get(i).equals(block.get(i));
            if(isEqual) {
                checkPlayerMovement(BridgeProvider.WRONG, playerMovement.get(i));
                failYn = "Y";
            }
            if (!isEqual) {
                checkPlayerMovement(BridgeProvider.CORRECT, playerMovement.get(i));
            }
            buildBarrier(i, size);
        }
        upperBridgeMap.append(BridgeProvider.RIGHT_SIDE);
        lowerBridgeMap.append(BridgeProvider.RIGHT_SIDE);
    }

    private void buildBarrier(int i, int size) {
        if (i < size - 1) {
            upperBridgeMap.append(BridgeProvider.BARRIER);
            lowerBridgeMap.append(BridgeProvider.BARRIER);
        }
    }

    private void checkPlayerMovement(String correctYn, String playerMovement){
        if (playerMovement.equals("U")) {
            upperBridgeMap.append(correctYn);
            lowerBridgeMap.append(BridgeProvider.BLANK);
        }
        if (playerMovement.equals("D")) {
            upperBridgeMap.append(BridgeProvider.BLANK);
            lowerBridgeMap.append(correctYn);
        }
    }
    private void createBridgeOfSize1(String block, List<String> playerMovement){
        String playerMove = playerMovement.get(0);

        if (playerMove.equals(block) && playerMove.equals("U")) {
            failYn = "Y";
            upperBridgeMap.append(BridgeProvider.SIZE1_WRONG);
            lowerBridgeMap.append(BridgeProvider.SIZE1_BLANK);
        }
        if (playerMove.equals(block) && playerMove.equals("D")) {
            failYn = "Y";
            upperBridgeMap.append(BridgeProvider.SIZE1_BLANK);
            lowerBridgeMap.append(BridgeProvider.SIZE1_WRONG);
        }
        if (!playerMove.equals(block) && playerMove.equals("U")) {
            upperBridgeMap.append(BridgeProvider.SIZE1_CORRECT);
            lowerBridgeMap.append(BridgeProvider.SIZE1_BLANK);
        }
        if(!playerMove.equals(block) && playerMove.equals("D")) {
            upperBridgeMap.append(BridgeProvider.SIZE1_BLANK);
            lowerBridgeMap.append(BridgeProvider.SIZE1_CORRECT);
        }
    }


    public String getUpperBridgeMap() {
        return upperBridgeMap.toString();

    }
    public String getLowerBridgeMap() {
        return lowerBridgeMap.toString();
    }

    public String getFailYn() {
        return failYn;
    }
}