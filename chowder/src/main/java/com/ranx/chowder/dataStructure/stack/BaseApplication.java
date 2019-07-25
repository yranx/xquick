package com.ranx.chowder.dataStructure.stack;

/**
 * @author ranx
 * @create 2018-08-24 15:57
 **/
public class BaseApplication {

    //十进制转八进制
    public void baseConversion(int i) {
        Stack s = new StackSLinked();
        while (i>0) {
            s.push(i%8 + "");
            i = i/8;
        }
        while(!s.isEmpty()) {
            System.out.print((String)s.pop());
        }
    }

    //括号匹配检测
    public boolean bracketMatch(String str) {
        Stack s = new StackSLinked();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            switch(c) {
                case '{':
                case '[':
                case '(': s.push(Integer.valueOf(c)); break;
                case '}':
                    if (!s.isEmpty() && ((Integer)s.pop()).intValue() == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!s.isEmpty() && ((Integer)s.pop()).intValue() == '[') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (!s.isEmpty() && ((Integer)s.pop()).intValue() == '(') {
                        break;
                    } else {
                        return false;
                    }
                default:;
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //迷宫求解
    //输入 表示迷宫的字符数组，起点、终点坐标。找到从起点到终点的路径
    public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
        Cell[][] cells = createMaze(maze);
        // TODO
    }

    private Cell[][] createMaze(char[][] maze) {
        Cell[][] cells = new Cell[maze.length][];
        for (int x=0; x<maze.length; x++) {
            char[] row = maze[x];
            cells[x] = new Cell[row.length];
            for (int y=0; y<row.length; y++) {
                cells[x][y] = new Cell(x, y, maze[x][y], false);
            }
        }
        return cells;
    }
}
