/*package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {

    private final DishService dishService;
    private final ChefService chefService;
    private final SpringTemplateEngine templateEngine;

    public ChefDetailsServlet(DishService dishService, ChefService chefService, SpringTemplateEngine templateEngine) {
        this.dishService = dishService;
        this.chefService = chefService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        long chefId= -1L;
        String chefIdParam =  req.getParameter("chefId");
        if(chefIdParam != null) {
            chefId = Long.parseLong(chefIdParam);
        }

        Chef chef = chefService.findById(chefId);

        HttpSession session = req.getSession();

        /* Edno reshenie so ID na chef
        List<Long> recentChefs = (List<Long>) session.getAttribute("recentChefs");
        if(recentChefs == null){
            recentChefs = new ArrayList<>();
        }

        recentChefs.remove(chefId);
        recentChefs.add(chefId);

        if(recentChefs.size() > 3){
            recentChefs.remove(0);
        }*/

 /*       List<Chef> recentChefs = (List<Chef>) session.getAttribute("recentChefs");
        if(recentChefs == null){
            recentChefs = new ArrayList<>();
        }

        recentChefs.removeIf(c -> c.getId().equals(chef.getId()));
        recentChefs.add(chef);

        if(recentChefs.size() > 3){
            recentChefs.remove(0);
        }



        session.setAttribute("recentChefs", recentChefs);
        context.setVariable("chefName", chef.getFirstName() + " " + chef.getLastName());
        context.setVariable("bio", chef.getBio());
        context.setVariable("dishes", chef.getDishes());
        templateEngine.process("chefDetails.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long chefId= -1L;
        String chefIdParam =  req.getParameter("chefId");
        if(chefIdParam != null) {
            chefId = Long.parseLong(chefIdParam);
        }
        String dishId = req.getParameter("dishId");
//        Dish dish = dishService.findByDishId(dishId);
        Chef chef = chefService.addDishToChef(chefId, dishId);
        resp.sendRedirect("/chefDetails?chefId=" + chef.getId());
    }
}

*/