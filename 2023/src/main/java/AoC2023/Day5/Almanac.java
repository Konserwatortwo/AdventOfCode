package AoC2023.Day5;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Almanac {

    List<Long> seeds;
    List<AlmanacMapper> mappers;

    public Almanac(List<String> inputValue) {
        seeds = Arrays.stream(inputValue.get(0)
                        .replace("seeds: ", "")
                        .split(" ")
                )
                .map(Long::parseLong)
                .collect(Collectors.toList());

        mappers = new ArrayList<>();
        List<String> linesForMapper = new ArrayList<>();
        for (int i = 2; i < inputValue.size(); i++) {
            String line = inputValue.get(i);
            if (StringUtils.isEmpty(line)) {
                mappers.add(new AlmanacMapper(linesForMapper));
                linesForMapper.clear();
            } else {
                linesForMapper.add(line);
            }
        }
        mappers.add(new AlmanacMapper(linesForMapper));
    }
    
    public long lowestLocationForSingleSeeds() {
        return seeds.stream()
                .mapToLong(this::map)
                .min()
                .orElseThrow(IllegalAccessError::new);
    }

    public long lowestLocationForRangeSeeds() {
        long minimumLocation = Long.MAX_VALUE;
        for (int i = 0; i < seeds.size(); i += 2) {
            Range currentRange = Range.of(seeds.get(i), seeds.get(i) + seeds.get(i + 1));
            List<Range> currentMappedRanges = map(currentRange);
            Collections.sort(currentMappedRanges);
            minimumLocation = Math.min(minimumLocation, currentMappedRanges.get(0).getFrom());
        }
        return minimumLocation;
    }

    private long map(long x) {
        long mappedValue = x;
        for (AlmanacMapper mapper : mappers) {
            mappedValue = mapper.map(mappedValue);
        }
        return mappedValue;
    }

    private List<Range> map(Range range) {
        List<Range> mappedRanges = new ArrayList<>();
        mappedRanges.add(range);
        for (AlmanacMapper mapper : mappers) {
            mappedRanges = mappedRanges.stream()
                    .map(mapper::map)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        return mappedRanges;
    }
}
