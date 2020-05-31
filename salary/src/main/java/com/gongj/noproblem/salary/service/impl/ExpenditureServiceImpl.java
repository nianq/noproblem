package com.gongj.noproblem.salary.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gongj.noproblem.salary.dto.ExpenditureDTO;
import com.gongj.noproblem.salary.entity.Expenditure;
import com.gongj.noproblem.salary.mapper.ExpenditureMapper;
import com.gongj.noproblem.salary.query.ExpenditureQuery;
import com.gongj.noproblem.salary.service.ExpenditureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪资表 服务实现类
 * </p>
 *
 * @author gongj
 * @since 2020-05-30
 */
@Service
public class ExpenditureServiceImpl extends ServiceImpl<ExpenditureMapper, Expenditure> implements ExpenditureService {

    @Override
    public Map<Integer, List<Expenditure>> getYearAndMonth() {
        HashMap<Integer, List<Expenditure>> map = new HashMap<>();
        QueryWrapper<Expenditure> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT eyear");
        List<Expenditure> list = this.baseMapper.selectList(queryWrapper);

        if(list!=null && !list.isEmpty()){
            for (Expenditure salary : list) {
                QueryWrapper<Expenditure> monthqueryWrapper = new QueryWrapper<>();
                monthqueryWrapper.select("DISTINCT eyear","emonth");
                monthqueryWrapper.eq("eyear",salary.getEyear());
                List<Expenditure> selectList = this.baseMapper.selectList(monthqueryWrapper);
                map.put(salary.getEyear(),selectList);
            }
        }
        return map;
    }

    @Override
    public IPage<Expenditure> getExpenditurePage(ExpenditureQuery expenditureQuery, Page<Expenditure> salaryPage) {
        QueryWrapper<Expenditure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("eyear",expenditureQuery.getYear());
        queryWrapper.eq("emonth",expenditureQuery.getMonth());
        IPage<Expenditure> salaryIPage = this.baseMapper.selectPage(salaryPage, queryWrapper);
        return salaryIPage;
    }

    @Override
    public boolean saveExpenditure(ExpenditureDTO dxpenditureDTO) {
        Date time = dxpenditureDTO.getTime();
        int year = DateUtil.year(time);
        int month = DateUtil.month(time);
        int day = DateUtil.dayOfMonth(time);
        Expenditure expenditure = new Expenditure();
        BeanUtils.copyProperties(dxpenditureDTO,expenditure);
        expenditure.setEyear(year);
        expenditure.setEmonth(month + 1);
        expenditure.setEday(day);
        return  baseMapper.insert(expenditure) > 0 ? true: false;
    }
}
