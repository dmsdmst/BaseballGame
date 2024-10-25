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
                System.out.println("잘못된 입력값입니다");
                GamePlay();
            }

            switch (inputNum) {
                case 1:
                    int level=3;
                    boolean isRight = true;
                    while(isRight) {
                        try {
                            isRight = false;
                            System.out.println("3에서 5까지 중 실행하고자 하는 난이도를 선택하세요");
                            level = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("알맞은 숫자를 입력해주세요");
                            sc.nextLine();
                            isRight = true;
                        }
                        if(!isRight && (level < 3 || level > 5)){
                            System.out.println("알맞은 난이도를 선택하세요");
                            isRight = true;

                        }
                    }

                    BaseballGame baseballGame = new BaseballGame(level);
                    int resultTimes = baseballGame.play(level);
                    System.out.println(resultTimes + "번째에 성공했습니다");
                    Record.add(resultTimes);
                    break;

                case 2:
                    // 게임 기록
                    for(int i=0; i<Record.size(); i++){
                        System.out.println((i + 1) + "번째 기록 : " + Record.get(i));
                    }
                    break;

                case 3:
                    Record.clear();
                    break;
                default:

            }
        }
    }
}
