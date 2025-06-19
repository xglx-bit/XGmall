package com.xlx.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "product_brand",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name", name = "uk_brand_name")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Brand ID, auto-increment primary key

    @Column(name = "name", nullable = false, length = 128)
    private String name; // Unique brand name (max 128 characters)

    @Column(name = "logo_url", length = 256)
    private String logoUrl; // Brand logo URL (max 256 characters)

    @Column(name = "description", length = 512)
    private String description; // Brand description (max 512 characters)

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted; // Logical deletion flag (0=active, 1=deleted)

    @Column(name = "create_by", nullable = false, length = 64)
    private String createBy; // Creator's username (max 64 characters)

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime; // Creation timestamp (auto-generated)

    @Column(name = "update_by", nullable = false, length = 64)
    private String updateBy; // Last modifier's username (max 64 characters)

    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime; // Last modification timestamp (auto-updated)

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer version; // Optimistic locking version number (auto-incremented)
}
