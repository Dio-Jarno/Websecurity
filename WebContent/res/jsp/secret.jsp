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
				<h2 class="title">Willkommen ${user.username}!</h2>
				<p>Sie haben sich erfolgreich angemeldet. Ihr letzter Login war: ${user.lastLoginDate}
				<p>Dies ist ein geheimer Text (nur für angemeldete Benutzer):
					<c:if test="${user != null}">
						${user.message}
					</c:if></p>
			</div>
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<div id="search" >
						<input type="button" id="login-submit" value="abmelden" onclick="doLogout('${user.username}')"/>
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				<li>
					<p>Geheime Datei (nur für Admins):</p>
				</li>
				<c:if test="${user.role == 'admin'}">
				<li>
					<p><a href="res/log/log.txt" target="_blank">Log</a></p>
				</li>
				</c:if>
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
