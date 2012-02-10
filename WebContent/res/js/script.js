
function doLogin() {
	new Request.HTML({
		url: "/Websecurity/index",
		update: $('body') })
		.post({'do': 'login',
			  'username': document.forms.login.elements.username.value,
			  'password': document.forms.login.elements.password.value});
}

function doLogout(username) {
	new Request.HTML({
		url: "/Websecurity/index",
		update: $('body') })
		.post({'do': 'logout',
			   'username': username});
}