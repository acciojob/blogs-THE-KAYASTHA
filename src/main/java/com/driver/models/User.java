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
    private Integer Id;

    private String username;

    private String password;

    private String firstName;
    private String lastName;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList=new ArrayList<>();
    public User(){

    }

    public User(String userName,String password,String firstName,String lastName){
        this.username=userName;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }





    public User(String userName,String password){
        this.username=userName;
        this.password=password;
        this.firstName="test";
        this.lastName="test";

    }

    public Integer getId() {
        return Id;
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

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
        this.Id = id;
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

    public void setUsername(String userName) {
        this.username = userName;
    }




    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}