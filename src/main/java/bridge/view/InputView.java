package bridge.view;

import bridge.message.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println(InputMessage.BRIDGE_LENGTH_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public String readMoving() {
        System.out.println(InputMessage.PLAYER_MOVEMENT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(InputMessage.RESTART_YN_INPUT_MESSAGE);
        return Console.readLine();
    }
}
