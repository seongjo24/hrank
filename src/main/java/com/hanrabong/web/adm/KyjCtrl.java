package com.hanrabong.web.adm;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hanrabong.web.pxy.KyjProxy;

@RestController
@RequestMapping("/adm")
public class KyjCtrl {
	@Autowired KyjProxy kyjProxy;

	@GetMapping("/naver")
	public List<?> naver(){
		return kyjProxy.naverWord();
	}
	
	
}