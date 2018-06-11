package com.system.email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Util {
	public static String getUUId(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	public static String getdate(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(d);
		
	}
	/**
	 * 这是比较两个字符窜时间的大小
	 */
//	Ixinwen ixw=new IxinwenImpl();
//	List<xinwen> li=ixw.findnews();
//	for(xinwen xw:li){
//		int res=xw.getEnddate().compareTo(Util.getdate());
//		if(res>0){
//			System.out.println("end>xianzai");
//		}else if(res==0){
//			System.out.println("end=xianzai");
//		}else{
//			System.out.println("end<xianzai");
//		}
//		
//	}
}
