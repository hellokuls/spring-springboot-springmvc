package com.kuls.service;

import com.kuls.mapper.UserMapper;
import com.kuls.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/6 6:52 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        User kuls1 = userMapper.queryUserByName(name);

        return kuls1;
    }
}
