package com.sofkau;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String values) throws NumberFormatException {
        if(values.isEmpty()) {
            return 0;
        }

        if(values.length() == 1) {
            return Integer.parseInt(values);
        }

        if(values.contains("-")) {
            throw new NumberFormatException("NegativeNumberException");
        }

        if(values.charAt(0) == '#') {
            values = values.replaceFirst("#", "");
        }

        var splitValues = splitValues(values);

        return parseIntValues(splitValues).stream()
                .reduce(0, (acum, value) -> {
                    if(value > 1000) {
                        return acum;
                    }
                    return acum + value;
                });
    }

    private String[] splitValues (String values) {
        return values.split("\\W");
    }

    private List<Integer> parseIntValues(String[] values) {
        return Arrays.stream(values).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}

