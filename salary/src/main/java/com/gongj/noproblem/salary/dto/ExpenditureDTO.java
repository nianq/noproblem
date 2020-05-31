package com.gongj.noproblem.salary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: noproblem
 * @description: 薪资保存对象
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-29 22:50
 **/
@Data
public class ExpenditureDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private BigDecimal ebreakfast;
    private BigDecimal  elunch;
    private BigDecimal edinner;
    private BigDecimal etravel;
    private BigDecimal ewear;
    private BigDecimal  elive;
}
