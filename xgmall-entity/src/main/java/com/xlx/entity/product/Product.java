package com.xlx.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Product ID, primary key with auto-increment

    @Column(name = "sku_prefix", nullable = false, length = 32)
    private String skuPrefix; // SKU code prefix for generating full SKU

    @Column(name = "name", nullable = false, length = 256)
    private String name; // Product name (max 256 characters)

    @Column(name = "subtitle", length = 256)
    private String subtitle; // Product subtitle (optional)

    @Column(name = "description", columnDefinition = "TEXT")
    private String description; // Product description (supports HTML)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_id",
            foreignKey = @ForeignKey(name = "fk_prod_brand")
    )
    private ProductBrand brand; // Associated brand ID (foreign key to product_brand.id)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            foreignKey = @ForeignKey(name = "fk_prod_cat")
    )
    private ProductCategory category; // Associated category ID (foreign key to product_category.id)

    @Column(name = "default_price", nullable = false, precision = 18, scale = 2)
    private BigDecimal defaultPrice; // Default selling price (DECIMAL(18,2))

    @Column(name = "default_image", length = 512)
    private String defaultImage; // Default main image URL (max 512 characters)

    @Column(name = "status", nullable = false)
    private Byte status; // Product status: 0=offline, 1=online

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted; // Logical deletion flag (0=not deleted, 1=deleted)

    @Column(name = "create_by", nullable = false, length = 64)
    private String createBy; // Creator's username

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime; // Creation timestamp

    @Column(name = "update_by", nullable = false, length = 64)
    private String updateBy; // Last modifier's username

    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime; // Last modification timestamp

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer version; // Optimistic locking version number
}
