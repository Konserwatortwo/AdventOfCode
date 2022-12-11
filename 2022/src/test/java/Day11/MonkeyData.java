package Day11;

import java.util.ArrayList;
import java.util.List;

public class MonkeyData {

    static List<String> getAllMonkey() {
        List<String> result = new ArrayList<>();
        result.addAll(ZERO_MONKEY);
        result.addAll(FIRST_MONKEY);
        result.addAll(SECOND_MONKEY);
        result.addAll(THIRD_MONKEY);
        return result;
    }

    static final List<String> ZERO_MONKEY = List.of(
            "Monkey 0:",
            "  Starting items: 79, 98",
            "  Operation: new = old * 19",
            "  Test: divisible by 23",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 3",
            ""
    );

    static final List<String> FIRST_MONKEY = List.of(
            "Monkey 1:",
            "  Starting items: 54, 65, 75, 74",
            "  Operation: new = old + 6",
            "  Test: divisible by 19",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 0",
            ""
    );

    static final List<String> SECOND_MONKEY = List.of(
            "Monkey 2:",
            "  Starting items: 79, 60, 97",
            "  Operation: new = old * old",
            "  Test: divisible by 13",
            "    If true: throw to monkey 1",
            "    If false: throw to monkey 3",
            ""
    );

    static final List<String> THIRD_MONKEY = List.of(
            "Monkey 3:",
            "  Starting items: 74",
            "  Operation: new = old + 3",
            "  Test: divisible by 17",
            "    If true: throw to monkey 0",
            "    If false: throw to monkey 1",
            ""
    );

}
