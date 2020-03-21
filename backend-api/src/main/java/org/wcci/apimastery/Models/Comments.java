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
        return id == comments.id &&
                Objects.equals(user, comments.user) &&
                Objects.equals(comment, comments.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, comment);
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
