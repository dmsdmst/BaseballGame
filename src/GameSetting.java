import java.util.Scanner;

public class BaseballGameDisplay {
    public void GamePlay() {
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;

        while (inputNum != 3) {
            System.out.println("원하시는 번호를 입력해주세요\n" +
                    "1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기");

            try {
                inputNum = sc.nextInt();
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요");
            }

            switch (inputNum) {
                case 1:
                    BaseballGame baseballGame = new BaseballGame();
                    int result = baseballGame.play();
                    System.out.println(result + "번째에 성공했습니다");
                case 2:
                    // 게임 기록
                case 3:
                    break;
                default:

            }
        }
    }
}
