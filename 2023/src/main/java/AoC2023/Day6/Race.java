package AoC2023.Day6;


import lombok.Value;

@Value(staticConstructor = "of")
public class Race {

    long time;
    long distance;

    public long getPossibleSuccessfulOutcomes() {
        long firstSuccessfulOutcome = 1;
        while (isOutcomeFailing(firstSuccessfulOutcome)) {
            firstSuccessfulOutcome++;
        }
        long lastSuccessfulOutcome = time;
        while (isOutcomeFailing(lastSuccessfulOutcome)) {
            lastSuccessfulOutcome--;
        }
        return lastSuccessfulOutcome - firstSuccessfulOutcome + 1;
    }

    private boolean isOutcomeFailing(long loadingTime) {
        return distance >= loadingTime * (time - loadingTime);
    }
}
