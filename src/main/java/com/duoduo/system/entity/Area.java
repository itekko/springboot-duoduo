package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统地区表
 * </p>
 *
 * @author ekko
 * @since 2019-05-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_area")
public class Area extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父主键，当值为0，代表顶级地区
     */
    private Long pid;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 地区编码
     */
    private String code;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 类型,0:全国，1：省，2：城市，3：县，4：镇，5：村
     */
    private Integer type;




}
