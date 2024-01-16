package com.driver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Image")
public class Image{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer imageId;

        private String description;
        private String dimensions;


        Image(){

        }
        public Image(String description,String dimensions){
                this.description=description;
                this.dimensions=dimensions;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setDimensions(String dimensions) {
                this.dimensions = dimensions;
        }

        public void setImageId(Integer imageId) {
                this.imageId = imageId;
        }

        public Integer getImageId() {
                return imageId;
        }

        public String getDescription() {
                return description;
        }

        public String getDimensions() {
                return dimensions;
        }

        @JoinColumn
        @ManyToOne
        private Blog blog;

        public Blog getBlog() {
                return blog;
        }

        public void setBlog(Blog blog) {
                this.blog = blog;
        }
}