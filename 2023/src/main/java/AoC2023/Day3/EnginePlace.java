package AoC2023.Day3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(staticName = "of")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
class EnginePlace {

    int x;
    int y;

    public List<EnginePlace> nearbyPlaces() {
        List<EnginePlace> result = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                result.add(new EnginePlace(x + i, y + j));
            }
        }
        result.remove(this);
        return result;
    }
}
