package com.wang.newcode.code;

/**
 * @Author：wp
 * @Package：com.wang.newcode.code
 * @Project：newcode
 * @name：compareStr
 * @Date：2023/5/8 10:02
 * @Filename：compareStr
 */
public class compareStr {


    public static int compare(String version1, String version2) {
        // write code here
        //暴力循环比较
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int num1 = 0;
        int num2 = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (s1.length > s2.length) {
            for (int i = 0; i <= s2.length - 1; i++) {
                System.out.println(s1[i]);
                System.out.println(s2[i]);
                sb1.append((Integer.parseInt(s1[i])));
                sb2.append((Integer.parseInt(s2[i])));
            }
        } else {
            for (int i = 0; i <= s1.length - 1; i++) {
                System.out.println(s1[i]);
                System.out.println(s2[i]);
                sb1.append((Integer.parseInt(s1[i])));
                sb2.append((Integer.parseInt(s2[i])));
            }
        }

        if (s1.length >= s2.length) {
            num1 = Integer.parseInt(sb1.toString());
            num2 = Integer.parseInt(sb2.toString());
            System.out.println(num1);
            System.out.println(num2);
            if (num1 >= num2) {
                return 1;
            } else {
                return -1;
            }
        }


        if (s1.length < s2.length) {
            num1 = Integer.parseInt(sb1.toString());
            num2 = Integer.parseInt(sb2.toString());
            if (num1 > num2) {
                return 1;
            } else {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        String ss2 = "1.222.00.55";
//        String[] split = ss2.split("\\.");
//
//        String replace1 = ss2.replace("0", "");
//        String replace2 = replace1.replace(".", "");
//
//
//        System.out.println(replace1);
//        System.out.println(replace2);


        System.out.println(compare3("1.01","1.001"));
    }

    public static int compare3(String version1, String version2) {

        String[] strNum1 = version1.split("");

        String[] strNum2 = version2.split("");
//        String[] s1 = version1.split("\\.");
//        String[] s2 = version2.split("\\.");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if (strNum1.length >= strNum2.length) {
            for (int i = 0; i < strNum1.length; i++) {
                sb1.append((strNum1[i]));
                if (i > strNum2.length - 1) {

                    if (i > strNum2.length) {
                        sb2.append(".0");
                        System.out.println("BBBBBB" + i + "sssss+" + (strNum2.length - 1));
                    }

                } else {
                    sb2.append((strNum2[i]));
                }
            }
        } else {
            for (int i = 0; i < strNum2.length; i++) {
                sb2.append(((strNum2[i])));
                if (i > strNum1.length - 1) {
                    if (i > strNum1.length) {
                        sb1.append(".0");
                        System.out.println("i===" + i + "  length ==" + (strNum1.length - 1));
                    }
                } else {
                    System.out.println("TTTTTTTTTTT  i = " + i);
                    System.out.println(sb1.toString());
                    sb1.append(((strNum1[i])));
                }
            }
        }

        System.out.println(sb1);
        System.out.println(sb2);
        int i = compareInt(sb1, sb2);
        return i;
    }

    public static int compareInt(StringBuilder sb1, StringBuilder sb2) {
        String[] split1 = sb1.toString().split("\\.");
        String[] split2 = sb2.toString().split("\\.");

        for (int i = 0; i < split1.length; i++) {
            System.out.println("##########" + split1[i] + "######" + split2[i]);
            if (split1[i].equals(split2[i])) {
                continue;
            }
            if (Integer.parseInt(split1[i]) > Integer.parseInt(split2[i])) {
                return 1;
            }
            if (Integer.parseInt(split1[i]) < Integer.parseInt(split2[i])) {
                return -1;
            }
        }
        return 0;
    }

    public static int compare2(String version1, String version2) {
        // write code here
        //暴力循环比较
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int num1 = 0;
        int num2 = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (s1.length > s2.length) {
            for (int i = 0; i <= s2.length - 1; i++) {
                System.out.println(s1[i]);
                System.out.println(s2[i]);
                sb1.append((Integer.parseInt(s1[i])));
                sb2.append((Integer.parseInt(s2[i])));
            }
        } else {
            for (int i = 0; i <= s1.length - 1; i++) {
                System.out.println(s1[i]);
                System.out.println(s2[i]);
                sb1.append((Integer.parseInt(s1[i])));
                sb2.append((Integer.parseInt(s2[i])));
            }
        }

        if (s1.length >= s2.length) {
            num1 = Integer.parseInt(sb1.toString());
            num2 = Integer.parseInt(sb2.toString());
            System.out.println(num1);
            System.out.println(num2);
            if (num1 >= num2) {
                return 1;
            } else {
                return -1;
            }
        }


        if (s1.length < s2.length) {
            num1 = Integer.parseInt(sb1.toString());
            num2 = Integer.parseInt(sb2.toString());
            if (num1 > num2) {
                return 1;
            } else {
                return -1;
            }
        }

        return 0;
    }
}
