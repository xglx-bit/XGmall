package com.xlx.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_category")
@EntityListeners(AuditingEntityListener.class)
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Category ID, auto-increment primary key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ProductCategory parent; // Parent category reference (null for top-level)

    @Column(name = "name", nullable = false, length = 128)
    private String name; // Category name (max 128 characters)

    @Column(name = "level", nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Byte level; // Category hierarchy level (1=top, 2=sub, etc.)

    @Column(name = "sort_order", nullable = false)
    private Byte sortOrder; // Sort priority (higher value = more prominent)

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted; // Logical deletion flag (0=active, 1=deleted)

    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 64)
    private String createBy; // Creator's username (max 64 characters)

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime; // Creation timestamp (auto-generated)

    @LastModifiedBy
    @Column(name = "update_by", nullable = false, length = 64)
    private String updateBy; // Last modifier's username (max 64 characters)

    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime; // Last modification timestamp (auto-updated)

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer version; // Optimistic locking version number (auto-incremented)
}
