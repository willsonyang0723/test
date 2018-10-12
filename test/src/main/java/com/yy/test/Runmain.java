package com.yy.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @project test
 * @author yy
 * @date 2018年10月12日 下午1:49:03
 * @description TODO 普通的main方法
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public class Runmain {

	public static void main(String[] args) {
		
		int[] org = new int[] {6,1,3};
		System.out.println(JSONObject.toJSONString(org));
		org=new MerageSort().meragesort(org);
		System.out.println(JSONObject.toJSONString(org));
	}
}
