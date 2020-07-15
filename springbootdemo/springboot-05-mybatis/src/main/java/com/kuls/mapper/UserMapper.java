package com.kuls.mapper;

import com.kuls.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/2 8:04 上午
 */
//这个注解表示了这是一个Mybatis的Mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserByID(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);



}
