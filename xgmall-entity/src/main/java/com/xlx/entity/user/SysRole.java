package com.xlx.entity.user;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id // 标记为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略：数据库自增
    private Long id;

    @Column(name = "role_code", unique = true, nullable = false, length = 50)
    private String roleCode;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false; // 逻辑删除标识，默认false

    @CreatedBy // Spring Data JPA 审计注解：创建人
    @Column(name = "create_by", length = 50)
    private String createBy;

    @CreatedDate // Spring Data JPA 审计注解：创建时间
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @LastModifiedBy // Spring Data JPA 审计注解：最后修改人
    @Column(name = "update_by", length = 50)
    private String updateBy;

    @LastModifiedDate // Spring Data JPA 审计注解：最后修改时间
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    @Version // JPA 乐观锁版本控制
    @Column(name = "version", nullable = false)
    private Integer version; // 乐观锁版本号
}
