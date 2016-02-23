package org.mc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean canBreak(String string, Set<String> dict) {
        if (string == null || string.isEmpty())
            return false;

        // canBreak[i] <=> string[0..i) can be broke into list of words in dict
        boolean[] canBreak = new boolean[string.length()+1];
        canBreak[0] = true;

        for (int i = 1; i <= string.length(); i++) {
            String currentSubstring = string.substring(0, i);

            for (int j = currentSubstring.length()-1; j >= 0; j--) {
                String ending = currentSubstring.substring(j);
                if (dict.contains(ending) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[string.length()];
    }

    public static List<String> generateAll(String string, Set<String> dict) {
        if (string == null || string.isEmpty())
            return new ArrayList<>();

        List<List<String>> divisions = new ArrayList<List<String>>();
        for (int i = 0; i <= string.length(); i++)
            divisions.add(new ArrayList<String>());

        divisions.get(0).add("");

        for (int i = 1; i <= string.length(); i++) {
            String currentSubstring = string.substring(0, i);

            for (int j = currentSubstring.length()-1; j >= 0; j--) {
                String ending = currentSubstring.substring(j);

                if (dict.contains(ending) && !divisions.get(j).isEmpty()) {
                    List<String> iDiv = divisions.get(i);
                    for (String div : divisions.get(j))
                        iDiv.add(div + (div.isEmpty() ? ending : " " + ending));
                }
            }
        }

        return divisions.get(string.length());
    }
}
