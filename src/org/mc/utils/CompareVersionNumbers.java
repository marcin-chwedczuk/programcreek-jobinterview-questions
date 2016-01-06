package org.mc.utils;

public class CompareVersionNumbers {
    public int compare(String versionNumberA, String versionNumberB) {
        String[] aParts = splitVersionNumber(versionNumberA);
        String[] bParts = splitVersionNumber(versionNumberB);

        int maxLength = Math.min(aParts.length, bParts.length);
        for(int i = 0; i < maxLength; i++) {
            int cmp = Integer.valueOf(aParts[i]) - Integer.valueOf(bParts[i]);
            if (cmp != 0)
                return sign(cmp);
        }

        int lengthCmp = aParts.length - bParts.length;
        return sign(lengthCmp);
    }

    private String[] splitVersionNumber(String versionNumber) {
        return versionNumber.split("\\.");
    }

    private int sign(int n) {
        if (n == 0) return 0;
        return (n > 0) ? 1 : (-1);
    }
}
