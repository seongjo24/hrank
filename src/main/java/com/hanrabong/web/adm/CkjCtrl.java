package com.hanrabong.web.adm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.pxy.CrawlingProxy;
import com.hanrabong.web.pxy.Trunk;

@RestController
@RequestMapping("/ckj")
public class CkjCtrl {
	@Autowired Trunk trunk;
	@Autowired CrawlingProxy crawl;
	

	@GetMapping("/")
	public Map<?,?> cgv(){
		System.out.println("in the cgv");
		Map<String, Object> map = new HashMap<>();
		map.clear();
		map.put("url","http://www.cgv.co.kr/movies/" );
		map.put("node", "strong[class=title]");
		List<String> list = new ArrayList<String>();
		
		list = crawl.crawl(map);
		
		for(int i = 0; i < list.size();i++) {
		
			
		}
		map.clear();
		map.put("title", list);
		return map;
	}

}
