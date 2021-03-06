package cn.dev33.satoken.stp;

import cn.dev33.satoken.session.SaSession;

/**
 * 一个默认的实现 
 * @author kong 
 */
public class StpUtil {

	/**
	 * 底层的 StpLogic 对象  
	 */
	public static StpLogic stpLogic = new StpLogic("login"); 
	
	
	// =================== 获取token 相关 ===================

	/**
	 * 返回token名称 
	 * @return 此StpLogic的token名称
	 */
	public static String getTokenName() {
 		return stpLogic.getTokenName();
 	}

	/**
	 *  获取当前tokenValue
	 * @return 当前tokenValue
	 */
	public static String getTokenValue() {
		return stpLogic.getTokenValue();
	}

	/** 
	 * 获取指定loginId的tokenValue 
	 * @param loginId  .
	 * @return .
	 */
	public static String getTokenValueByLoginId(Object loginId) {
		return stpLogic.getTokenValueByLoginId(loginId);
	}
	
	/**
	 * 获取当前StpLogin的loginKey 
	 * @return 当前StpLogin的loginKey
	 */
	public static String getLoginKey(){
		return stpLogic.getLoginKey();
	}
	
	/**
	 * 获取当前会话的token信息 
	 * @return token信息 
	 */
	public static SaTokenInfo getTokenInfo() {
		return stpLogic.getTokenInfo();
	}

	// =================== 登录相关操作 ===================

	/**
	 * 在当前会话上登录id 
	 * @param loginId 登录id ，建议的类型：（long | int | String）
	 */
	public static void setLoginId(Object loginId) {
		stpLogic.setLoginId(loginId);
	}

	/** 
	 * 当前会话注销登录
	 */
	public static void logout() {
		stpLogic.logout();
	}

	/**
	 * 指定loginId的会话注销登录（正常注销下线）
	 * @param loginId 账号id 
	 */
	public static void logoutByLoginId(Object loginId) {
		stpLogic.logoutByLoginId(loginId);
	}

	/**
	 * 指定loginId的会话注销登录（踢人下线）
	 * @param loginId 账号id 
	 */
	public static void kickoutByLoginId(Object loginId) {
		stpLogic.kickoutByLoginId(loginId);
	}
	
	// 查询相关

	/** 
 	 * 获取当前会话是否已经登录
 	 * @return 是否已登录 
 	 */
	public static boolean isLogin() {
		return stpLogic.isLogin();
	}

	/**
	 * 检验当前会话是否已经登录，如未登录，则抛出异常
 	 */
 	public static void checkLogin() {
 		getLoginId();
 	}
	
	/** 
 	 * 获取当前会话登录id, 如果未登录，则抛出异常
 	 * @return .
 	 */
	public static Object getLoginId() {
		return stpLogic.getLoginId();
	}

	/** 
	 * 获取当前会话登录id, 如果未登录，则返回默认值
	 * @param <T> 返回类型 
	 * @param defaultValue 默认值
	 * @return 登录id 
	 */
	public static <T> T getLoginId(T defaultValue) {
		return stpLogic.getLoginId(defaultValue);
	}
	
	/** 
	 * 获取当前会话登录id, 如果未登录，则返回null
	 * @return .
	 */
	public static Object getLoginIdDefaultNull() {
		return stpLogic.getLoginIdDefaultNull();
 	}

	/** 
	 * 获取当前会话登录id, 并转换为String
	 * @return 登录id
	 */
	public static String getLoginIdAsString() {
		return stpLogic.getLoginIdAsString();
	}

	/** 
	 * 获取当前会话登录id, 并转换为int
	 * @return 登录id
	 */
	public static int getLoginIdAsInt() {
		return stpLogic.getLoginIdAsInt();
	}

	/**
	 * 获取当前会话登录id, 并转换为long
	 * @return 登录id
	 */
	public static long getLoginIdAsLong() {
		return stpLogic.getLoginIdAsLong();
	}

 	/** 
 	 * 获取指定token对应的登录id，如果未登录，则返回 null 
 	 * @param tokenValue token
 	 * @return 登录id
 	 */
 	public static Object getLoginIdByToken(String tokenValue) {
 		return stpLogic.getLoginIdByToken(tokenValue);
 	}
	
 	
	// =================== session相关 ===================

	/** 
	 * 获取指定loginId的session, 如果没有，isCreate=是否新建并返回
	 * @param loginId 登录id
	 * @param isCreate 是否新建
	 * @return SaSession
	 */
	public static SaSession getSessionByLoginId(Object loginId, boolean isCreate) {
		return stpLogic.getSessionByLoginId(loginId, isCreate);
	}

