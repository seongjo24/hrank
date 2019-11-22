package com.hanrabong.web.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.pxy.BugsPage;
import com.hanrabong.web.pxy.Crawling;

@RestController
@RequestMapping("/admin")
public class KsjCtrl {
@Autowired Crawling crawling;
@Autowired BugsPage bugspage;

	@GetMapping("/bugs/{time}/{pageNo}/{pageSize}")
	public Map<?,?> bugs(@PathVariable String pageNo, @PathVariable String pageSize,@PathVariable String time){
		System.out.println(pageNo +pageSize+time);
		HashMap<String, Object>map=new HashMap<>();
		HashMap<String, String> paramMap=new HashMap<>();
		paramMap.put("pageNo",pageNo);
		paramMap.put("time",time);
		paramMap.put("pageSize",pageSize);
		map.put("crawl",crawling.bugsCrawling(time));
		map.put("pages",bugspage.getList(paramMap));
		map.put("pxy",bugspage);
		return map;
	}
	@GetMapping("/cgv")
	public Map<?,?>cgv(){

		return crawling.cgvCrawling();
	}
	}
