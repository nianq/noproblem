package com.gongj.noproblem.mail.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;

/**
 * <p>
 * 邮件
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mail对象", description="")
public class Mail implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "收信人")
    @Email(message="请输入正确收信人的邮箱")
    private String sendTo;

    @ApiModelProperty(value = "抄送人")
    @Email(message="请输入正确抄送人的邮箱")
    private String sendCc;

    @ApiModelProperty(value = "密送人")
    @Email(message="请输入正确密送人的邮箱")
    private String sendBcc;

    @ApiModelProperty(value = "发送人")
    @Email(message="请输入正确发送人的邮箱")
    private String sendFrom;

    @ApiModelProperty(value = "发送内容")
    private String sendContent;

    @ApiModelProperty(value = "标题")
    private String sendSubject;

    @ApiModelProperty(value = "发送时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "0 发送失败 1 发送成功")
    private String sendState;

    @ApiModelProperty(value = "是否html发送")
    private String ishtml;

    private String ext1;

    private String ext2;


}
