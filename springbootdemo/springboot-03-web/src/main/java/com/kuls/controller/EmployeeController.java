package com.kuls.controller;

import com.kuls.dao.EmployeeDao;
import com.kuls.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/1 7:59 上午
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.queryAllEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";

    }
}
