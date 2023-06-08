package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo {

    private int id; //  글 번호
    private String name; // 작성자 이름
    private String password; // 비밀번호
    private String Content; // 메모 내용
    private Date date; // 작성일

    // 기본생성자
    public Memo(){};

    // 생성자 메서드 영역
    public Memo(String name, String password, String content, Date date) {
        this.name = name;
        this.password = password;
        this.Content = content;
        this.date = date;
    }

    // getter, setter 메서드
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setContent(String content) {
        this.Content = content;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getContent() {
        return Content;
    }
    public Date getDate() {
        return date;
    }

    // 메모 출력하기
    public void printMemo() {
        System.out.printf("\n이름: %s\n내용: %s",this.getName(),this.getContent());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String formatedNow = formatter.format(this.date);
        System.out.printf("\n작성일자: %s",formatedNow);
    }
}
