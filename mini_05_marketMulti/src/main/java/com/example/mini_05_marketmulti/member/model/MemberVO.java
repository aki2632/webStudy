package com.example.mini_05_marketmulti.member.model;

public class MemberVO {
    private int member_num;
    private String member_id;
    private String pw;
    private String name;
    private String tel;
    private String address;

    @Override
    public String toString() {
        return "MemberVO{" +
                "member_num=" + member_num +
                ", member_id='" + member_id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getMemberNum() {
        return member_num;
    }

    public void setMemberNum(int member_num) {
        this.member_num = member_num;
    }

    public String getMemberId() {
        return member_id;
    }

    public void setMemberId(String member_id) {
        this.member_id = member_id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
