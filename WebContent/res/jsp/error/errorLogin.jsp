<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1>Websecurity</h1>
			<p> design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a></p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="">Startseite</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
				<h2 class="title">Willkommen zur Demo-Webanwendung!</h2>
				<p class="meta"><span class="date">29. Januar 2012</span><span class="posted">FH Brandenburg</span></p>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					<p>Diese Webanwendung ist sehr unsicher aufgebaut. Sie können gerne einmal probieren, sich am System mit einem bestehenden Benutzerkonto anzumelden, ohne dass Sie weder den Benutzernamen noch das Passwort kennen. Viel Spaß!</p>
					<p>This is <strong>Indication  </strong>, a free, fully standards-compliant CSS template designed by FreeCssTemplates<a href="http://www.nodethirtythree.com/"></a> for <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.  This free template is released under a <a href="http://creativecommons.org/licenses/by/2.5/">Creative Commons Attributions 2.5</a> license, so you’re pretty much free to do whatever you want with it (even use it commercially) provided you keep the links in the footer intact. Aside from that, have fun with it :)</p>
				</div>
			</div>
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<div id="search" >
					<form name="login">
						<div>
							<input type="text" name="username" class="search-text" value="${username}"/>
                            <input type="password" name="password" class="search-text" value="${password}"/>
							<input type="button" id="login-submit" value="anmelden" onclick="doLogin()"/>
						</div>
					</form>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				<li>
					<p><span class="error">${message}</span></p>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
</div>
	<div id="footer">
		<p>Copyright (c) 2008 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
	</div>
	<!-- end #footer -->