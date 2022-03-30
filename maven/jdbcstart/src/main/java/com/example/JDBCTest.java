package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Member{

private String userid;
private String username;
private int age; 

Member(String userid, String username, int age){

    this.userid = userid;
    this.username = username;
    this.age = age;

}

static class Builder{

    private String userid;
    private String username;
    private int age;
    
    public Builder userid(String userid){
        this.userid = userid;
        return this;
    }

    public Builder username(String username){
        this.username = username;
        return this;
    }

    public Builder age(int age){
        this.age = age;
        return this;
    }

    public Member build(){

        if(userid == null || username == null || age == 0)
            throw new IllegalStateException("멤버 클래스가 생성이 안됩니다.");
        return new Member(userid, username, age);
    }

}

public String getUsername() {return username;}
public String getUserid() { return userid;}
public int getAge(){ return age;}




}

public class JDBCTest {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mariadb://127.0.0.1:3306/webdev";
        String userid = "webmaster";
        String userpw = "1234";
        String query = "select userid, username, age from tbl_test";

        Connection con;
        Statement stmt;
        ResultSet rs;

        Class.forName("org.mariadb.jdbc.Driver"); //드라이브 구동
        con = DriverManager.getConnection(url, userid, userpw);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        List<Member> list = new ArrayList<>();

        //Member 인스턴스가 형성된다.
        while(rs.next()){
            //list.add(new Member(rs.getString("userid"), rs.getString("username"), rs.getInt("age")));
            list.add(new Member.Builder()
                    .userid(rs.getString("userid"))
                    .username(rs.getString("username"))
                    .age(rs.getInt("age"))
                    .build() 
            );
        }

        for(Member member: list){
            
            System.out.println("아이디 :" + member.getUserid()
                + ", 이름 = " + member.getUsername() 
                + ", 나이 = " + member.getAge() );
        }

        //DB 닫는다.
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(con != null) con.close();

    }
}
