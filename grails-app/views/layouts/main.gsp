<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <r:script disposition="head">
            var URL_ROOT = '${request.contextPath}';
        </r:script>
        
		<r:require modules="application, css, wysiwyg"/>
        <r:layoutResources/>

		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

        
		<g:layoutHead/>
		
		<script language="javascript">
			$(function() {
		    	$( document ).tooltip();
		    });
		</script>
		
	</head>
	<body data-spy="scroll" data-target=".nav-spy">
			<g:render template="/utils/menubar"/>		
			<div class="container">
			     <g:layoutBody/>
			</div>
			<div class="footer" role="contentinfo"></div>
			<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	        <r:layoutResources />
	        <g:render template="/utils/gaTracking"/>
	</body>
</html>