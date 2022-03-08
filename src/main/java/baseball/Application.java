package baseball;

public class Application {
    public static void main(String[] args) {
        String ENDING_MESSAGE = "프로그램을 종료합니다.";
        Progress applicationProgress = new Progress();

        int exitNum = 0;
        while (exitNum != 2) {
            exitNum = applicationProgress.run();
        }
        System.out.println(ENDING_MESSAGE);
    }



}
