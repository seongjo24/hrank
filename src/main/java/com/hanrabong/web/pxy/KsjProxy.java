package com.hanrabong.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("ksj")
public class KsjProxy {
	@Autowired CrawlingProxy crawl;

}
