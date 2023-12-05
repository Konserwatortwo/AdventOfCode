package AoC2023;

import java.util.List;

public abstract class AdventTaskUtils {

    public static List<String> answerAs(String answer) {
        return List.of(answer);
    }

    public static List<String> answerAs(int answer) {
        return List.of(answer + "");
    }

    public static List<String> answerAs(long answer) {
        return List.of(answer + "");
    }

    public static List<String> answerAs(double answer) {
        return List.of(answer + "");
    }
}
