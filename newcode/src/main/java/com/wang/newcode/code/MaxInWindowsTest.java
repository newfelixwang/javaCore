package com.wang.newcode.code;

import java.util.ArrayList;

/**
 * @Author：wp
 * @Package：com.wang.newcode.code
 * @Project：java-Core
 * @name：MaxInWindowsTest
 * @Date：2023/5/10 18:01
 * @Filename：MaxInWindowsTest
 */
public class MaxInWindowsTest {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size) {
            return new ArrayList<>();
        }
        int temp = 0;
        for (int i = 0; i < num.length - size + 1; i++) {
            System.out.println("num=" + num[i]);
            int[] curnum = new int[size];
            for (int j = 0; j < size; j++) {
                curnum[j] = num[i + j];
                System.out.println("curnum=" + curnum[j]);
            }
            System.out.println("max num" + curnum.toString());
            res.add(maxInt(curnum));
        }
        return res;
    }

    //求数组最大值
    private static int maxInt(int[] m) {

        for (int i = 0; i < m.length - 1; i++) {
            System.out.print(m[i]);
        }

        int temp = 0;
        int cur = 0;
        for (int i = 0; i < m.length - 1; i++) {
            if (m[i] > m[i + 1]) {
                temp = m[i];
            } else {
                temp = m[i + 1];
            }

            System.out.println("cur===="+cur+"temp===="+temp);
            if (cur > temp) {
                continue;
            }
            cur = temp;
        }
        System.out.println("temp=" + temp);
        return cur;
    }

    public static void main(String[] args) {
        int[] num = {9,10,9,-7,-3,8,2,-6};
        int size = 0;
        System.out.println(maxInWindows(num, size));
    }
}
