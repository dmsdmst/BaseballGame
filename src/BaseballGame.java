import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballGame {
    private ArrayList<Integer> GoalNumber = new ArrayList<>();
    private static final String NUMBER_REG = "^[1-9]*$";
    int inputCount, strikeCount, ballCount;
    Scanner sc = new Scanner(System.in);

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        for(int i = 0; i<3; i++) {
            int randomNum = new Random().nextInt(1, 10);
            if (!GoalNumber.contains(randomNum)) {
                GoalNumber.add(randomNum);
            } else {
                --i;
            }
        }
    }

    public int play() {
        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.println("1부터 9까지의 숫자를 3개 입력하세요");
            String input = sc.nextLine();
            // 2. 올바른 입력값을 받았는지 검증
            try {
                validateInput(input);
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            }
            // 3. 게임 진행횟수 증가
            // 4. 스트라이크 개수 계산
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            // 6. 볼 개수 계산
            // 7. 힌트 출력
        }
        // 게임 진행횟수 반환
    }

    protected boolean validateInput(String input) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, input)) {
            throw new BadInputException("숫자만 입력해주세요");
        } else if(input.length()!=3){
            throw new BadInputException("3자리 숫자가 아닙니다");
        }
        return true;
    }

    private int countStrike(String input) {
        return strikeCount;
    }

    private int countBall(String input) {
        return ballCount;
    }
}
