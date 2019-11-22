"use strict"
var naver = naver || {}
naver = (()=>{
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
		$('#right').empty()
		$('<div id="scroll" ></div>').appendTo('#right')
		$("<h3 class='section_title'>Today words</h3>")
		.appendTo('#scroll')
		$.getJSON(_+'/adm/naver', d=>{

			for(let i=0 ; i<d[0].length;i++){
			$('<div/>')
			.css({width:'40%',
				height:'30%',
			})
			.html('<h4>'+d[0][i]+'<h4>'+'<h3>'+d[1][i]+'</h3>')
			.appendTo('#scroll')
			}

			
   			
			
   		})
	}
	return {onCreate}
})()