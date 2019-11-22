"use strict"
var paging = paging ||{}
paging = (()=>{
	let _, js, css
	let init =()=>{
		_ = $.ctx()
		js = $.js()
	}
	let onCreate =()=>{
		init()
		setContentview()
	}
	let setContentview =()=>{
		
	}
	return {onCreate}
})()