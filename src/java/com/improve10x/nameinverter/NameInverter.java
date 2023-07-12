package com.improve10x.nameinverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {
    public String invertName(String name) {
        if (name.equals("")) {
            return "";
        } else if (isSingleWord(name)) {
            return name.trim();
        } else {
            return formatMultiElementName(name);
        }
    }

    private boolean isSingleWord(String name) {
        return !name.trim().contains(" ");
    }

    private String formatMultiElementName(String name) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
        removeHonorifics(names);
        String postNominal = getPostNominal(names.subList(2, names.size()));
        return (names.get(1) + ", " + names.get(0) + " " + postNominal).trim();
    }

    private String getPostNominal(List<String> postNominalsList) {
        String postNominal = "";
        for (int i = 0; i < postNominalsList.size(); i++) {
            postNominal += postNominalsList.get(i) + " ";
        }
        return postNominal;
    }

    private void removeHonorifics(ArrayList<String> names) {
        if (hasHonorifics(names) && names.size() > 2) {
            names.remove(0);
        }
    }

    private boolean hasHonorifics(ArrayList<String> names) {
        return names.get(0).matches("Mrs.|Mr.|Miss.");
    }
}
