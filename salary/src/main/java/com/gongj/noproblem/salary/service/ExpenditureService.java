package com.gongj.noproblem.salary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gongj.noproblem.salary.dto.ExpenditureDTO;
import com.gongj.noproblem.salary.entity.Expenditure;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gongj.noproblem.salary.query.ExpenditureQuery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪资表 服务类
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
public interface ExpenditureService extends IService<Expenditure> {

    Map<Integer, List<Expenditure>> getYearAndMonth();

    IPage<Expenditure> getExpenditurePage(ExpenditureQuery expenditureQuery, Page<Expenditure> expenditurePage);

    boolean saveExpenditure(ExpenditureDTO expenditureDTO);
}
