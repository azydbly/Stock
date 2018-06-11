package com.system.util;


/**
 * String的拓展类
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

public class StringUtil {
	static final int GB_SP_DIFF = 160;
	static final int[] secPosValueList = { 
		1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787,
		3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086, 
		4390, 4558, 4684, 4925, 5249, 5600
	};
	static final char[] firstLetter = { 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
		'T', 'W', 'X', 'Y', 'Z'
	};
	
	/**
	 * 按照拼音字母排序
	 * @param oriStr 
	 * @return
	 */
	public static String getFirstLetter(String oriStr) { 
		String str = oriStr.toUpperCase(); 
		StringBuffer buffer = new StringBuffer(); 
		char ch;
		char[] temp; 
			ch = str.charAt(0);
			temp = new char[] {ch}; 
			byte[] uniCode = new String(temp).getBytes(); 
			if (uniCode[0] < 128 && uniCode[0] > 0) { 
				buffer.append(temp); 
			} else { 
				
				buffer.append(convert(uniCode)); 
			}

		return buffer.toString(); 
	}
	
	static char convert(byte[] bytes) { 
		char result = '-'; 
		int secPosValue = 0; 
		int i;
		for (i = 0; i < bytes.length; i++) { 
			bytes[i] -= GB_SP_DIFF; 
		}
		secPosValue = bytes[0] * 100 + bytes[1]; 
		for (i = 0; i < 23; i++) {

			if (secPosValue >= secPosValueList[i] && secPosValue < secPosValueList[i + 1]) { 
				result = firstLetter[i]; 
				break;
			}
		}
		return result; 
	}
	
	/**
	 * 获取两条数据相加的值
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static Double add(Double num1, Double num2){
		Double num_1 = num1 == null ? 0.0 : num1;
		Double num_2 = num2 == null ? 0.0 : num2;
		return num_1 + num_2;
	}
	
	/**
	 * 获取两条数据减的值
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static Double min(Double num1, Double num2){
		Double num_1 = num1 == null ? 0.0 : num1;
		Double num_2 = num2 == null ? 0.0 : num2;
		return num_1 - num_2;
	}
	
	/**
	 * 将一个字符串的转换为Double
	 * @param str
	 * @return
	 */
	public static Double stringToDouble(Object str){
		if(str == null || "".equals(str) || "null".equals(str)){
			return 0.0;
		}
		return Double.parseDouble(str.toString());
	}
	
	/**
	 * 判断一个字符串是否为null或者空 返回 true或false
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		return str == null || str.trim().equals("");
	}
	
	/**
	 * 获取数字截取小数点
	 * 如：输入：1232.3333333 输出：1232.33
	 * @param num
	 * @return
	 */
	public static String getIt(Double num){
		BigDecimal  big  =  new BigDecimal(num);  
		String fx  = big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() + ""; 
		return fx;
	}
	
	public static String getIt(Double num, Integer count){
		BigDecimal big = new BigDecimal(num);
		String fx = big.setScale(count, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
		return fx;
	}

	public static String notScience(Double num){
		DecimalFormat df = new DecimalFormat("0.00"); 
		String sn = df.format(num);
		Double  xiaoshu = Double.parseDouble(sn.substring(sn.indexOf(".")));
		if(xiaoshu == 0){
			return sn.substring(0, sn.indexOf("."));
		} else {
			String xiaoshu_str = sn.substring(sn.indexOf("."));
			if(xiaoshu_str.charAt(1) == '0'){
				return sn;
			} else {
				return sn.substring(0, sn.length() - 1);
			}
		}
	}

	public static String notScience(String num){
		if("".equals(num)){
			return "";
		}
		double k = Double.parseDouble(num);
		return notScience(k);
	}

	public static String getIt(String num){
		double k = Double.parseDouble(num);
		return getIt(k);
	}
	
	
	public static String neturlchars(String uir,String unico){
		String str =  "";
		try {
			str=URLEncoder.encode(uir, unico);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 直接截取，无省略号
	 * @param str
	 * @param s
	 * @param e
	 * @return
	 */
	public static String subBy(String str,Integer s,Integer e){
		if(e>str.length()){
			return str;
		}else{
			return str.substring(s,e);	
		}
	}
	
	/**
	 * 倒数截取
	 * @param str
	 * @param n 截掉N尾数
	 * @return
	 */
	public static String subByEnd(String str,Integer n){
		if(n>str.length()){
			return str;
		}else{
			return str.substring(0,str.length()-n);	
		}
	}
	
	/**
	 * 截取后省略号替代
	 * @param str 截取的字符串
	 * @param s 截取的开始位置
	 * @param e 重开始位置截取的个数
	 * @return
	 */
	public static String subCont(String str,Integer s,Integer e){
		if(str == null || "".equals(str)) return "";
		String result = "";
	    int temp = 0;
	    str = str.substring(s,str.length());
        for (int i = 0; i < str.length(); i++) {
        	String ts = str.substring(i,i+1);
        	if(ts.getBytes().length != ts.length()) {//全角 
        		temp += 2;//如果是全角，占用两个字节
        	} else {
        		temp += 1;//半角占用一个字节
        	}
            if(temp <= e*2) {
            	result += ts;
            } else {
            	result += "...";
            	break;
            }
	     } 
        return result;
	}
	
	/**
	 * 根据传入的时间比对过去的多久
	 * @param time 时间格式字符串
	 * @param format 格式化
	 * @return
	 */
	public static String conversionTime(String time, String format){
		String show = "";
		String oldFormat = "";
		if(time.length()<=11){
			if(time.indexOf("-")>-1){
				oldFormat = "yyyy-MM-dd";
			}else if(time.indexOf("/")>-1){
				oldFormat = "yyyy/MM/dd";
			}else{
				oldFormat = "yyyy年MM月dd日";
			}
		}else {
			if(time.indexOf("-")>-1){
				oldFormat = "yyyy-MM-dd HH:mm:ss";
			}else if(time.indexOf("/")>-1){
				oldFormat = "yyyy/MM/dd HH:mm:ss";
			}else{
				oldFormat = "yyyy年MM月dd日 HH:mm:ss";
			}
		}
		try {
			long nowTime = new Date().getTime();
			SimpleDateFormat df = new SimpleDateFormat(oldFormat);
			long oldtime = df.parse(time).getTime();
			long parse = nowTime - oldtime;
			if(parse < (60*1000)){
				show = "刚刚";
			}else if (parse< 60*60*1000){//判断是否大于1给小时
				show = parse/(60*1000)+"分钟前";
			}else if(parse< 12*60*60*1000) {
				show = parse/(60*60*1000)+"小时前";
			}else{
				show = time;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		
		return show;
	}
	
	/**
	 * 拓展List<String>的jion方法
	 * @param join
	 * @param strAry
	 * @author yangtao
	 * @return
	 */
	public static String join(String join,ArrayList<String> strAry){
		int size = strAry.size();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<size;i++){
             if(i==(size-1)){
                 sb.append(strAry.get(i));
             }else{
                 sb.append(strAry.get(i)).append(join);
             }
        }
        
        return sb.toString();
    }
	
	/**
	 * 
	 * 方法名：StringToList 
	 * 功能描述: 字符串转List
	 *
	 * @author yangtao
	 * @since 2016年9月1日 上午9:12:21
	 *
	 * @param entityId
	 * @param guids
	 * @return
	 */
	public static List<String> StringToList(String guids, String splitChar) {
		try {
			if (!StringUtils.isEmpty(guids)) {
				if (guids.indexOf(splitChar) > 0) {

					while (guids.charAt(0) == ',') {
						guids = guids.substring(1);
					}
					while (guids.charAt(guids.length() - 1) == ',') {
						guids = guids.substring(0, guids.length() - 1);
					}

					return StringToListHandler(guids, splitChar);
				} else {
					return Arrays.asList(new String[] { guids });
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<String> StringToListHandler(String guids, String splitChar){
		List<String> list = new ArrayList<String>();
		String[] guidArray = guids.split(splitChar);
		for (String guid : guidArray) {
			if (!StringUtils.isEmpty(guid)) {
				list.add(guid);
			}
		}
		return list;
	}
}
