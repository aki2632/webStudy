package com.example.web03board;

import java.sql.Timestamp;

public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String writer;
    private Timestamp wdate;

    @Override
    public String toString() {
        return "BoardVO{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", wdate=" + wdate +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Timestamp getWdate() {
        return wdate;
    }

    public void setWdate(Timestamp wdate) {
        this.wdate = wdate;
    }
}
