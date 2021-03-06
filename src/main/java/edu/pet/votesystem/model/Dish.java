package edu.pet.votesystem.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;

@Table(name = "vs_dishes")
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id", nullable = false, unique = true)
    private Long dishId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;
    @NotBlank (message = "dish name should not be empty")
    @Size(min = 2, max = 100)
    @Column(name = "dish_name", nullable = false)
    private String dishName;
    @NotNull
    @Positive
    @Min(value = 0, message = "dish price should be greater than zero")
    @Column(name = "dish_price", nullable = false)
    private Integer price;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", restaurantId=" + restaurant.getRestaurantId() +
                ", restaurantName=" + restaurant.getRestaurantName() +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                '}';
    }
}
