package org.mc.utils;

import java.util.Stack;

public class SimplifyPath {
    private final String DIR_SEPARATOR = "/";

    public String solve(String path) {
        String[] parts = path.split("[/]");
        Stack<String> dirStack = new Stack<>();

        for(String part : parts) {
            if (part.isEmpty()) {
                // case /foo//bar
                continue;
            }
            else if ("..".equals(part)) {
                if (!dirStack.empty())
                    dirStack.pop();
            }
            else if (".".equals(part)) {
                continue;
            }
            else {
                dirStack.push(part);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        simplifiedPath.append(DIR_SEPARATOR);

        for (String dir : dirStack) {
            simplifiedPath.append(dir);
            simplifiedPath.append(DIR_SEPARATOR);
        }

        // remove trailing DIR_SEPARATOR
        if (simplifiedPath.length() > 1)
            simplifiedPath.deleteCharAt(simplifiedPath.length()-1);

        return simplifiedPath.toString();
    }
}
