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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);

        return null;
    }

    private void validate(int size) {
        if(size > MINIMUM_LENGTH || size < MAXIMUN_LENGTH) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_LENGTH_INPUT_ERROR);
        }
    }

}
