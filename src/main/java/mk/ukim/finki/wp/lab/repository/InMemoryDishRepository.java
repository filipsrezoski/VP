/*package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryDishRepository implements DishRepository{

    @Override
    public List<Dish> findAll() {
        return Dataholder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return Dataholder.dishes.stream().filter(d -> d.getDishId().equals(dishId)).findFirst().orElse(null);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return Dataholder.dishes.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        Optional<Dish> food = findById(dish.getId());
        if (food.isPresent()) {
            Dish d = food.get();
            d.setName(dish.getName());
            d.setCuisine(dish.getCuisine());
            d.setPreparationTime(dish.getPreparationTime());
            return d;
        }else{
            Dataholder.dishes.add(dish);
            return dish;
        }
    }

    @Override
    public void deleteById(Long id) {
        Dataholder.dishes.removeIf(d -> d.getId().equals(id));
    }

}
*/