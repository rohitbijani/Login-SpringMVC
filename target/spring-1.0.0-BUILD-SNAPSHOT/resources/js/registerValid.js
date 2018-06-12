/**
 * 
 */
function validateform() {
	var name=document.registerForm.uname.value;  
	var password=document.registerForm.pwd.value;
	var email=document.registerForm.email.value;
	var pattern = /^([a-zA-Z0-9])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/i;

	if (name==null || name==""){  
	  alert("Name can't be blank");  
	  return false;  
	}
	else if(!pattern.test(email)){
		alert("Invalid email format");
		return false;
	}
	else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	}  