	/** 
	 * 获取指定loginId的session
	 * @param loginId .
	 * @return .
	 */
	public static SaSession getSessionByLoginId(Object loginId) {
		return stpLogic.getSessionByLoginId(loginId);
	}
	
	/** 
	 * 获取当前会话的session, 如果没有，isCreate=是否新建并返回 
	 * @param isCreate 是否新建
	 * @return 当前会话的session 
	 */
	public static SaSession getSession(boolean isCreate) {
		return stpLogic.getSession(isCreate);
	}
	
	/** 
	 * 获取当前会话的session
	 * @return .
	 */
	public static SaSession getSession() {
		return stpLogic.getSession();
	}


	// =================== [临时过期] 验证相关 ===================  

 	/**
 	 * 检查当前token 是否已经[临时过期]，如果已经过期则抛出异常  
 	 */
 	public static void checkActivityTimeout() {
 		stpLogic.checkActivityTimeout();
 	}

 	/**
 	 * 续签当前token：(将 [最后操作时间] 更新为当前时间戳) 
 	 * <h1>请注意: 即时token已经 [临时过期] 也可续签成功，
 	 * 如果此场景下需要提示续签失败，可在此之前调用 checkActivityTimeout() 强制检查是否过期即可 </h1>
 	 */
 	public static void updateLastActivityToNow() {
 		stpLogic.updateLastActivityToNow();
 	}
 	

	// =================== 过期时间相关 ===================  

 	/**
 	 * 获取当前登录者的token剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getTimeout() {
 		return stpLogic.getTokenTimeout();
 	}
 	
 	/**
 	 * 获取指定loginId的token剩余有效时间 (单位: 秒) 
 	 * @param loginId 指定loginId 
 	 * @return token剩余有效时间 
 	 */
 	public static long getTimeoutByLoginId(Object loginId) {
 		return stpLogic.getTokenTimeoutByLoginId(loginId);
 	}

 	/**
 	 * 获取当前登录者的Session剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getSessionTimeout() {
 		return stpLogic.getSessionTimeout();
 	}
 	
 	/**
 	 * 获取指定loginId的Session剩余有效时间 (单位: 秒) 
 	 * @param loginId 指定loginId 
 	 * @return token剩余有效时间 
 	 */
 	public static long getSessionTimeoutByLoginId(Object loginId) {
 		return stpLogic.getSessionTimeoutByLoginId(loginId);
 	}
 	
 	/**
 	 * 获取当前token[临时过期]剩余有效时间 (单位: 秒)
 	 * @return token[临时过期]剩余有效时间
 	 */
 	public static long getTokenActivityTimeout() {
 		return stpLogic.getTokenActivityTimeout();
 	}
 	
 	/**
 	 * 获取指定token[临时过期]剩余有效时间 (单位: 秒)
 	 * @param tokenValue 指定token 
 	 * @return token[临时过期]剩余有效时间
 	 */
 	public static long getTokenActivityTimeoutByToken(String tokenValue) {
 		return stpLogic.getTokenActivityTimeoutByToken(tokenValue);
 	}
 	
 	
	
	// =================== 权限验证操作 ===================

	/** 
 	 * 指定loginId是否含有指定权限
 	 * @param loginId .
 	 * @param pcode .
 	 * @return .
 	 */
	public static boolean hasPermission(Object loginId, Object pcode) {
		return stpLogic.hasPermission(loginId, pcode);
	}

	/** 
 	 * 当前会话是否含有指定权限
 	 * @param pcode .
 	 * @return .
 	 */
	public static boolean hasPermission(Object pcode) {
		return stpLogic.hasPermission(pcode);
	}

	/** 
 	 * 当前账号是否含有指定权限 ， 没有就抛出异常
 	 * @param pcode .
 	 */
	public static void checkPermission(Object pcode) {
		stpLogic.checkPermission(pcode);
	}

	/** 
 	 * 当前账号是否含有指定权限 ， 【指定多个，必须全都有】
 	 * @param pcodeArray .
 	 */
	public static void checkPermissionAnd(Object... pcodeArray) {
		stpLogic.checkPermissionAnd(pcodeArray);
	}

	/** 
 	 * 当前账号是否含有指定权限 ， 【指定多个，有一个就可以了】
 	 * @param pcodeArray .
 	 */
	public static void checkPermissionOr(Object... pcodeArray) {
		stpLogic.checkPermissionOr(pcodeArray);
	}


}
