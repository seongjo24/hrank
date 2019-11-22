"use strict"; 
var main = main || {};
main=(()=>{
	let _, js, img, css, router_js, bugs_js, cgv_js, naver_js,pop_js
    let init =()=>{
        _ = $.ctx()
        js = $.js()
        img = $.img()
        css = $.css()
        router_js = js +'/cmm/router.js'
        bugs_js = js +'/brd/bugs.js'
        cgv_js = js +'/brd/cgv.js'
        naver_js = js +'/brd/naver.js'
        pop_js=js+'/cmm/pop.js'
    }
	let onCreate=()=>{
		 $.when(
		         $.getScript(router_js),
		         $.getScript(bugs_js),
		         $.getScript(cgv_js),
		         $.getScript(naver_js),
		         $.getScript(pop_js)	
		 ).done(()=>{
		        setContentView()
		 })
	}
	let setContentView=()=>{
	

	$(pop.view()).appendTo('#wrapper')
		pop.open()
		mgmt()

	

	}
	let mgmt=()=>{
		$('<table id="tab"><tr></tr></table>')
		.css({
            width: '80%',
            height: '800px',
            border: '1px solid black',
            margin: '0 auto'
        })
		.appendTo('#wrapper')	
		$('<td/>',{id : 'left'})
		.css({
            width: '20%',
            height: '100%',
            border: '1px solid black',
            'vertical-align': 'top'
        })
		.appendTo('tr')
		$('<td/>',{id : 'right'})
		.css({
            width: '80%',
            height: '100%',
            border: '1px solid black',
            'vertical-align': 'top'
        })
		.appendTo('tr')
		$.each(['naver','cgv','bugs'],(i,j)=>{
			$('<div/>')
			.text(j)
			.css({
				width: '100%',
	            height: '50px',
	            border: '1px solid black',
	            'text-align' : 'center'
			}).appendTo('#left')
			.click(function() {
				$(this).css({'background-color':'#55b2d7'})
				$(this).siblings().css({'background-color':'white'});
			
					switch($(this).text()){
					case 'home' : home()
						break;
					case 'bugs' : bugs.onCreate()
						break;
					case 'cgv' : cgv.onCreate()
						break;
					case 'naver' : naver.onCreate()
						break;
					}
				})
		})
	}



	return {onCreate}
})();
	