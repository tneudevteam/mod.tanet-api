package main.java.api.parser;

import org.jsoup.nodes.Element;

public class NameGroupParser {

    private Element nameGroupElement;

    public NameGroupParser(Element nameGroupElement) {
        this.nameGroupElement = nameGroupElement;
    }

    public String parseName() {
        String rawName = nameGroupElement.text().split("\\(")[0];
        String formattedName = capitalizeString(rawName);
        if (formattedName.length() == 0) {
            return "Ім’я Прізвище";
        } else {
            return formattedName;
        }
    }

    public String parseGroup() {
        try {
            return nameGroupElement.text().split("\\(")[1].split("\\)")[0];
        } catch (Exception e) {
            e.printStackTrace();
            return "ГРУПА";
        }
    }

    private String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
