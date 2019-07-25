package com.ranx.chowder.dataStructure.recursive;

/**
 * @author ranx
 * @create 2018-08-27 15:29
 **/
public class Recursive {

    //汉诺塔， x->y, z作为过渡塔
    /*
    如果多于一个盘子，则需要将塔座 X 上的 1 到 n-1 个盘子使用 Z 作为过渡塔座放到塔座 Y 上，
    然后将第 n 个盘子（最后一个盘子）放到塔座 Z，
    最后将塔座 Y 上的 n-1个盘子使用塔座 X 作为过渡放到塔座 Z。
     */
    public void hanio(int n, char x, char y, char z) {
        if (n == 1) {
            move(x, n, z);
        } else {
            hanio(n-1, x, z, y);
            move(x, n-1, y);
            hanio(n-1, y, x, z);
        }

    }

    public void move (char x, int n, char y) {
        System.out.println("Move " + n + "from " + x + "to " + y);
    }


    /*
    寻找具有n个元素的数组a[0, n-1]中的最大与最小元素
     */
    public IntPair simpleMinMax (int[] a) {
        IntPair pair = new  IntPair();
        pair.x = a[0];
        pair.y = a[0];
        for (int i=1; i<a.length; i++) {
            if (pair.x < a[i]) {
                pair.x = a[i];
            }
            if (pair.y > a[i]) {
                pair.y = a[i];
            }
        }
        return pair;
    }
    //分治法
    public IntPair min_max(int[] a, int low, int high) {
        IntPair pair = new  IntPair();
        if (low > high-2) {
            if (a[low] < a[high]) {
                pair.x = a[high];
                pair.y = a[low];
            } else {
                pair.y = a[high];
                pair.x = a[low];
            }
        } else {
            int mid = (low + high) / 2;
            IntPair p1 = min_max(a, low, mid);
            IntPair p2 = min_max(a, mid, low);
            pair.x = p1.x > p2.x ? p1.x : p2.x;
            pair.y = p1.y > p2.y ? p1.y : p2.y;
        }
        return pair;
    }
    private class IntPair{
        int x;
        int y;

    }

    /*
    整数数组a[0, n-1]中的第k小元素
     */
    public int selectK(int a[], int n, int k){
        if (n<38) {
//            mergeSort(a, 0, a.length-1); //使用归并排序直接对数组排序
            return a[k-1];
        }

        int[] m = new int[n/5];
        for (int i=0; i<n/5; i++) {
// TODO           m[i] = mid(a, 5*i, 5*i+4);
        }

        int mm = selectK(m, m.length, (m.length+1)/2);
        int[] a1 = new int[3*n/4];
        int[] a3 = new int[3*n/4];
        int r=0, s=0, t=0;
        for (int i=0; i<n; i++) {

        }
        return 1;
    }
}
