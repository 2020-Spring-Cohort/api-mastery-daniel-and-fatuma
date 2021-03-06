package org.wcci.apimastery.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Author author;
    @OneToOne
    private Book book;

    private int upRating = 0;

    private int downRating = 0;

    protected Rating(){ }

    public Rating(int upRating, int downRating){
        this.upRating = upRating;
        this.downRating = downRating;
    }
    public void addUpRating(){
        upRating++;
    }
    public void addDownRating(){
        downRating++;
    }

    public Long getId() {
        return id;
    }

    public int getUpRating() {
        return upRating;
    }

    public int getDownRating() {
        return downRating;
    }
}
