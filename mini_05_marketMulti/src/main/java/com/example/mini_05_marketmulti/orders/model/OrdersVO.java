package com.example.mini_05_marketmulti.orders.model;

import java.sql.Date;

public class OrdersVO {
    private int num;
    private int pnum;
    private int mnum;
    private Date odate;
    private String address;

    @Override
    public String toString() {
        return "OrdersVO{" +
                "num=" + num +
                ", pnum=" + pnum +
                ", mnum=" + mnum +
                ", odate=" + odate +
                ", address='" + address + '\'' +
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

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
