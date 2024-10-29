package project.InvenShop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public ModelAndView getAllProducts() {
        ModelAndView result = new ModelAndView("allProducts");
        result.addObject("listProducts", productService.listAll());
        return result;
    }

    @GetMapping("/add")
    public ModelAndView getPageForAdding() {
        return new ModelAndView("addNewProduct");
    }

    @PostMapping("/addProduct")
    public String addNewProduct(@RequestParam String name, @RequestParam int quantity, @RequestParam int price, @RequestParam long EAN) {
        Product newProduct = new Product(name, quantity, price, EAN);
        productService.add(newProduct);
        return "redirect:/products/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getProductForEdit(@PathVariable Long id) {
        ModelAndView result = new ModelAndView("editProduct");
        result.addObject("product", productService.findById(id));
        return result;
    }

    @GetMapping("/search")
    public ModelAndView searchByEAN(@RequestParam long ean) {
        ModelAndView result = new ModelAndView("allProducts");
        result.addObject("listProducts", productService.findByEAN(ean).map(List::of).orElse(List.of()));
        return result;
    }

    @PostMapping("/edit")
    public String editNote(@RequestParam Long id, @RequestParam String name, @RequestParam int quantity,@RequestParam int price,@RequestParam long EAN ) {
        productService.update(id, name, quantity, price, EAN);
        return "redirect:/products/list";
    }


}
