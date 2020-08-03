package cn.dfeng.model;

import java.util.ArrayList;

public class Ant {

    public static final int LENGTH = 27;
    private int position;
    Direction direction;

    /*
     * 在木杆上的蚂蚁队列
     */
    ArrayList<Ant> list;

    public Ant( int p, Direction dir, ArrayList<Ant> list ){
        this.position = p;
        this.direction = dir;
        this.list = list;
    }

    /**
     * 蚂蚁行走
     */
    public void walk(){

        if( direction == Direction.Right ){
            position++;
        }else{
            position--;
        }

        //如果大于最大长度获小于0即视为爬出木杆
        if( position >= LENGTH || position <= 0 ){
            list.remove( this );
        }
    }

    /**
     * 蚂蚁调头, 行走一秒后查看自己是不是需要调头
     */
    public void shift(){
        int index = list.indexOf( this );
        if( index == 0 && list.size() > 1 ){
            if( this.position == list.get(1).position ){
                doShift();
            }
        }else if( index == list.size()-1 && index > 0 ){
            if( this.position == list.get(index-1).position ){
                doShift();
            }
        }else if( index > 0 && index < list.size()-2){
            if( this.position == list.get(index+1).position || this.position == list.get(index-1).position){
                doShift();
            }
        }
    }

    private void doShift(){
        this.direction = (this.direction == Direction.Left) ? Direction.Right : Direction.Left;
    }
}

