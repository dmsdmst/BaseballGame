import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;

public class BaseballGame {
    private ArrayList<Character> goalNumber = new ArrayList<>();
    private ArrayList<Character> guessNumber = new ArrayList<>();

    int inputCount = 0;
    int strikeCount, ballCount;

    // 중복값 생기지 않도록 3가지 랜덤 숫자 생성
    public BaseballGame(int level) {
        while(goalNumber.size()<level) {
            char randomNum = Character.forDigit(new Random().nextInt(1, 10),10);
            if (!goalNumber.contains(randomNum)) {
                goalNumber.add(randomNum);
            }
        }
    }

    public int play(int level) {
        System.out.println("[ 게임을 시작합니다 ]");

        while (true) {
            System.out.println("1부터 9까지의 숫자를 "+ level +"개 입력하세요");
            try {
                Scanner sc = new Scanner(System.in);

                String input = sc.nextLine();
                validateInput(input, level);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            inputCount++;
            countStrike();
            if (strikeCount == level) {
                break;
            }
            countBall();

            // 입력 결과 출력
            if (strikeCount==0 && ballCount==0) {
                System.out.println("아웃입니다");
            } else {
                System.out.println("스트라이크 개수 : " + strikeCount);
                System.out.println("볼 개수 : " + ballCount);
            }
        }
        return inputCount;
    }

    protected void validateInput(String input, int level) throws BadInputException {
        // 입력받은 숫자 검증
        final String NUMBER_REG = "^[1-9]*$";

        if (!Pattern.matches(NUMBER_REG, input)) {
            throw new BadInputException("숫자만 입력해주세요");
        } else if (input.length()!= level) {
            throw new BadInputException(level + "자리 숫자가 아닙니다");
        } else {
            for (int i = 0; i<level; i++) {
                guessNumber.add(input.charAt(i));
            }

            Set<Character> set = new HashSet<>(guessNumber);

            if (set.size()!=guessNumber.size()) {
                guessNumber.clear();
                throw new BadInputException("중복되는 숫자가 있습니다");
            }

        }
    }

    private void countStrike() {
        strikeCount = 0;
            for (int i=0; i < goalNumber.size(); i++) {
                if (goalNumber.get(i).equals(guessNumber.get(i))) {
                   strikeCount++;
                }
            }
    }

    private void countBall() {
        ballCount = 0;
        for (int i=0; i < goalNumber.size(); i++) {
            if (goalNumber.contains(guessNumber.get(i))) {
                ballCount++;
            }
        }
        guessNumber.clear();
        ballCount -= strikeCount;
    }
}