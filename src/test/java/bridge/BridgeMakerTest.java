package bridge;

import bridge.domain.BridgeMaker;
import bridge.message.InputErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    @DisplayName("다리 길이가 3이상 20이하가 아닐때 예외 발생")
    @Test
    void 다리길이_예외(){
        BridgeNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(InputErrorMessage.BRIDGE_LENGTH_INPUT_ERROR);
    }

    @DisplayName("다리 길이에 따라 랜덤 값 생성하기")
    @Test
    void 랜덤값_생성(){
        BridgeNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3);
        Assertions.assertThat(blockedBridge).containsExactly("U", "D", "D");
    }
    @Test
    void 랜덤값_생성2(){
        BridgeNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(4);
        Assertions.assertThat(blockedBridge).containsExactly("D", "U", "D", "U");
    }
}
