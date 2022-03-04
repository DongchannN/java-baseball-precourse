package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Progress applicationProgress = new Progress();

        int exitNum = 0;
        while (exitNum != 2) {
            exitNum = applicationProgress.run();
        }
        System.out.println("프로그램을 종료합니다.");
    }



}
