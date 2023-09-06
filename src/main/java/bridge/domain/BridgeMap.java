package bridge.domain;

import java.util.List;

public class BridgeMap {
    private final StringBuilder upperBridgeMap = new StringBuilder();
    private final StringBuilder lowerBridgeMap = new StringBuilder();
    private String failYn = "N";
    private static final String BLANK = "   ";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String BARRIER = "|";
    private static final String LEFT_SIDE = "[";
    private static final String RIGHT_SIDE = "]";
    public void createBridge(int size, List<String> playerMovement, List<String> block){
        if(size == 1) {
            createBridgeOfSize1(block.get(0), playerMovement);
        }
        if (size != 1) {
            createBridgeOfSizeN(size, playerMovement, block);
        }

    }

    private void createBridgeOfSizeN(int size, List<String> playerMovement, List<String> block) {
        upperBridgeMap.append(LEFT_SIDE);
        lowerBridgeMap.append(LEFT_SIDE);

        for(int i = 0; i < size; i++) {
            boolean isEqual = playerMovement.get(i).equals(block.get(i));
            if(isEqual) {
                checkPlayerMovement(WRONG, playerMovement.get(i));
                failYn = "Y";
            }
            if (!isEqual) {
                checkPlayerMovement(CORRECT, playerMovement.get(i));
            }
            buildBarrier(i, size);
        }
        upperBridgeMap.append(RIGHT_SIDE);
        lowerBridgeMap.append(RIGHT_SIDE);
    }

    private void buildBarrier(int i, int size) {
        if (i < size - 1) {
            upperBridgeMap.append(BARRIER);
            lowerBridgeMap.append(BARRIER);
        }
    }

    private void checkPlayerMovement(String correctYn, String playerMovement){
        if (playerMovement.equals("U")) {
            upperBridgeMap.append(correctYn);
            lowerBridgeMap.append(BLANK);
        }
        if (playerMovement.equals("D")) {
            upperBridgeMap.append(BLANK);
            lowerBridgeMap.append(correctYn);
        }
    }
    private void createBridgeOfSize1(String block, List<String> playerMovement){
        String playerMove = playerMovement.get(0);

        if (playerMove.equals(block) && playerMove.equals("U")) {
            failYn = "Y";
            upperBridgeMap.append("[ X ]");
            lowerBridgeMap.append("[   ]");
        }
        if (playerMove.equals(block) && playerMove.equals("D")) {
            failYn = "Y";
            upperBridgeMap.append("[   ]");
            lowerBridgeMap.append("[ X ]");
        }
        if (!playerMove.equals(block) && playerMove.equals("U")) {
            upperBridgeMap.append("[ O ]");
            lowerBridgeMap.append("[   ]");
        }
        if(!playerMove.equals(block) && playerMove.equals("D")) {
            upperBridgeMap.append("[   ]");
            lowerBridgeMap.append("[ O ]");
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