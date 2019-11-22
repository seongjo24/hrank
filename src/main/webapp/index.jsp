<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <link rel= "stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css" />
	<link rel= "stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/magnific-popup.min.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.min.js" ></script >
	<script src= "https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/jquery.magnific-popup.min.js" ></script >
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="<%=application.getContextPath() %>/resources/js/app.js"></script>
    <script src="<%=application.getContextPath() %>/resources/js/cmm/router.js"></script>
    <script src="<%=application.getContextPath() %>/resources/js/cmm/main.js"></script>
    <script src="<%=application.getContextPath() %>/resources/js/brd/naver.js"></script>
    <script src="<%=application.getContextPath() %>/resources/js/brd/bugs.js"></script>
    <script src="<%=application.getContextPath() %>/resources/js/brd/cgv.js"></script>
       <script src="<%=application.getContextPath() %>/resources/js/cmm/pop.js"></script>
 <body>
<div id='wrapper'></div>
    <script>
        app.run('<%=application.getContextPath() %>');
    </script> 
    </body>
</html>