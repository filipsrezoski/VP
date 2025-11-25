/*package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

@WebServlet(name="dishServlet",urlPatterns="/dish")
public class DishServlete extends HttpServlet {
    private final ChefService chefService;
    private final DishService dishService;

    private final SpringTemplateEngine templateEngine;

    public DishServlete(ChefService chefService, DishService dishService, SpringTemplateEngine templateEngine) {
        this.chefService = chefService;
        this.dishService = dishService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        long chefId= -1L;
        String chefIdParam =  req.getParameter("chefId");
        if(chefIdParam != null) {
            chefId = Long.parseLong(chefIdParam);
        }

        Chef chef = chefService.findById(chefId);

        WebContext context = new WebContext(webExchange);
        context.setVariable("dishes", dishService.listDishes());
        context.setVariable("chefId", chefId);
        context.setVariable("chefName", chef.getFirstName() + " " + chef.getLastName());

        templateEngine.process("dishesList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chefId = req.getParameter("chefId");
        resp.sendRedirect("/dish?chefId=" + chefId);
    }
}
*/