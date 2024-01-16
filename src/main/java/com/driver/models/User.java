package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String password;

    private String firstName;
    private String lastName;

    User(){

    }

    public User(String userName,String password,String firstName,String lastName){
        this.userName=userName;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }





    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
        this.firstName="test";
        this.lastName="test";

    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Integer id) {
        this.userId = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)

    private List<Blog> blogList=new ArrayList<>();


    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}