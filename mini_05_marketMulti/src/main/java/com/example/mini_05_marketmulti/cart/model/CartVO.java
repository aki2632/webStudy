package com.example.mini_05_marketmulti.cart.model;

public class CartVO {
    private int num;
    private int pnum;
    private int mnum;
    private Integer amountCount;
    private Integer priceCount;

    @Override
    public String toString() {
        return "CartVO{" +
                "num=" + num +
                ", pnum=" + pnum +
                ", mnum=" + mnum +
                ", amountCount=" + amountCount +
                ", priceCount=" + priceCount +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getMnum() {
        return mnum;
    }

    public void setMnum(int mnum) {
        this.mnum = mnum;
    }

    public Integer getAmountCount() {
        return amountCount;
    }

    public void setAmountCount(Integer amountCount) {
        this.amountCount = amountCount;
    }

    public Integer getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Integer priceCount) {
        this.priceCount = priceCount;
    }
}