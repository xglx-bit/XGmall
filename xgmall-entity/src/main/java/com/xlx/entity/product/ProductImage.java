package com.xlx.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Image ID, primary key with auto-increment

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_img_product")
    )
    private Product product; // Associated product ID (foreign key to product.id)

    @Column(name = "image_url", nullable = false, length = 512)
    private String imageUrl; // Image URL address (max 512 characters)

    @Column(name = "is_default", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDefault; // Whether it's the default image (0=no, 1=yes)

    @Column(name = "sort_order", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer sortOrder; // Sorting order (higher value means more prominent)

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted; // Logical deletion flag (0=not deleted, 1=deleted)

    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 64)
    private String createBy; // Creator's username

    @CreatedDate
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime; // Creation timestamp

    @LastModifiedBy
    @Column(name = "update_by", nullable = false, length = 64)
    private String updateBy; // Last modifier's username

    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime; // Last modification timestamp

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer version; // Optimistic locking version number
}
