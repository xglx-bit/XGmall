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
@Table(name = "product_attribute")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Attribute ID, auto-increment primary key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_attr_product")
    )
    private Product product; // Associated product ID (foreign key to product.id)

    @Column(name = "attr_name", nullable = false, length = 128)
    private String attrName; // Attribute name (e.g. "Color")

    @Column(name = "attr_value", nullable = false, length = 128)
    private String attrValue; // Attribute value (e.g. "Red")

    @Column(name = "sort_order", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer sortOrder; // Display priority (higher value = more prominent)

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted; // Logical deletion flag (0=active, 1=deleted)

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
