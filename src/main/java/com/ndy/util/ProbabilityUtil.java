package com.ndy.util;

public class ProbabilityUtil {

    /**
     * @param maxNum probability mtp num
     * @param benchMark probability benchMark point
     * */
    public static boolean isProbability(int maxNum, long benchMark) {
        int calc = (int) (Math.random() * maxNum);

        return calc >= Math.abs(benchMark-maxNum);
    }

    public static boolean isProbability(int calcNum, int benchMark) {
        return calcNum <= benchMark;
    }

}
