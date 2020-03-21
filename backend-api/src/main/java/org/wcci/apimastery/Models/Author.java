package org.wcci.apimastery.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "author")
    private Collection<Book> books;

    @OneToMany(mappedBy = "author")
    private Collection<Comments> comments;

    @OneToOne (cascade = {CascadeType.ALL})
    private Rating rating;

    public void addUpRating(){
        rating.addUpRating();
    }
    public void addDownRating(){
        rating.addDownRating();
    }
    private String name;
    private int age;
    private String homeTown;

    public Author() {
    }

    public Author(String name, int age, String homeTown) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
        this.rating = new Rating();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public Rating getRating() {
        return rating;
    }

    public Collection<Comments> getComments() {
        return comments;
    }
    public void addCommentToBook(Comments commentToAdd){
        comments.add(commentToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (age != author.age) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        return homeTown != null ? homeTown.equals(author.homeTown) : author.homeTown == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (homeTown != null ? homeTown.hashCode() : 0);
        return result;
    }
}
