package com.kuls.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/11 2:18 下午
 */

@ApiModel("user对象")
public class User {

    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;
}
