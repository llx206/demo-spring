package cn.dfeng.control;

import cn.dfeng.model.Ant;
import cn.dfeng.model.Direction;

import java.util.ArrayList;

public class Controller {

    /*
     * 蚂蚁初始位置
     */
    private int[] positions = { 3, 7, 11, 17, 23 };

    /*
     *蚂蚁初始方向
     */
    private Direction[] dir;

    private long timer = 0;

    /**
     * 指定蚂蚁初始方向, 创建控制器
     * @param dir
     */
    public Controller( Direction[] dir ){
        this.dir = dir;
    }

    public long start(){
        ArrayList<Ant> list = this.init();

        /*
         * 蚂蚁队列为空即全部爬出
         */
        while( list.size() != 0 ){
            //爬行
            for( int i = 0; i < list.size(); i++ ){
                Ant ant = list.get(i);
                ant.walk();
            }
            //掉头
            for( int i = 0; i < list.size(); i++ ){
                Ant ant = list.get(i);
                ant.shift();
            }

            timer++;
        }
        return timer;
    }

    /*
     * 创建初始蚂蚁队列
     */
    private ArrayList<Ant> init(){
        ArrayList<Ant> list = new ArrayList<Ant>();
        for( int i = 0; i < positions.length; i++ ){
            Ant ant = new Ant( positions[i], dir[i], list );
            list.add( ant );
        }
        return list;
    }
}
