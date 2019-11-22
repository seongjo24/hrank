package com.hanrabong.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingProxy {
	public List<String> crawl(Map<?,?> paramMap) {
		List<String> artist2 = new ArrayList<>();
		try {
		Document rawData = Jsoup.connect((String) paramMap.get("url")).timeout(10*1000).get();
		Elements artist = rawData.select((String) paramMap.get("node"));
		for(Element e : artist) {
		artist2.add(e.text());
		}
		System.out.println(artist2);
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		return artist2;
		}
}
