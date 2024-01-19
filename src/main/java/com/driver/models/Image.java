package com.driver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Image")
public class Image{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer Id;

        private String description;
        private String dimensions;


    @JoinColumn
    @ManyToOne
    private Blog blog;

       public Image(){

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

        public void setId(Integer imageId) {
                this.Id = imageId;
        }

        public Integer getId() {
                return this.Id;
        }

        public String getDescription() {
                return description;
        }

        public String getDimensions() {
                return dimensions;
        }



        public Blog getBlog() {
                return blog;
        }

        public void setBlog(Blog blog) {
                this.blog = blog;
        }
}