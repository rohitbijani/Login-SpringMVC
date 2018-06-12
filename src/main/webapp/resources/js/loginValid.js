/**
 * 
 */
function validateform() {
	var name=document.loginForm.uname.value;  
	var password=document.loginForm.pwd.value;  
	  
	if (name==null || name==""){  
	  alert("Username can't be blank");  
	  return false;  
	}
	else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	}

