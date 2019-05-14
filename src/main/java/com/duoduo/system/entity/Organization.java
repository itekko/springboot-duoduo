package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统组织表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_organization")
public class Organization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父主键，当值为0，代表顶级组织
     */
    private Long pid;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织编码
     */
    private String code;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 类型
     */
    private Integer type;



}
