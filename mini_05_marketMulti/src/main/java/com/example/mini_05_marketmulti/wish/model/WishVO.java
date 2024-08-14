package com.example.mini_05_marketmulti.wish.model;

public class WishVO {
    private int num;
    private int mnum;
    private int pnum;

    @Override
    public String toString() {
        return "WishVO{" +
                "num=" + num +
                ", mnum=" + mnum +
                ", pnum=" + pnum +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMnum() {
        return mnum;
    }

    public void setMnum(int mnum) {
        this.mnum = mnum;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
}
