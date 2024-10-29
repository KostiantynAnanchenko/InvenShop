package project.InvenShop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product add(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product update(long id, String name, int quantity, int price, long EAN) {
        Product product = productRepository.getReferenceById(id);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setEAN(EAN);
        productRepository.save(product);
        return product;
    }

    public Product findById(long id) {
        return productRepository.getReferenceById(id);
    }

    public Optional<Product> findByEAN(long EAN) {
       return productRepository.findByEAN(EAN);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }


}
