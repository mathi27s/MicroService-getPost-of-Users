package com.example.demo.user;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

//@ApiModel(description="All details about the com.example.demo.user.")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private Date birthDate;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<post> post;

    public List<com.example.demo.user.post> getPost() {
        return post;
    }

    public void setPost(List<com.example.demo.user.post> post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer id, Date birthDate, String name) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
    }
    public User(){

    }
}