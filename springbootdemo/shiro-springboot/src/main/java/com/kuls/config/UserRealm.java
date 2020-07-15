package com.kuls.config;

import com.kuls.pojo.User;
import com.kuls.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/4 11:21 上午
 */
//自定义realm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权doGetAuthorizationInfo");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到登录对象
        Subject subject = SecurityUtils.getSubject();
        //这个user对象是从下面doGetAuthenticationInfo中拿到的
        User currentUser = (User) subject.getPrincipal();

        //设置当前用户权限
        info.addStringPermission(currentUser.getPerm());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证doGetAuthenticationInfo");
        //账号密码从数据库中取


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //验证用户
        User user = userService.queryUserByName(token.getUsername());
        if (user==null){
            return null;
        }

        Subject currentsubject = SecurityUtils.getSubject();
        Session session = currentsubject.getSession();
        session.setAttribute("loginUser",user);
        //密码可加密，MD5加密，MD5盐值加密
        //密码认证，shiro自动处理
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
