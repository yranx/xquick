package com.ranx.chowder.study.dataStructure.stack;

/**
 * 迷宫单元
 * @author ranx
 * @create 2018-08-27 11:11
 **/
public class Cell {
    int x = 0; //单元所在行
    int y = 0; //单元所在列
    //是否访问
    boolean visited = false;
    //是墙('1')、可通路('0')或起点到终点的路径('*')
    char c = ' ';

    public Cell(int x, int y, char c, boolean visited) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.visited = visited;
    }
}
