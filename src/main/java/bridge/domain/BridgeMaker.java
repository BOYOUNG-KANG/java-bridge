package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.message.InputErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUN_LENGTH = 20;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> blocked = new ArrayList<>();
        validate(size);
        for(int i = 0; i < size; i ++) {
            int randomNum = bridgeNumberGenerator.generate();
            checkRandomNum(blocked, randomNum);
        }
        return blocked;
    }

    private static void checkRandomNum(List<String> blocked, int randomNum) {
        if(randomNum == 1) {
            blocked.add("U");
        }
        if(randomNum == 0) {
            blocked.add("D");
        }
    }

    private void validate(int size) {
        if(size < MINIMUM_LENGTH || size > MAXIMUN_LENGTH) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_LENGTH_INPUT_ERROR);
        }
    }

}
