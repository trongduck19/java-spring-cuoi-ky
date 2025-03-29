package com.springboot.dev_spring_boot_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "dance")
public class Dance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "Tên sản phẩm là bắt buộc.")
    @Size(max = 100, message = "Tên sản phẩm không được vượt quá 100 ký tự.")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Giá là bắt buộc.")
    @Positive(message = "Giá phải là số dương lớn hơn 0.")
    @Digits(integer = 10, fraction = 2, message = "Giá phải có tối đa 2 chữ số thập phân.")
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    
    @Size(max = 255, message = "URL hình ảnh không được vượt quá 255 ký tự.")
    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank(message = "Mô tả sản phẩm là phải bắt buộc.")
    @Size(max = 500, message = "Mô tả sản phẩm không được vượt quá 500 ký tự.")
    @Column(name = "description")
    private String description;

    public Dance() {
    }

    public Dance(String name, BigDecimal price, String imageUrl, String description) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
