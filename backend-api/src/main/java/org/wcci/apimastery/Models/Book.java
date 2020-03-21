package org.wcci.apimastery.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @JsonIgnore
    @ManyToOne
    private Author author;
    private String genre;
    private String publishedDate;
    private String publishingCompany;

    @OneToMany(mappedBy = "book")
    private Collection<Comments> comments;


    @OneToOne (cascade = {CascadeType.ALL})
    private Rating rating;

    public void addUpRating(){
        rating.addUpRating();
    }
    public void addDownRating(){
        rating.addDownRating();
    }


    public Book() {
    }

    public Book(String title, Author author,String genre, String publishedDate, String publishingCompany) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
        this.publishingCompany = publishingCompany;
        this.comments = new HashSet<>();
        this.rating = new Rating();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public Rating getRating() {
        return rating;
    }

    public void addCommentToBook(Comments commentToAdd){
        comments.add(commentToAdd);
    }

    public Collection<Comments> getComments() {
        return  comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (publishedDate != null ? !publishedDate.equals(book.publishedDate) : book.publishedDate != null)
            return false;
        if (publishingCompany != null ? !publishingCompany.equals(book.publishingCompany) : book.publishingCompany != null)
            return false;
        return rating != null ? rating.equals(book.rating) : book.rating == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (publishingCompany != null ? publishingCompany.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
