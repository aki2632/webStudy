package com.example.mini_05_marketmulti.review.model;

public class ReviewVO {

    private int num;
    private String content;
    private String writer;
    private String rdate; // TIMESTAMP를 문자열로 저장
    private int pnum;
    private String img; // 추가된 필드
    private int rate; // 추가된 필드

    @Override
    public String toString() {
        return "ReviewVO{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", rdate='" + rdate + '\'' +
                ", pnum=" + pnum +
                ", img='" + img + '\'' +
                ", rate=" + rate +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

