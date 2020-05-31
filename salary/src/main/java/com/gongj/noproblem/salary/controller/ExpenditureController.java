package com.gongj.noproblem.salary.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gongj.noproblem.commonsutils.ResultVo;
import com.gongj.noproblem.salary.dto.ExpenditureDTO;
import com.gongj.noproblem.salary.dto.ExpenditureDTO;
import com.gongj.noproblem.salary.entity.Expenditure;
import com.gongj.noproblem.salary.query.ExpenditureQuery;
import com.gongj.noproblem.salary.service.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  支出控制器
 * </p>
 *
 * @author gongj
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/api/expenditure")
@CrossOrigin
public class ExpenditureController {

    @Autowired
    ExpenditureService expenditureService;

    /**
     * @Description 获得年和月份
     * @param
     * @Author gongj
     * @Date 2020/5/29 18:24
     **/
    @GetMapping("/getYearAndMonth")
    public ResultVo getYearAndMonth(){

        Map<Integer,List<Expenditure>> list = expenditureService.getYearAndMonth();
        return ResultVo.ok().data("list",list);

    }
    /**
     * @Description 根据条件查询并分页
     * @param
     * @Author gongj
     * @Date 2020/5/28 21:45
     **/
    @PostMapping("/getExpenditurePage")
    public ResultVo getSalaryPage(@RequestBody ExpenditureQuery expenditureQuery) {
        Page<Expenditure> expenditurePage = new Page<>(expenditureQuery.getCurrentPage(), expenditureQuery.getPageSize());
        IPage<Expenditure> list = expenditureService.getExpenditurePage(expenditureQuery,expenditurePage);
        long total = list.getTotal();
        List<Expenditure> records = list.getRecords();
        return ResultVo.ok().data("total",total).data("list",records);
    }

    /**
     * @Description 根据id查询
     * @param id
     * @Author gongj
     * @Date 2020/5/28 21:46
     **/
    @GetMapping("getExpenditure/{id}")
    public ResultVo getExpenditure(@PathVariable Long id){
        Expenditure expenditure = expenditureService.getById(id);
        return ResultVo.ok().data("row",expenditure);
    }

    /**
     * @Description 保存支出
     * @param expenditureDTO
     * @Author gongj
     * @Date 2020/5/28 19:34
     **/
    @PostMapping("/saveExpenditure")
    public ResultVo saveSalary(@RequestBody ExpenditureDTO expenditureDTO){

        boolean save = expenditureService.saveExpenditure(expenditureDTO);
        if (save) {
            return ResultVo.ok();
        }
        return ResultVo.error();
    }
    /**
     * @Description 修改支出
     * @param expenditure
     * @Author gongj
     * @Date 2020/5/28 21:50
     **/
    @PostMapping("/updateExpenditure")
    public ResultVo updateSalary(@RequestBody Expenditure expenditure){
        boolean b = expenditureService.updateById(expenditure);
        if(b){
            return ResultVo.ok();
        }
        return ResultVo.error();
    }
}

