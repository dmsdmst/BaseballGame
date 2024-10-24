import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameSetting {
    public void GamePlay(){
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;
        ArrayList<Integer> Record = new ArrayList<>();

        while (inputNum != 3) {
            System.out.println("원하시는 번호를 입력해주세요\n" +
                    "1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기");
            try {
                inputNum = sc.nextInt();
            } catch(InputMismatchException e){
                System.out.println("알맞은 숫자를 입력해주세요");
                GamePlay();
            }

            switch (inputNum) {
                case 1:
                    BaseballGame baseballGame = new BaseballGame();
                    int resultTimes = baseballGame.play();
                    System.out.println(resultTimes + "번째에 성공했습니다");
                    Record.add(resultTimes);
                case 2:
                    // 게임 기록
                    for(int i=1; i<=Record.size(); i++){
                        System.out.println(i + "번째 기록 : " + Record.get(i));
                    }
                case 3:
                    Record.clear();
                    break;
                default:

            }
        }
    }
}
