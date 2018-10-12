package com.yy.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @project test
 * @author yy
 * @date 2018年10月12日 下午1:49:35
 * @description TODO 并归排序
 * @tag 
 * @company 上海金互行金融信息服务有限公司
 */
public class MerageSort {

	
	public int[] meragesort(int[] org) {
		/*****  分解 ****/
		
		int n = 0;//有序集合中数量
		int j = 0;//纵向并归序列
		while(n<org.length) {//需要排序
			
			n=(int)(Math.pow(2, j));//计算当前集合中的数量
			for (int i = 0; i < org.length; i+=n*2) {
				org=merage(org, i, i+n);
			}
			j++;//纵向并归次数+1
			
		}
		return org;
	}
	

	/**
	 * @title merage 
	 * @description 归并操作
	 * @author yy
	 * @date 2018年10月12日 下午2:18:34
	 * @param org
	 * @return
	 * @return int[]
	 */
	private int[] merage(int[] org,int start,int end) {
		if(end>=org.length-1)//无需排序
			return org;
		System.out.println("start:"+start+",end:"+end);
		int resultsize = end + (end - start) > org.length ? org.length - start : (end - start) * 2;//最大长度 和 传入的范围长度做比较，取小值
		int[] result= new int[resultsize];//当前排好序的结果
		
		int k = 0;//处理排序数列下标
		int sk=-1;//哨兵
		int si=-1;//第一个数组的end标识
		int lastnum = end+(end-start)>org.length? org.length : end+(end-start);
		for (int i = 0; i < end-start; i++) {
			
			//已经提前匹配完第二个数组
			if(sk>=lastnum) {
				System.arraycopy(org, si, result, resultsize-(end-si) , end-si);
				break;
			}
			
			//和后一个数组比对 从上一次没有对比过的 开始对比
			for (int j = sk==-1?end:sk; j < lastnum; j++) {
				if(org[start+i]<org[j]) {//找到最小值
					result[k]=org[start+i];k++;sk=j;break;
				}else {
					if(sk==lastnum-1)//已经触碰到最大，则记录第一个数组的最大哨兵值
						si=i;
					result[k]=org[j];sk=j+1;k++;
					
				}
			}
			
		}
		
		// 哨兵还没有排到最后一只 将哨兵之后的数组追加至排序数组
		System.out.println("哨兵：：："+sk);
		if(sk!=-1 && sk<lastnum-1) {
			System.arraycopy(org, sk, result, k, resultsize-k);
		}else{//到了最后一只，则有两种情况 有可能 第二个数组或 第一个数组 最后一个没有放进排序队列，进行相互比较并放入最大的
			if(org[end-1]>org[lastnum-1])
				result[resultsize-1]=org[end-1];
			else
				result[resultsize-1]=org[lastnum-1];
		}
		
		
		System.arraycopy(result, 0, org, start, result.length);//合并至原数组列
		System.out.println(JSONObject.toJSONString(org));
		return org;
	}
	
	
}
