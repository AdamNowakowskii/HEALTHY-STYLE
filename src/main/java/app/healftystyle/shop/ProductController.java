package app.healftystyle.shop;


import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.healftystyle.emailSender.EmailDetails;
import app.healftystyle.emailSender.EmailServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProductController {
    ProductService productService;
    EmailServiceImpl emailService;

    @GetMapping("/products")
    public String allProduct(Model model, @RequestParam(required = false) String categoryName) {
        List<ProductDTO> products = null == categoryName ? productService.findAllProduct() :
                productService.findAllByCategory(categoryName);
        model.addAttribute("product", products);
        model.addAttribute("category", Category.values());
        return "shop";
    }


    @GetMapping("/item/{id}")
    public String singleItem(Model model, @PathVariable Long id) {
        model.addAttribute("byId", productService.findById(id));
        return "itemWebsite";
    }

    @GetMapping("/shoppingBasket")
    public String showBasket(Model model, HttpSession session, EmailInformation emailInformation) {
        model.addAttribute("basketSet", session.getAttribute("basketSet"));
        model.addAttribute("email", emailInformation);
        return "shoppingBasket";
    }

    @Scope(
            value = SCOPE_SESSION,
            proxyMode = TARGET_CLASS)
    @GetMapping("/basket/{id}")
    public String addToBasket(HttpSession session, @PathVariable Long id) {
        session.setAttribute("basketSet", productService.addToCart(id));
        return "redirect:/products";
    }

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/buyItem")
    public String itemInfo(Model model) {
        EmailInformation email = new EmailInformation();
        model.addAttribute("email", email);
        return "shoppingBasket";
    }

    @PostMapping("/buyItem")
    public String buy(EmailInformation email, Model model) {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(email.getEmail());
        emailDetails.setSubject("Yours shopping");
        String msg = productService.senEmailWithProduct(email);
        if (msg.isEmpty()) {
            model.addAttribute("empty", "empty");
            return "redirect:/buyItem";
        }
        emailDetails.setMsgBody(msg);
        emailService.sendSimpleMail(emailDetails);
        productService.removeFromCart();
        return "redirect:/";
    }
}
