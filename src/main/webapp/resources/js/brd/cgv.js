"use strict"
var cgv = cgv || {}
cgv = (()=>{
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
		showCgvView()
		
	}
	let showCgvView=()=>{
		$('#right').empty()
		$('</br><h2> cgv 크롤링 </h2> </br>')
		.appendTo('#right')
		$('<div id="scroll" ></div>').appendTo('#right')
		.css({width:'100%',height : '60%','overflow-x':'scroll', 'overflow-y':'scroll'
			})
		
		$.getJSON('/web/admin/cgv', d=>{
			
			for(let i=0;i<d.title.length;i++){
				$('<div><h1>'+d.rank[i]+'</h1></div>')
				.appendTo('#scroll')
				$('<div><img style ="width :200px;" src="'+d.img[i]+'"></div>')
				.appendTo('#scroll')
				$('<div><h2>'+d.title[i]+'</h2></div>')
				.appendTo('#scroll')
			}
			
			
		})
		
		
	}
	return {onCreate}
})()