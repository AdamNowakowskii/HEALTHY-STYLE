package app.healftystyle.shop;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private Set<ProductDTO> cartItem = new LinkedHashSet<>();


    public List<ProductDTO> findAllByCategory(String category) {
        return productRepository.findAllByCategory(Category.valueOf(category.toUpperCase())).stream().map(ProductDtoMapper::map).collect(Collectors.toList());
    }

    public List<ProductDTO> findAllProduct() {
        return productRepository.findAll().stream()
                .map(ProductDtoMapper::map)
                .collect(Collectors.toList());
    }

    public Set<ProductDTO> addToCart(Long id) {
        ProductDTO dto = ProductDtoMapper.map(productRepository.findById(id).get());
        cartItem.add(dto);
        return cartItem;
    }

    public void removeFromCart() {
        Set<ProductDTO> productDTOS = Set.copyOf(cartItem);
        for (ProductDTO productDTO : productDTOS) {
            cartItem.remove(productDTO);
        }
    }

    public String senEmailWithProduct(EmailInformation emailInformation) {
        StringBuilder stringBuilder = new StringBuilder();
        if (cartItem.isEmpty()) {
            return "";
        } else {
            for (ProductDTO productDTO : cartItem) {
                stringBuilder.append(productDTO.getTitle()).append("PRICE: ").append(productDTO.getPrice()).append(stringBuilder).append("\n");
                stringBuilder.append("Delivery Information: " + "\n");
                stringBuilder.append("FirstName: ").append(emailInformation.getFirstName()).append("\n");
                stringBuilder.append("Address: ").append(emailInformation.getAddress()).append("\n");
                stringBuilder.append("zipCode: ").append(emailInformation.getZipCode()).append("\n");
                stringBuilder.append("city: ").append(emailInformation.getCity()).append("\n");
                stringBuilder.append("email: ").append(emailInformation.getEmail()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public ProductDTO findById(Long id) {
        return ProductDtoMapper.map(productRepository.findById(id).get());
    }

    static class ProductDtoMapper {
        static ProductDTO map(Product product) {
            return new ProductDTO(
                    product.getId(),
                    product.getTitle(),
                    product.getDescription(),
                    product.getShortDescription(),
                    product.getCategory(),
                    product.getPrice(),
                    product.getImgUrl(),
                    product.getFirstParagraphTitle(),
                    product.getFirstParagraphDescription(),
                    product.getSecondParagraphTitle(),
                    product.getSecondParagraphDescription(),
                    product.getFirstPhoto(),
                    product.getSecondPhoto(),
                    product.getThirdPhoto()
            );
        }
    }
}
