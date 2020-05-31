package com.gongj.noproblem.tasks.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 薪资表
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Expenditure对象", description="支出表")
public class Expenditure implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "年")
    private Integer eyear;

    @ApiModelProperty(value = "月")
    private Integer emonth;

    @ApiModelProperty(value = "日")
    private Integer eday;

    @ApiModelProperty(value = "早餐")
    private BigDecimal ebreakfast;

    @ApiModelProperty(value = "午餐")
    private BigDecimal elunch;

    @ApiModelProperty(value = "晚餐")
    private BigDecimal edinner;

    @ApiModelProperty(value = "出行")
    private BigDecimal etravel;

    @ApiModelProperty(value = "穿")
    private BigDecimal ewear;

    @ApiModelProperty(value = "住")
    private BigDecimal elive;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    private String ext1;

    private String ext2;


}
