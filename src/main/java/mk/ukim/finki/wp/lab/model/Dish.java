package mk.ukim.finki.wp.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Dish {
    private Long id;
    String dishId;
    String name;
    String cuisine;
    int preparationTime;

    public int getLikes() {
        return likeButton;
    }

    public void setLikes(int likeButton) {
        this.likeButton = likeButton;
    }

    int likeButton;
    //int popularity;


}
