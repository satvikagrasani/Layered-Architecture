package in.mindcraft.contollers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.LaptopDao;
import in.mindcraft.pojos.Laptop;

@Controller
public class LaptopController {

    private final LaptopDao laptopDao = new LaptopDao();

    @RequestMapping(value = "/insertlap", method = RequestMethod.POST)
    public ModelAndView addLaptop(HttpServletRequest request, Model model) {
        int lid = Integer.parseInt(request.getParameter("lid"));
        String make = request.getParameter("make");
        double cost = Double.parseDouble(request.getParameter("cost"));

        Laptop laptop = new Laptop(lid, make, cost);
        ModelAndView mv = new ModelAndView("result");

        try {
            if (laptopDao.addLaptop(laptop)) {
                model.addAttribute("inRes", "successful");
            } else {
                model.addAttribute("inRes", "failure");
            }
        } catch (Exception e) {
            model.addAttribute("inRes", "failure");
        }

        return mv;
    }

    @RequestMapping("/showlaptop")
    public ModelAndView showLaptop() {
        ModelAndView mv = new ModelAndView("show");

        try {
            List<Laptop> list = laptopDao.getLaptop();
            mv.addObject("list", list);
        } catch (Exception e) {
            mv.addObject("list", null);
        }

        return mv;
    }
}
