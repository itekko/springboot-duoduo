package com.duoduo.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lixiaolong
 * @create 2019-05-08 14:07
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 状态,参考字典（t_system_dictionary）
     */
    @ApiModelProperty("状态,参考字典（t_system_dictionary)")
    private Long status;

    /**
     * 乐观锁
     */
    @Version
    @ApiModelProperty("乐观锁")
    private Integer version;

    /**
     * 删除，0：正常，1：已删除
     */
    @TableLogic
    @ApiModelProperty("删除，0：正常，1：已删除")
    private Integer deleted;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Long createBy;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private Long updateBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("当前页")
    @TableField(exist = false)
    private Integer current;

    @ApiModelProperty("页数，默认20")
    @TableField(exist = false)
    private Integer size = 20;
}
