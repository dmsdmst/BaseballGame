import java.util.*;
import java.util.regex.Pattern;

public class BaseballGame {
    private ArrayList<Character> GoalNumber = new ArrayList<>();
    private ArrayList<Character> GuessNumber = new ArrayList<>();
    private static final String NUMBER_REG = "^[1-9]*$";

    int inputCount = 0;
    int strikeCount, ballCount;
    Scanner sc = new Scanner(System.in);

    // 중복값 생기지 않도록 3가지 랜덤 숫자 생성
    public BaseballGame(int level) {
        while(GoalNumber.size()<level) {
            char randomNum = Character.forDigit(new Random().nextInt(1, 10),10);
            if (!GoalNumber.contains(randomNum)) {
                GoalNumber.add(randomNum);
            }
        }
    }

    public int play(int level) {
        System.out.println("[ 게임을 시작합니다 ]");

        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.println("1부터 9까지의 숫자를 "+ level +"개 입력하세요");
            // 2. 올바른 입력값을 받았는지 검증
            try {
                String input = sc.nextLine();
                validateInput(input, level);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            // 3. 게임 진행횟수 증가
            inputCount++;
            // 4. 스트라이크 개수 계산
            countStrike();
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strikeCount == level) {
                break;
            }
            // 6. 볼 개수 계산
            countBall();

            // 7. 힌트 출력
            if (strikeCount==0 && ballCount==0){
                System.out.println("아웃입니다");
            } else{
                System.out.println("스트라이크 개수 : " + strikeCount);
                System.out.println("볼 개수 : " + ballCount);
            }
        }
        // 게임 진행횟수 반환
        return inputCount;
    }

    protected void validateInput(String input, int level) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, input)) {
            throw new BadInputException("숫자만 입력해주세요");
        } else if(input.length()!= level){
            throw new BadInputException(level + "자리 숫자가 아닙니다");
        }else {
            for (int i = 0; i<level; i++){
                GuessNumber.add(input.charAt(i));
            }

            Set<Character> set = new HashSet<>(GuessNumber);

            if (set.size()!=GuessNumber.size()){
                GuessNumber.clear();
                throw new BadInputException("중복되는 숫자가 있습니다");
            }

        }
    }

    private void countStrike() {
        strikeCount = 0;
            for (int i=0; i < GoalNumber.size(); i++){
                if (GoalNumber.get(i).equals(GuessNumber.get(i))){
                   strikeCount++;
                }
            }
    }

    private void countBall() {
        ballCount = 0;
        for (int i=0; i < GoalNumber.size(); i++){
            if (GoalNumber.contains(GuessNumber.get(i))){
                ballCount++;
            }
        }
        GuessNumber.clear();
        ballCount -= strikeCount;
    }
}
