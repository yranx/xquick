package com.ranx.chowder;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ranx
 * @create 2018-09-10 20:31
 **/
public class TestStudy {

//    public static void main(String[] args) {
////        int[] x = new int[25];
//////        System.out.println(x[24]);
//////        System.out.println(x[25]);
//        String str = null;
//        System.out.println(str);
//    }

//
//    public static int aMethod() {
//         int i = 0;
//        i++;
//        return i;
//    }

//    public static void main(String args[]) {
////        TestStudy test = new TestStudy();
////        test.aMethod();
////        int j = test.aMethod();
////        System.out.println(j);
//
//        TestStudy a = new TestStudy();
//        String s1 = "one";
//        String str1 = "one";
//        System.out.println(s1 == str1);
//        String str2 = new String("one");
//        System.out.println(str1 == str2);
//
//        String s2 = s1;
//        System.out.println(s2);
//
//        s1+= "two";
//        System.out.println(s2);
//
//
//        StringBuffer b1 = new StringBuffer("three");
//        StringBuffer b2 = b1;
//        b2.append("four");
//        System.out.println(b1); //b1=threefour, b2=threefour
//    }

//    private static int i;
//    private static String str;
//    public static void main(String[] args) {
//        System.out.println(i);
//        System.out.println(str);
//    }


//        public static void main(String[] args) {
//            int i;
//            String str;
//            System.out.println(i);
//            System.out.println(str);
//        }

    public static void main(String[] args) {
       System.out.println(("Admin").toLowerCase() == "admin");
       System.out.println("\\123456\123456\t".length());
        System.out.println("123456\123456\t".length());
        System.out.println("over");
        nullMethod();

    }

    public static Integer nullMethod(){
        for (int i=0; i<9; i++){
            if (i==6) {
                return null;
            }
            System.out.println(i);
        }
        return null;
    }
}
