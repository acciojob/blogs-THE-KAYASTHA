package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository3;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private BlogRepository blogRepository;
    public User createUser(String username, String password){
            User newUser=new User(username,password);

            userRepository3.save(newUser);

    return newUser;
    }

    public void deleteUser(int userId){
        //delete user and respective blog




        userRepository3.deleteById(userId);

       /* for(Blog i:temp){
            List<Image> ll=i.getImageList();

            for(Image j:ll){
                imageRepository.deleteById(j.getId());
            }
            blogRepository.deleteById(i.getId());



        }*/


    }

    public User updateUser(Integer id, String password){

            Optional<User> user=userRepository3.findById(id);


            User uu=user.get();
            uu.setPassword(password);
            userRepository3.save(uu);

            return uu;


    }
}
