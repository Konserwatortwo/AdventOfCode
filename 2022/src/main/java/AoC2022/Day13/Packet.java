package AoC2022.Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Packet extends Element {

    Queue<Element> content = new LinkedList<>();

    public Packet(Number value) {
        content.add(value);
    }

    public Packet(String line) {
        if (!line.equals("[]")) {
            for (String element : cutToElements(line)) {
                content.add(element.startsWith("[") ? new Packet(element) : new Number(element));
            }
        }
    }

    private List<String> cutToElements(String line) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int level = 0;
        char[] charArray = line.toCharArray();
        for (int i = 1; i < charArray.length - 1; i++) {
            char sign = charArray[i];
            if (sign == '[') {
                level++;
            } else if (sign == ']') {
                level--;
            } else if (sign == ',' && level == 0) {
                result.add(line.substring(startIndex + 1, i));
                startIndex = i;
            }
        }
        result.add(line.substring(startIndex + 1, charArray.length - 1));
        return result;
    }

    @Override
    public int compareTo(Element other) {
        if (other instanceof Number) {
            other = new Packet((Number) other);
        }
        return comparePackets((Packet) other);
    }

    private int comparePackets(Packet other) {
        Queue<Element> leftQueue = new LinkedList<>(content);
        Queue<Element> rightQueue = new LinkedList<>(other.content);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            int result = leftQueue.remove().compareTo(rightQueue.remove());
            if (result != 0) {
                return result;
            }
        }
        if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
            return 0;
        }
        return leftQueue.isEmpty() ? -1 : 1;
    }
}
