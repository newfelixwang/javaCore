package com.wang.newcode.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：wp
 * @Package：com.wang.newcode.code
 * @Project：java-Core
 * @name：Find
 * @Date：2023/5/6 15:20
 * @Filename：Find
 */
public class Find {

    public static boolean Find(int target, int [][] array) {

        //暴力破解
        // if(array.length ==0){
        //     return false;
        // }
        // for(int i =0 ; i<array.length; i++){
        //     for(int j =0; j <array[i].length; j++){
        //         if(target == array[i][j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        //利用举证有序性
        int line = array.length - 1; //行
        int cloSize = array[line].length -1 ; //列
        if ( array == null || array.length == 0 ||array[0].length ==0 ) {
            return false;
        }

        //从第0列开始
        int clo = 0;
        while (line >= 0) {
            if ( clo >= cloSize) {
                line --;
            } else if (array[line][clo] < target) {
                clo++;
            } else if (array[line][clo] == target) {
                 return true;
            } else {
                line --;
            }
        }
        return false;
    }

    public static void main(String[] args) {
      //  int [][] array =[[1,1]];
//        int array [][] = {{1,2,3,5},{2,4,5,6},{7,8,9,10}};
//        boolean find = Find(22, array);
//        System.out.println(find);

        String v1 = "1.0.02";

        String v2 = "2.1.02";

        String v3 = "2.1.02";

        String[] split = v1.split("\\.");
//        System.out.println(split[0]);
//        for (String str : split){
//            System.out.println(str);
//        }

//        for (int i = 1; i < list.size(); i += 2) {
//            Collections.reverse(list.get(i));
//        }

      //  int[] sss = {1,27,8,9,23,4,6,31};
        List<Integer> sss1 = Arrays.asList(1,27,8,9,23,4,6,31);
        Collections.reverse(sss1);
        sss1.stream().forEach(System.out::println);

        String str1 = "001";
        String str2 = "1";

        System.out.println(Integer.parseInt(str1));
        System.out.println(Integer.parseInt(str2));


    }


    public   static  boolean Find2(int target, int [][] array) {
        // 判断二维数组是否为空
        if(array == null || array.length == 0){
            return false;
        }
        // 遍历从最后一行开始
        int line = array.length - 1;
        // 获取一行中列的数量
        int cloSize = array[line].length;
        // 列从0为开始
        int clo = 0;
        // 只要二维数组行不越界，while继续
        while (line >= 0){
            // 当前列下标 大于等于 最大列时，行向上移动
            if(clo >= cloSize){
                line--;
            }else if(array[line][clo] == target){ // 根据当前行，列对应的值等于要找的数时，返回true
                return true;
            }else if(array[line][clo] < target){ // 根据当前行，列对应的值 小于 要找的数时，列向右移动
                clo++;
            }else{ // 否则就是 根据当前行，列对应的值 大于 要找的数时，行向上移动
                line--;
            }
        }
        // while退出表示仍未找到相同值，返回false结果
        return false;
    }

}
