package com.example.mini_05_marketmulti.product.model;

public class ProductVO {

    private int num;
    private String pname; // pname -> name으로 변경
    private String content; // 새로운 필드 추가
    private int price;
    private String company; // model -> company로 변경
    private String img; // 새로운 필드 추가

    @Override
    public String toString() {
        return "ProductVO{" +
                "num=" + num +
                ", pname='" + pname + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price + '\'' +
                ", company='" + company + '\'' +
                ", img='" + img + '\'' +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}