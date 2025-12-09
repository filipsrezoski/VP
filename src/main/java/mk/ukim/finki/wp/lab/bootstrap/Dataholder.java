package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Dataholder {

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public Dataholder(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @PostConstruct
    public void init() {
        Chef chef1 = new Chef(null, "Filip", "Srezoski", "Chef vo Hilton", new ArrayList<>());
        Chef chef2 = new Chef(null, "Jamie", "Oliver", "British chef", new ArrayList<>());
        Chef chef3 = new Chef(null, "Nikola", "Nikolche", "Chef vo brza kujna", new ArrayList<>());
        Chef chef4 = new Chef(null, "Gordon", "Ramsey", "Najbolji", new ArrayList<>());
        Chef chef5 = new Chef(null, "Verka", "Nestoroska", "Najbolja za komat", new ArrayList<>());

        chefRepository.save(chef1);
        chefRepository.save(chef2);
        chefRepository.save(chef3);
        chefRepository.save(chef4);
        chefRepository.save(chef5);

        Dish dish1 = new Dish(null, "DISH001", "Pizza", "Italian", 120);
        dish1.setChef(chef1);

        Dish dish2 = new Dish(null, "DISH002", "Pasta Primavera", "Italian", 30);
        dish2.setChef(chef2);

        Dish dish3 = new Dish(null, "DISH003", "Sarma", "Makedonska", 45);
        dish3.setChef(chef3);

        Dish dish4 = new Dish(null, "DISH004", "Beef Wellington", "Britis", 15);
        dish4.setChef(chef4);

        Dish dish5 = new Dish(null, "DISH005", "Komat", "Makedonska", 60);
        dish5.setChef(chef5);

        dishRepository.save(dish1);
        dishRepository.save(dish2);
        dishRepository.save(dish3);
        dishRepository.save(dish4);
        dishRepository.save(dish5);
    }
}