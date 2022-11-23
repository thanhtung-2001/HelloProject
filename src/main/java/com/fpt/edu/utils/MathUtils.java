package com.fpt.edu.utils;

public class MathUtils {

    public static boolean isSoNguyenTo(int number){
        for (int i = 2; i < number; i++) {
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isChinhPhuong(int number){
        int sqrt = (int) Math.sqrt(number);
        if(number == sqrt*sqrt) return true;
        return false;
//        return number == sqrt*sqrt;
    }

//    public static void main(String[] args) {
//        System.out.println(isSoNguyenTo(2));
//        System.out.println(isSoNguyenTo(3));
//        System.out.println(isSoNguyenTo(4));
//        System.out.println(isSoNguyenTo(5));
//        System.out.println(isSoNguyenTo(6));
//        System.out.println("---------------------");
//        System.out.println(isChinhPhuong(4));
//        System.out.println(isChinhPhuong(5));
//        System.out.println(isChinhPhuong(6));
//    }
}
