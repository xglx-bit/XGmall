package com.xlx.entity.user.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class SysUserRoleId implements Serializable {
    @Column(name = "user_id",columnDefinition = "char(32)")
    private String userId;

    @Column(name = "role_id")
    private Long roleId;

    public SysUserRoleId() {}

    public SysUserRoleId(String userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleId that = (SysUserRoleId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}