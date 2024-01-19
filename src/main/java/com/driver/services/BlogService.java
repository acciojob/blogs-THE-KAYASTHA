package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository1;

    @Autowired
    private UserRepository userRepository1;

    @Autowired
    private ImageRepository imageRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

            Blog newBlog=new Blog();
            newBlog.setTitle(title);
            newBlog.setContent(content);


        Optional<User> userOptional=userRepository1.findById(userId);
            User user=userOptional.get();
        newBlog.setUser(user);

        blogRepository1.save(newBlog);

        return newBlog;


    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
            Optional<Blog> bb=blogRepository1.findById(blogId);

            if(bb.isEmpty()){
                return;
            }

            Blog blog=bb.get();


            blogRepository1.deleteById(blogId);


    }
}
