function validaEmail(e_mail) {
	var regexp = /^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if(e_mail.value.match(regexp)){
		return true;
	}else{
		alert("Immetti un indirizzo e-mail valido");

		return false;

	}

	return regexp.match(e_mail);
}

function validaep(e_mail,password){
	var regexp1=/^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var regexp2=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
	if(e_mail.value.match(regexp1)){
		if(password.value.match(regexp2)){
			return true;
		}
		
	} 
	if(!e_mail.value.match(regexp1)){
		alert("Immetti un indirizzo e-mail valido");
		return false;
	}
	if(!password.value.match(regexp2)){
		alert("la password non rispetta i criteri imposti");
		return false;
	
	}if(!e_mail.value.match(regexp1)){
		if(!password.value.match(regexp2)){
			alert("email e password non validi");
			return false;
		}}


	return regexp1.match(e_mail);
	return regexp2.match(password)
}


function cooki_law(){
	if (!document.cookie.match(/(?:^|; *)alert_shown=1/)) {
		alert("Questo sito utilizza cookies.");
		document.cookie = "alert_shown=1;max-age=" + 60 * 60 * 24 * 365;
	}
}

function Cap(event) 
{
	var textBox = event.target;
	var start = textBox.selectionStart;
	var end = textBox.selectionEnd;
	textBox.value = textBox.value.charAt(0).toUpperCase() + textBox.value.slice(1).toLowerCase();
	textBox.setSelectionRange(start, end);
}


function isNumberKey(evt){
	var charCode=(evt.which)? evt.which:evt.keyCode;
	if(charCode!=46 && charCode>31 && (charCode<48 || charCode>57))
		return false;
	return true;
}








