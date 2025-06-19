package com.xlx.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sys_user")
@EntityListeners(AuditingEntityListener.class)
public class SysUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_uuid", unique = true, nullable = false, updatable = false, columnDefinition = "CHAR(36)")
    private String userUuid;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone", unique = true, length = 20)
    private String phone;

    /** 带默认值的字段才用 @Builder.Default */
    @Builder.Default
    @Column(name = "status", nullable = false)
    private Byte status = 1;

    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;


    @CreatedBy
    @Column(name = "create_by", length = 50)
    private String createBy;


    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @LastModifiedBy
    @Column(name = "update_by", length = 50, nullable = false)
    private String updateBy;



    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @PrePersist
    public void generateUuid() {
        if (this.userUuid == null) {
            this.userUuid = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
