<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="springSecurity.login.title"/></title>
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>

<body>
		<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>

		<form action='${postUrl}' method='POST' id='loginForm' class='form-signin' autocomplete='off'>
			<input type='text' class='input-block-level' name='j_username' id='username' placeholder="${message(code:'springSecurity.login.username.label') }"/>

			<input type='password' class='input-block-level' name='j_password' id='password' placeholder="${message(code:'springSecurity.login.password.label') }"/>

			<label class="checkbox">
	         <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
	         <g:message code="springSecurity.login.remember.me.label"/>
	        </label>
			<input type='hidden' name='spring-security-redirect' value='${params['spring-security-redirect']}'/>
			<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}' class="btn btn-large btn-primary"/>
		</form>
	</div>
</div>
<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>
