# BaseballGame

숫자 야구 게임은 정해진 랜덤 숫자를 유추하는 게임입니다

### 게임의 규칙
1. 1부터 9까지의 숫자입니다
2. 숫자 중 중복된 숫자는 없습니다
3. 숫자와 자리가 모두 맞으면 스트라이크, 숫자는 포함되지만 자리가 맞지 않는 경우는 볼로 카운트 됩니다
4. 스트라이크와 볼이 모두 0이면 아웃입니다



### 사용 예시
"1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기"
선택지를 줍니다

- 1을 선택하면 난이도(자릿수)를 설정하고 게임이 시작됩니다
  1. 난이도는 3-5 입니다
  2. 설정한 난이도에 맞게 숫자를 입력하면 스트라이크, 볼의 갯수를 카운트합니다
  3. 성공시 시도 횟수를, 실패시 스트라이크, 볼의 갯수를 제공합니다
  4. 같은 방법으로 여러번 게임을 실행할 수 있습니다
- 2를 선택하면 자동으로 저장된 게임별 시도 횟수를 확인할 수 있습니다
  1. 저장된 기록이 없는 경우 안내 메세지를 출력합니다
  2. 저장된 기록이 있는 경우 기록을 모두 보여줍니다
- 3을 선택하면 프로그램이 종료된다
  1. 종료시 모든 게임 기록은 삭제됩니다

