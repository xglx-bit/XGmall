package com.xlx.entity.user;

import com.xlx.entity.user.key.SysUserRoleId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "sys_user_role")
@Data
public class SysUserRole {
    @EmbeddedId
    private SysUserRoleId id;

    @Column(name = "create_time")
    @CreationTimestamp
    private LocalDateTime createTime;


}
