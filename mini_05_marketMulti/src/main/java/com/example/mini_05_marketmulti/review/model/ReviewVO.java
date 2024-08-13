package com.example.mini_05_marketmulti.review.model;

public class ReviewVO {

    //review_id(PK),content,writer,wdate,product_id(FK)
    private int review_id;
    private String content;
    private String writer;
    private String wdate;
    private int product_id;

    @Override
    public String toString() {
        return "CommentsVO{" +
                "review_id=" + review_id +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", wdate='" + wdate + '\'' +
                ", product_id=" + product_id +
                '}';
    }

    public int getReviewId() {
        return review_id;
    }

    public void setReviewId(int review_id) {
        this.review_id = review_id;
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

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
}
