package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime) {
        Long newId = Dataholder.dishes.size() + 1L;

        Dish dish = new Dish(newId, dishId, name, cuisine, preparationTime, 0);
        dishRepository.save(dish);
        return dish;
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        Optional<Dish> dish = dishRepository.findById(id);
        if (dish.isPresent()) {
            Dish oldDish = dish.get();
            oldDish.setDishId(dishId);
            oldDish.setName(name);
            oldDish.setCuisine(cuisine);
            oldDish.setPreparationTime(preparationTime);
            dishRepository.save(oldDish);
            return oldDish;
        } else {
            return null;
        }
    }


    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

}
