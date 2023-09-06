package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.PlayerMovement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMapTest {
    @DisplayName("size 1일때 성공할 경우 - 플레이어가 U로 이동")
    @Test
    void 한개일때_성공(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");

        BridgeNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3); //D D D

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(1, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ O ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("N");
    }

    @DisplayName("size 1일때 실패할 경우 - 플레이어가 U로 이동")
    @Test
    void 한개일때_실패(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");

        ApplicationTest.TestNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3);

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(1, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ X ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("Y");
    }

    @DisplayName("size 2일때 성공할 경우 - 플레이어가 U, D로 이동")
    @Test
    void 두개일때_성공(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");
        playerMovement.addPlayerMove("D");

        ApplicationTest.TestNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3); //D U D

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(2, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ O |   ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   | O ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("N");
    }
    @DisplayName("size 2일때 실패할 경우 - 플레이어가 U, U로 이동")
    @Test
    void 두개일때_실패(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");
        playerMovement.addPlayerMove("U");

        ApplicationTest.TestNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3); //D U D

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(2, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ O | X ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   |   ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("Y");
    }

    @DisplayName("size 3일때 성공할 경우 - 플레이어가 U, D, D로 이동")
    @Test
    void 세개일때_성공(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");
        playerMovement.addPlayerMove("D");
        playerMovement.addPlayerMove("D");

        ApplicationTest.TestNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3); //D U U

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(3, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ O |   |   ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   | O | O ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("N");
    }
    @DisplayName("size 3일때 실패할 경우 - 플레이어가 U, D, D로 이동")
    @Test
    void 세개일때_실패(){
        PlayerMovement playerMovement = new PlayerMovement();
        playerMovement.addPlayerMove("U");
        playerMovement.addPlayerMove("D");
        playerMovement.addPlayerMove("D");

        ApplicationTest.TestNumberGenerator generator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> blockedBridge = bridgeMaker.makeBridge(3); //D U D

        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.createBridge(3, playerMovement.getPlayerMove(), blockedBridge);

        Assertions.assertThat(bridgeMap.getUpperBridgeMap()).isEqualTo("[ O |   |   ]");
        Assertions.assertThat(bridgeMap.getLowerBridgeMap()).isEqualTo("[   | O | X ]");
        Assertions.assertThat(bridgeMap.getFailYn()).isEqualTo("Y");
    }
}
