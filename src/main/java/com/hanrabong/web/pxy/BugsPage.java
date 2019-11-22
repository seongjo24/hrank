
package com.hanrabong.web.pxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data @Component @Lazy
public class BugsPage {
	@Autowired Crawling crawling;
	
	private int pagenum,pagesize,startrow,pageCount,totalCount,blocksize;
	private Boolean first,end;
	private final int Block_SIZE=4;
	private String search;
	public List<Integer>getList(HashMap<String, String> paramMap) {
		List<Integer> list = new ArrayList<Integer>();
		int blocknum=1;
		setPagenum(Integer.parseInt(paramMap.get("pageNo")));
		setPagesize(Integer.parseInt(paramMap.get("pageSize")));
		first =true;
		end=true;
		 startrow =pagesize*(pagenum-1);
		blocksize=4;
		totalCount=100;
		pageCount=(totalCount%pagesize==0) ? totalCount/pagesize : (totalCount/pagesize)+1;
		switch(pagenum%Block_SIZE) {
		case 1:
			blocknum=pagenum;
			 break;
		case 0:
			blocknum=pagenum-(Block_SIZE-1);
			break;
		default:
			blocknum=pagenum-(pagenum%Block_SIZE-1);
			break;
		}
		if(blocknum==1) {
			first=false;
		}
		
		for(int i=blocknum;i<=blocknum+Block_SIZE-1;i++) {
			if(i<=pageCount) {
			list.add(i);
			}else {
				end=false;
				break;
			}
			}
		System.out.println(list);
		return list;
	}
	public void paging(HashMap<String, String> paramMap) {
	pagenum=Integer.parseInt(paramMap.get("pageNo"));
	pagesize=Integer.parseInt(paramMap.get("pageSize"));
	
	}
	
	
	
}