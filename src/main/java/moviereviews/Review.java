package moviereviews;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String openStatus;
    private String reviewTitle;
    private String reviewContents;
    private String reviewer;

    @PostPersist
    public void onPostPersist() {
        MovieInfoCreated movieinfCreated = new MovieInfoCreated();
        BeanUtils.copyProperties(this, movieinfCreated);
        movieinfCreated.publish();
    }

    @PostUpdate
    public void onPostUpdate(){
        ReviewWrited reviewWrited = new ReviewWrited();
        BeanUtils.copyProperties(this, reviewWrited);
        reviewWrited.publish();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getOpenStatus() {
        return openStatus;
    }
    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }
    public String getReviewTitle() {
        return reviewTitle;
    }
    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }
    public String getReviewContents() {
        return reviewContents;
    }
    public void setReviewContents(String reviewContents) {
        this.reviewContents = reviewContents;
    }
    public String getReviewer() {
        return reviewer;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}
