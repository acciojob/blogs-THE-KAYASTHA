package com.driver.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Blog")
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String title;
    private String content;



    private Date pubDate;

    @JoinColumn
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog",cascade =CascadeType.ALL)
    private List<Image> imageList=new ArrayList<>();

    public Blog(){

    }
    public Blog(String title,String content){
        this.title=title;
        this.content=content;
        this.pubDate= Calendar.getInstance().getTime();
    }

    public String getContent() {
        return content;
    }

    public Integer getId() {
        return Id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}