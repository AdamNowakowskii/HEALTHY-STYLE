package app.healftystyle.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private String shortDescription;

    @Enumerated(EnumType.STRING)
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
