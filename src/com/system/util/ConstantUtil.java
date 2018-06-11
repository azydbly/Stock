package com.system.util;

import java.util.HashMap;
import java.util.Map;

public class ConstantUtil {

	/**
	 * 项目路径
	 */
	public static String XMPATH;
	
	/**
	 * 服务层域名
	 */
	public static String DOMAIN;
	
	/**
	 * 图片存储服务域名
	 */
	public static String IMGDOMAIN;

	public static String FILEUPLOADSAVEPATH;
	
	/**
	 * Mybatis property转column Map
	 */
	public static final Map<String, Map<String, String>> MYBATISP2CMAP = new HashMap<String, Map<String, String>>();
	
	
	/**
	 * 文件类型键值对
	 */
	public static final Map<String, Integer> FTYPEMAP = initFTypeMap();

	/**
	 * 
	 * 方法名:initFTypeMap
	 * 功能描述:初始化FTYPEMAP
	 *
	 * @author yangtao
	 * @since 2016年8月25日 下午2:25:52
	 *
	 * @return
	 */
	private static Map<String, Integer> initFTypeMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(".jpg", 0);
		map.put(".png", 0);
		map.put(".gif", 0);
		map.put(".ico", 0);
		map.put(".zip", 1);
		map.put(".rar", 1);
		map.put(".doc", 2);
		map.put(".docx", 2);
		map.put(".xls", 3);
		map.put(".xlsx", 3);
		map.put(".ppt", 4);
		map.put(".pptxx", 4);
		map.put(".txt", 5);
		map.put(".mp4", 6);
		map.put(".avi", 6);
		map.put(".rmvb", 6);
		map.put(".mp3", 7);
		map.put(".pdf", 8);
		return map;
	}
}
