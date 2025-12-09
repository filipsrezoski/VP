/*package mk.ukim.finki.wp.lab.service;

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

        Dish dish = new Dish(newId, dishId, name, cuisine, preparationTime, false);
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

    public Dish like(Long id){
        Dish dish = dishRepository.findById(id).orElse(null);
        if(dish != null){
            dish.setLiked(!dish.isLiked());
            dishRepository.save(dish);
        }
        return dish;
    }

}*/
package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DishServiceImpl(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId).orElse(null);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Chef chef = chefRepository.findById(chefId).orElse(null);

        Dish dish = new Dish(null, dishId, name, cuisine, preparationTime);
        dish.setChef(chef);

        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime, Long chefId) {
        Dish dish = dishRepository.findById(id).orElse(null);

        if (dish != null) {
            dish.setDishId(dishId);
            dish.setName(name);
            dish.setCuisine(cuisine);
            dish.setPreparationTime(preparationTime);

            Chef chef = chefRepository.findById(chefId).orElse(null);
            dish.setChef(chef);

            return dishRepository.save(dish);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> findDishesByChef(Long chefId) {
        return dishRepository.findAllByChef_Id(chefId);
    }

    @Override
    public Dish Like(Long id) {
        Dish dish = dishRepository.findById(id).orElse(null);
        if (dish != null) {
            dish.setLiked(!dish.isLiked());
            dishRepository.save(dish);
        }
        return dish;
    }
}
