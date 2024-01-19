package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        Image image=new Image( );
            image.setDescription(description);
            image.setDimensions(dimensions);
        Optional<Blog>  blog=blogRepository2.findById(blogId);
        Blog bb=blog.get();
        image.setBlog(bb);
        imageRepository2.save(image);


        // not saved in blog list
        return image;
    }

    public void deleteImage(Integer id){


        imageRepository2.deleteById(id);





    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> optionalImage=imageRepository2.findById(id);
        Image image=optionalImage.get();

        String size= image.getDimensions();

        String temp[]=size.split("X");
        int a=Integer.valueOf(temp[0]);
        int b=Integer.valueOf(temp[1]);

        String given[]=screenDimensions.split("X");
        int c=Integer.valueOf(given[0]);
        int d=Integer.valueOf(given[1]);

        int myScreenSize=a*b;
        int givenScreenSize=c*d;



        return givenScreenSize/myScreenSize;


    }
}
