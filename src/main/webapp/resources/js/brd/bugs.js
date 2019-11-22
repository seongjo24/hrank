"use strict"
var bugs = bugs ||{}
bugs = (()=>{
	let _, js, css,pagevue
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		pagevue=js+'/vue/page_vue.js'
	}
	let onCreate =()=>{
		init()
		setContentview()
		$.getScript(pagevue)
	}
	
	let setContentview =()=>{
		bugsCrawler()
	}
	
	let bugsCrawler=()=>{
		$('#right').empty()
		$(    '<h1>Bugs</h1><br>'+
				'<form class="form-inline my-2 my-lg-0" action="/action_page.php">'+
				'  <select id ="webs"name="site" size="1" >'+
				'  </select>'+
				'  <select id ="pagesize"name="site" size="1" >'+
				'  </select>'+
				'  <br><br>'+
			   '<button id="bugsbtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">크롤링 go</button>'+
				'</form>')
				.appendTo('#right')
		$('<div id="scroll" ></div>').appendTo('#right')
		.css({width:'80%',height : '100%','overflow-x':'scroll', 'overflow-y':'scroll'
			})
		let arr=[{value:'00' ,text:'0:00'},{value:'01' ,text:'1:00'},{value:'07' ,text:'7:00'},{value:'09' ,text:'9:00'}]
		let arr2=[{value:'4' ,text:'4'},{value:'8' ,text:'8'},{value:'12' ,text:'12'}]
	
		$.each(arr2,(i,j)=>{
			
		$('<option value="'+j.value+'">'+j.text+'</option>').appendTo('#pagesize')
		})
		$.each(arr,(i,j)=>{
		
	$('<option value="'+j.value+'">'+j.text+'</option>').appendTo('#webs')
	})
	$('#bugsbtn').click(e=>{
		e.preventDefault()
		
		scroll({page:'1',size:$('#pagesize option:selected').val()})
			

		
	})
	}
	let scroll =x=>{
		$('#scroll').empty()
		$.getJSON('/web/admin/bugs/'+$('#webs').val()+'/'+x.page+'/'+x.size,d =>{
			let imglist = d.crawl.img
			let titlelist = d.crawl.title
			for(let i=d.pxy.startrow;i<=d.pxy.startrow+d.pxy.pagesize-1;i++ ){
				if(i<=99){
				$('<div><'+d.crawl.rank[i]+'></div></br>').css({width:'100%','text-align' : 'center'}).appendTo('#scroll')
				$('<div><img  src="'+imglist[i]+'"></div>').css({width:'100%',height:'10%','text-align' : 'center'}).appendTo('#scroll')
				$('<div>'+d.crawl.title[i]+' </br>'+d.crawl.artist[i]+'</br>'+d.crawl.album[i]+'</div>').appendTo('#scroll').css({width:'100%',height:'30%','text-align' : 'center'})
				}
			}
			$(page_vue.pagenation()).appendTo('#scroll')
			pagenation(d)
		})
	}
	let pagenation=d=>{
		
		$.when($('#pagenation1').empty()).done(	$.each(d.pages,(i,k)=>{
	
			if(i===0){
				if(d.pxy.first){
				$('<li class="page-item"><a class="page-link" href="#">previous</a></li>')
				.appendTo('#pagenation1')
				.click(e=>{
					scroll({page:k-d.pxy.blocksize,size:d.pxy.pagesize})
				})
				}
				$('<li class="page-item"><a id="page'+k+'" class="page-link" href="#">'+k+'</a></li>')
				.appendTo('#pagenation1')
				.click(()=>{scroll({page:k,size:d.pxy.pagesize})})
				
			}else if((i+1)===d.pages.length){
				$('<li class="page-item"><a id="page'+k+'" class="page-link" href="#">'+k+'</a></li>')
				.appendTo('#pagenation1')
				.click(()=>{scroll({page:k,size:d.pxy.pagesize})})
				if(d.pxy.end)
				$('<li class="page-item"><a class="page-link" href="#">next</a></li>')
				.appendTo('#pagenation1')
				.click(e=>{
					scroll({page:k+1,size:d.pxy.pagesize})
				
				})
			}else if(0<i<d.pages.length){
				$('<li class="page-item"><a id="page'+k+'" class="page-link" href="#">'+k+'</a></li>')
				.appendTo('#pagenation1')
				.click(e=>{scroll({page:k,size:d.pxy.pagesize})})
			}
			}))
			
	}
	return {onCreate}
})()