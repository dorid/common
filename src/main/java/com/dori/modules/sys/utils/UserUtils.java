/**
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.dori.modules.sys.utils;

import com.dori.common.service.BaseService;
import com.dori.modules.sys.entity.User;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 用户工具类
 * @version 2013-5-29
 */
public class UserUtils extends BaseService {


	public static final String CACHE_USER = "user";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	
	public static User getUser(){

        User user = new User();
        user.setId("123");
        return user;
	}
	
	public static User getUser(boolean isRefresh){
		if (isRefresh){
			removeCache(CACHE_USER);
		}
		return getUser();
	}

	

	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}
	
	public static Map<String, Object> getCacheMap(){
		Map<String, Object> map = Maps.newHashMap();

		return map;
	}
	
}
