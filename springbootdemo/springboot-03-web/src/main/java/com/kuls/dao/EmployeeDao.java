package com.kuls.dao;

import com.kuls.pojo.Department;
import com.kuls.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/31 1:39 下午
 */
@Repository
public class EmployeeDao {

    //模拟数据库中的数据

    private static Map<Integer, Employee> employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(101,new Employee(1001,"aaa","a1839938674@qq.com",1,new Department(101,"后勤部"),new Date()));
        employees.put(102,new Employee(1002,"bbb","b1839938674@qq.com",1,new Department(101,"教研部"),new Date()));
        employees.put(103,new Employee(1003,"ccc","c1839938674@qq.com",0,new Department(101,"教学部"),new Date()));
        employees.put(104,new Employee(1004,"ddd","d1839938674@qq.com",1,new Department(101,"市场部"),new Date()));
        employees.put(105,new Employee(1005,"eee","e1839938674@qq.com",1,new Department(101,"教研部"),new Date()));

    }


    private static Integer id = 1006;
    //增加员工
    public void add(Employee employee){

        if (employee.getId() == null){
            employee.setId(id++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);

    }


    //查询所有员工
    public Collection<Employee> queryAllEmployee(){

        return employees.values();

    }

    //通过id查询员工
    public Employee queryEmployeeById(Integer id){
        return employees.get(id);
    }


    //删除员工
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
