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
 * 系统地区表
 * </p>
 *
 * @author ekko
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_system_area")
@ApiModel(value="Area对象", description="系统地区表")
public class Area extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父主键，当值为0，代表顶级地区")
    private Long pid;

    @ApiModelProperty(value = "地区名称")
    private String name;

    @ApiModelProperty(value = "地区编码")
    private String code;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "类型,0:全国，1：省，2：城市，3：县，4：镇，5：村")
    private Integer type;


}
