package com.atguigu.jf.console.login.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.jf.console.login.service.LoginService;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private LoginService loginService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("----回调了----doGetAuthenticationInfo----方法------");
		
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		// getPrincipal方法获取到用户名
		Object principal = uptoken.getPrincipal();
		
		// 查询数据库，通过principal获取用户的密码
		String credentials = loginService.getCredentialsByUserName((String)principal);
		/**
		 * principal:用户的信息，可以是用户实体信息，包含用户所有的信息
		 * credentials：密码
		 * realmName:固定写法getName()
		 */
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, getName());
		
		return info;
	}

}
