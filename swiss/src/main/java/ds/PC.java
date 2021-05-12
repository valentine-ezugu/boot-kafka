package ds;

import java.util.function.Predicate;

public class PC extends Computer {

    Predicate<Integer> isEven = i -> i % 2 == 0;

    inte te;
    @Override
    Computer getComputer() {
        return this;
    }


}
