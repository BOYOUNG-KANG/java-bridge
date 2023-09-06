package bridge.domain;

import bridge.message.InputErrorMessage;
import bridge.message.OutputMessage;

public class BridgeGame {
    private String finalUpperBridge;
    private String finalLowerBridge;
    private String successYn = OutputMessage.FAIL;
    private int tryCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String restartYn) {
        validate(restartYn);
    }
    private void validate(String restartYn){
        if(!restartYn.equals("R") && !restartYn.equals("Q")) {
            throw new IllegalArgumentException(InputErrorMessage.RESTART_YN_INPUT_ERROR);
        }
    }

    public void updateSuccessYn(String fail){
        if (fail.equals("Y")) {
            this.successYn = OutputMessage.FAIL;
        }
        if (fail.equals("N")) {
            this.successYn = OutputMessage.SUCCESS;
        }
    }

    public void updateTryCount(){
        tryCount ++;
    }

    public void updateFinalUpperBridge(String finalUpperBridge) {
        this.finalUpperBridge = finalUpperBridge;
    }

    public void updateFinalLowerBridge(String finalLowerBridge) {
        this.finalLowerBridge = finalLowerBridge;
    }

    public String getFinalUpperBridge() {
        return finalUpperBridge;
    }

    public String getFinalLowerBridge() {
        return finalLowerBridge;
    }

    public String getSuccessYn() {
        return successYn;
    }

    public int getTryCount() {
        return tryCount;
    }
}
