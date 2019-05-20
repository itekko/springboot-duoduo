package com.duoduo.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author lixiaolong
 * @create 2019-05-08 14:07
 */
@Data
@Accessors(chain = true)
public class BaseEntity  {

    /**
     * 主键
     */
    private Long id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态,参考字典（t_system_dictionary）
     */
    private Long status;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 删除，0：正常，1：已删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
