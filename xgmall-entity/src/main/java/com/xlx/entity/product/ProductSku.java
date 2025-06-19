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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "product_sku",
        indexes = {
                @Index(columnList = "product_id", name = "idx_sku_product"),
                @Index(columnList = "stock", name = "idx_sku_stock"),
                @Index(columnList = "status", name = "idx_sku_status")
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "sku_code", name = "uk_sku_code")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_sku_product")
    )
    private Product product;

    @Column(name = "sku_code", nullable = false, length = 64)
    private String skuCode;

    @Column(name = "price", nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "cost_price", precision = 18, scale = 2)
    private BigDecimal costPrice;

    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer stock;

    @Column(name = "weight", precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(name = "volume", precision = 10, scale = 4)
    private BigDecimal volume;

    @Column(name = "status", nullable = false)
    private Byte status;

    @Column(name = "attributes_json", columnDefinition = "JSON")
    private String attributesJson;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted;

    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 64)
    private String createBy;

    @CreatedDate
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;

    @LastModifiedBy
    @Column(name = "update_by", nullable = false, length = 64)
    private String updateBy;

    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer version;
}
