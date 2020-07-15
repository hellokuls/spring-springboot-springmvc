package com.kuls.dao;

import com.kuls.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/31 1:32 下午
 */
@Repository
public class DepartmentDao {

    //模拟数据库中的数据

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"后勤部"));
    }
    //获得所以部门信息；
    public Collection<Department> getAllDepartment(){
        return departments.values();
    }

    //根据id查询信息；
    public Department getDepartment(Integer id){
        return departments.get(id);
    }








}
