/*package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.bootstrap.Dataholder;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("dishes",dishService.listDishes());

        if(error != null){
            model.addAttribute("error",error);
        }
        return "listDishes";
    }

    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime){
        dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime){
        dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }


    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model){
        model.addAttribute("dish",dishService.findById(id));
        return "dish-form";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage(Model model){
        return "dish-form";
    }

    @PostMapping("/like/{id}")
    public String Like(@PathVariable Long id){
        dishService.like(id);
        return "redirect:/dishes";
    }

}*/
package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("dishes", dishService.listDishes());

        if (error != null) {
            model.addAttribute("error", error);
        }
        return "listDishes";
    }

    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime,
                           @RequestParam Long chefId) {
        dishService.create(dishId, name, cuisine, preparationTime, chefId);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime,
                           @RequestParam Long chefId) {
        dishService.update(id, dishId, name, cuisine, preparationTime, chefId);
        return "redirect:/dishes";
    }

    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        model.addAttribute("chefs", chefService.listChefs());
        return "dish-form";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage(Model model) {
        model.addAttribute("chefs", chefService.listChefs());
        return "dish-form";
    }

    @PostMapping("/like/{id}")
    public String toggleLike(@PathVariable Long id){
        dishService.Like(id);
        return "redirect:/dishes";
    }

    @GetMapping("/by-chef/{chefId}")
    public String getDishesByChef(@PathVariable Long chefId, Model model) {
        model.addAttribute("dishes", dishService.findDishesByChef(chefId));
        model.addAttribute("chef", chefService.findById(chefId));
        return "listDishes";
    }
}
