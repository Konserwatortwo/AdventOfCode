package AoC2021.Day19;

import AoC2021.Day19.dto.Scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskUtils {

    public static List<Scanner> readData(List<String> input) {
        List<Scanner> scanners = new ArrayList<>();
        List<String> scannerLines = new ArrayList<>();
        for (String line : input) {
            if (line.isEmpty()) {
                scanners.add(new Scanner(scannerLines));
                scannerLines.clear();
            } else {
                scannerLines.add(line);
            }
        }
        if (!scannerLines.isEmpty()) {
            scanners.add(new Scanner(scannerLines));
        }
        return scanners;
    }

    public static void determineScannersRelativePosition(List<Scanner> scannersToDetermine) {
        List<Scanner> processedScanners = new ArrayList<>();
        processedScanners.add(scannersToDetermine.get(0));

        List<Scanner> scannersToProcess = new ArrayList<>(scannersToDetermine);
        scannersToProcess.remove(scannersToDetermine.get(0));

        while (!scannersToProcess.isEmpty()) {
            Iterator<Scanner> iterator = scannersToProcess.iterator();
            while (iterator.hasNext()) {
                Scanner scannerToProcess = iterator.next();
                boolean processed = processedScanners.stream()
                        .anyMatch(processedScanner -> PositionFinder.determineRelativePosition(processedScanner, scannerToProcess));
                if (processed) {
                    processedScanners.add(scannerToProcess);
                    iterator.remove();
                }
            }
        }
    }
}
