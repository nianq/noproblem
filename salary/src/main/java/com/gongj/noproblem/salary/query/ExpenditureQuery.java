package com.gongj.noproblem.salary.query;

import lombok.Data;

/**
 * @program: noproblem
 * @description: 薪资查询对象
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-29 19:00
 **/
@Data
public class ExpenditureQuery {
    private Integer year;
    private Integer month;
    private Integer pageSize;
    private Integer currentPage;
}
