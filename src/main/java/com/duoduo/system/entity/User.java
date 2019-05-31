package com.duoduo.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duoduo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_user")
@ExcelTarget("user")
public class User extends BaseEntity implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @Excel(name="用户名")
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    //@TableField(select = false)
    private String password;

    /**
     * 图片
     */
    @Excel(name="图片")
    @ApiModelProperty("图片")
    private String image;

    /**
     * 手机号
     */
    @Excel(name="手机号")
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 邮箱
     */
    @Excel(name="邮箱")
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 角色列表
     */
    @ApiModelProperty("角色列表")
    @TableField(exist=false)
    private List<Role> roleList;

    /**
     * 权限
     */
    @ApiModelProperty("权限")
    @TableField(exist=false)
    private Set<String> permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账号是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return getDeleted().equals(0);
    }
}
