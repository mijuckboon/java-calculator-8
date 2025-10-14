package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");
    public static final String CUSTOM_SEPARATOR_OPENER = "//";
    public static final String CUSTOM_SEPARATOR_CLOSER = "\\n"; // escape code

    private String customSeparator;
    private String trimmedInput;

    public InputHandler(String input) {
        customSeparator = extractCustomSeparator(input);
        trimmedInput = extractTrimmedInput(input);
    }

    public String getCustomSeparator() {
        return customSeparator;
    }

    public String getTrimmedInput() {
        return trimmedInput;
    }

    private String extractCustomSeparator(String input) {
        if (hasCustomSeparator(input)) {
            return input.substring(CUSTOM_SEPARATOR_OPENER.length(), input.indexOf(CUSTOM_SEPARATOR_CLOSER));
        }

        return null;
    }

    private String extractTrimmedInput(String input) {
        if (this.customSeparator != null) {
            return input.substring(input.indexOf(CUSTOM_SEPARATOR_CLOSER) + CUSTOM_SEPARATOR_CLOSER.length());
        }

        return input;
    }

    boolean hasCustomSeparator(String input) {
        // empty custom separator를 허용하지 않으려면 length 체크 조건 추가
        return input.startsWith(CUSTOM_SEPARATOR_OPENER) && input.contains(CUSTOM_SEPARATOR_CLOSER);
    }

    String getSeparatorsRegex() {
        StringBuilder regexBuilder = new StringBuilder();
        List<String> separators = new ArrayList<>(DEFAULT_SEPARATORS);
        if (customSeparator != null) {
            String separatorToAdd = escape(customSeparator);
            separators.add(separatorToAdd);
        }

        for (String separator : separators) {
            regexBuilder.append(separator);
            regexBuilder.append("|"); // or
        }

        return regexBuilder.substring(0, regexBuilder.length() - 1);
    }

    private String escape(String input) {
        return escapePipeline(input);
    }

    private String escapePipeline(String input) {
        if (input.equals("|")) {
            return "[|]";
        }
        return input;
    }

}
