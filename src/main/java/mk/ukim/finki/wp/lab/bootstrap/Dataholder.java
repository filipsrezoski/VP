package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataholder {

    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    // On application startup, initialize the in-memory lists with predefined data
    // On each startup, the lists will be initialized with the same values and the previous values will be lost
    @PostConstruct
    public void init() {
        dishes.add(new Dish(1L, "D1", "Pizza", "Italia", 5, false));
        dishes.add(new Dish(2L, "D2", "Ajvar", "Macedonia", 60,false ));
        dishes.add(new Dish(3L, "D3", "Smash Burger", "USA", 15,false));
        dishes.add(new Dish(4L, "D4", "Baklava", "Turkey", 15,false));
        dishes.add(new Dish(5L, "D5", "Bolognese", "Italia", 10,false));

        chefs.add(new Chef(1L, "Filip", "Srezoski", "Macedonian", new ArrayList<>()));
        chefs.add(new Chef(2L, "Teodora", "Mateska", "Swedish", new ArrayList<>()));
        chefs.add(new Chef(3L, "Elena", "Srezoski", "Serbian", new ArrayList<>()));
        chefs.add(new Chef(4L, "George", "Henderson", "England", new ArrayList<>()));
        chefs.add(new Chef(5L, "Ivan", "Hernangomez", "Spanish", new ArrayList<>()));
    }

}
