package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final int THE_SECOND_TO_THE_LAST = 5;
    static final int LAST_LOTTERY_INDEX = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRedundantNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 총 6자리를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkRedundantNumbers(List<Integer> numbers){
        Set<Integer> makeNumbersToSet = new HashSet<>(numbers);
        numbers = new ArrayList<>(makeNumbersToSet);

        if(numbers.size() != 6){
            System.out.println("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void printLotteryNumber(){
        System.out.print("[");
        for(int number : numbers){
            if(numbers.indexOf(number) == THE_SECOND_TO_THE_LAST){
                break;
            }

            System.out.print(number + ", ");
        }
        System.out.print(numbers.get(LAST_LOTTERY_INDEX));
        System.out.print("]");
        System.out.println();
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}

