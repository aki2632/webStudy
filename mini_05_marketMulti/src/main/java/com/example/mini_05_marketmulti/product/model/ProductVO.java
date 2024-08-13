package com.example.mini_05_marketmulti.product.model;

public class ProductVO {

    private int num;
    private String pname;
    private String model;
    private int price;
    private int count;
    private String user_id;

    @Override
    public String toString() {
        return "ProductVO{" +
                "num=" + num +
                ", pname='" + pname + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
