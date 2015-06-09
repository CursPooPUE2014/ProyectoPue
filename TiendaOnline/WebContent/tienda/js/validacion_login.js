function validarFormulario(){
	  var x = document.getElementById("logininput").value;
	  var y = document.getElementById("passinput").value;
	  var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  var val_email=false;
	  var val_pass=false;
	  
		if (x == null || x == "") {
			document.getElementById("mensaje_log").className = "hide";
			document.getElementById("login").className = "form-group has-error has-feedback";
			document.getElementById("loginglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_log").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_log").innerHTML = "<p></p><label>No has introducido el mail</label>";
			val_email=false;
			
		} else {
			if(!expr.test(x)){
				document.getElementById("mensaje_log").className = "hide";
				document.getElementById("login").className = "form-group has-error has-feedback";
				document.getElementById("loginglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_log").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_log").innerHTML = "<p></p><label>El mail no esta escrito correctamente</label>";
				val_email=false;
			} else {
				document.getElementById("login").className = "form-group has-success has-feedback";
				document.getElementById("loginglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_log").className = "hide";
				val_email=true;
			}
		}
		
		if (y == null || y == "") {
			document.getElementById("mensaje_pass").className = "hide";
			document.getElementById("pass").className = "form-group has-error has-feedback";
			document.getElementById("passglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_pass").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_pass").innerHTML = "<p></p><label>Nos has introducido password</label>";
			val_pass=false;
			
		} else {
			if(y.length<7){
				document.getElementById("mensaje_pass").className = "hide";
				document.getElementById("pass").className = "form-group has-error has-feedback";
				document.getElementById("passglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_pass").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_pass").innerHTML = "<p></p><label>El password tiene menos de 7 caracteres</label>";
				val_pass=false;
			} else {
				document.getElementById("pass").className = "form-group has-success has-feedback";
				document.getElementById("passglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_pass").className = "hide";
				val_pass=true;
			}
		}
		if(val_email && val_pass){
			document.getElementById("form-login").submit();
			alert("formulario correcto");
		}
}