package com.example.web07total.comments.model;

public class CommentsVO {

    //num(PK),content,writer,wdate,bnum(FK)
    private int num;
    private String content;
    private String writer;
    private String wdate;
    private int bnum;

    @Override
    public String toString() {
        return "CommentsVO{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", wdate='" + wdate + '\'' +
                ", bnum=" + bnum +
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

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }
}
