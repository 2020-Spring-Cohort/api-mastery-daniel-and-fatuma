package org.wcci.apimastery.Models;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Book book;

    private String user;
    private String comment;

    protected Comments(){}

    public Comments(String user, String comment){
        this.user = user;
        this.comment = user;

    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (id != null ? !id.equals(comments.id) : comments.id != null) return false;
        if (author != null ? !author.equals(comments.author) : comments.author != null) return false;
        if (book != null ? !book.equals(comments.book) : comments.book != null) return false;
        if (user != null ? !user.equals(comments.user) : comments.user != null) return false;
        return comment != null ? comment.equals(comments.comment) : comments.comment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
