package com.duoduo.system.entity;

import com.duoduo.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统组织表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_organization")
@ApiModel(value="Organization对象", description="系统组织表")
public class Organization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父主键，当值为0，代表顶级组织")
    private Long pid;

    @ApiModelProperty(value = "组织名称")
    private String name;

    @ApiModelProperty(value = "组织编码")
    private String code;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "类型")
    private Integer type;


}
