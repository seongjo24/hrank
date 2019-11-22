package com.hanrabong.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ckj")
public class CkjProxy {
	@Autowired CrawlingProxy crawl;

}
