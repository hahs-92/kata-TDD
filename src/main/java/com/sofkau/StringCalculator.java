package com.sofkau;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String values) throws NumberFormatException {
        if(values.isEmpty()) {
            return 0;
        }

        if(isLengthEqualThanOne(values)) {
            return Integer.parseInt(values);
        }

        if(values.contains("-")) {
            throw new NumberFormatException("NegativeNumberException");
        }

        if(containsFirstNumeralCharacter(values)) {
            values = values.replaceFirst("#", "");
        }

        var splitValues = splitValues(values);
        return calc(parseIntValues(splitValues));
    }

    private int calc(List<Integer> list) {
        return list.stream()
                .reduce(0, this::limitValueTo1000);
    }

    private int limitValueTo1000(int acum, int value) {
        if(value > 1000) {
            return acum;
        }
        return value + acum;
    }

    private String[] splitValues (String values) {
        return values.split("\\W");
    }

    private List<Integer> parseIntValues(String[] values) {
        return Arrays.stream(values).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean containsFirstNumeralCharacter(String values) {
        return values.charAt(0) == '#';
    }

    private boolean isLengthEqualThanOne(String values) {
        return values.length() == 1;
    }
}
