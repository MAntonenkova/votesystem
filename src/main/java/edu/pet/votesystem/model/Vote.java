package edu.pet.votesystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "vs_votes")
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id", nullable = false, unique = true)
    private Integer voteId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "vote_date", nullable = false)
    private LocalDate voteDate;
    @Column(name = "vote_time", nullable = false)
    private LocalTime voteTime;

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
    }

    public LocalTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalTime voteTime) {
        this.voteTime = voteTime;
    }
}
