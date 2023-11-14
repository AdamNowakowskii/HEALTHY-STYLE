package app.healftystyle.shop;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDTO {
    private Long id;

    private String title;

    private String description;

    private String shortDescription;

    private Category category;

    private double price;

    private String imgUrl;

    private String firstParagraphTitle;

    private String firstParagraphDescription;

    private String secondParagraphTitle;

    private String secondParagraphDescription;

    private String firstPhoto;

    private String secondPhoto;

    private String thirdPhoto;


}
