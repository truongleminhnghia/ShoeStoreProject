package org.project.shoestoreproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@Data

public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int prdocutId;

    @Column(name = "product_name", columnDefinition = "NVARCHAR(300)", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description", columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name = "color", columnDefinition = "NVARCHAR(100)")
    private String color;

    @Column(name = "brand", columnDefinition = "NVARCHAR(300)")
    private String brand;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Column(name = "is_active")
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Image> images =  new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Size> sizes=  new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Feedback> feedbacks = new ArrayList<>();


    public Product(LocalDateTime createAt, LocalDateTime updateAt, String productName, double price,
                   String description, String color, String brand, int stockQuantity, boolean isActive,
                   Category category, List<Image> images, List<Size> sizes) {
        super(createAt, updateAt);
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.color = color;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
        this.isActive = isActive;
        this.category = category;
        this.images = images;
        this.sizes = sizes;
    }
}
