package cn.dfeng;

import cn.dfeng.control.Controller;
import cn.dfeng.model.Direction;

public class Simulator {

    private long longest = 0;
    private long shortest = Long.MAX_VALUE;

    /**
     * 开始模拟
     */
    public void simulate() {
        for (int i = 0; i < 32; i++) {
            Controller con = new Controller(this.getDirections(i));
            long time = con.start();
            if( time > longest ){
                longest = time;
            }
            if( time < shortest ){
                shortest = time;
            }
            System.out.println( " Time: " + time );
        }
    }

    /*
     * 创建蚂蚁初始位置
     */
    private Direction[] getDirections(int i) {
        Direction[] dirs = new Direction[5];
        String binString = Integer.toBinaryString(i);
        StringBuilder sb = new StringBuilder();
        int lack = 5 - binString.length();

        for( int c = 0; c < lack; c++ ){
            sb.append('0');
        }
        sb.append( binString );
        binString = sb.toString();
        int p = 0;
        while( p < binString.length() ) {

            if (binString.charAt(p) == '0') {
                dirs[p] = Direction.Left;
            } else {
                dirs[p] = Direction.Right;
            }
            p++;
        }

        System.out.print( "Round: " + binString );

        return dirs;
    }

    /**
     * 打印结果
     */
    public void getResult() {
        System.out.printf("Longest time %d.\nShortest Time: %d", longest,
                shortest);
    }

    public static void main( String[] args ){
        Simulator sim = new Simulator();

        sim.simulate();

        sim.getResult();
    }
}
