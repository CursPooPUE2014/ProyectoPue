function validarFormulario(){

	var nom = document.getElementById("nominputreg").value;
	var email = document.getElementById("logininputreg").value;
	var pass = document.getElementById("passinputreg").value;
	var cpass = document.getElementById("confpassinputreg").value;
	var confemail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var val_nom=false;
	var val_email=false;
	var val_pass=false;
	var val_confpass=false;
	
		if (nom == null || nom == "") {
			document.getElementById("regmensaje_nom").className = "hide";
			document.getElementById("nom_reg").className = "form-group has-error has-feedback";
			document.getElementById("nomloginglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("regmensaje_nom").className = "form-group has-error has-feedback text-danger"
			document.getElementById("regmensaje_nom").innerHTML = "<p><br/></p><label>No has introducido el nombre</label>";
			val_nom=false;
			
		} else {
			document.getElementById("nom_reg").className = "form-group has-success has-feedback";
			document.getElementById("nomloginglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("regmensaje_nom").className = "hide";
			val_nom=true;
		}
	  
		if (email == null || email == "") {
			document.getElementById("regmensaje_log").className = "hide";
			document.getElementById("login_reg").className = "form-group has-error has-feedback";
			document.getElementById("regloginglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("regmensaje_log").className = "form-group has-error has-feedback text-danger"
			document.getElementById("regmensaje_log").innerHTML = "<p><br/></p><label>No has introducido el mail</label>";
			val_email=false;
			
		} else {
			if(!confemail.test(email)){
				document.getElementById("regmensaje_log").className = "hide";
				document.getElementById("login_reg").className = "form-group has-error has-feedback";
				document.getElementById("regloginglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("regmensaje_log").className = "form-group has-error has-feedback text-danger"
				document.getElementById("regmensaje_log").innerHTML = "<p><br/></p><label>El mail no esta escrito correctamente</label>";
				val_email=false;
			} else {
				document.getElementById("login_reg").className = "form-group has-success has-feedback";
				document.getElementById("regloginglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("regmensaje_log").className = "hide";
				val_email=true;
			}
		}
		
		if (pass == null || pass == "") {
			document.getElementById("regmensaje_pass").className = "hide";
			document.getElementById("pass_reg").className = "form-group has-error has-feedback";
			document.getElementById("regpassglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("regmensaje_pass").className = "form-group has-error has-feedback text-danger"
			document.getElementById("regmensaje_pass").innerHTML = "<p><br/></p><label>Nos has introducido password</label>";
			val_pass=false;
			
		} else {
			if(pass.length<7){
				document.getElementById("regmensaje_pass").className = "hide";
				document.getElementById("pass_reg").className = "form-group has-error has-feedback";
				document.getElementById("regpassglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("regmensaje_pass").className = "form-group has-error has-feedback text-danger"
				document.getElementById("regmensaje_pass").innerHTML = "<p><br/></p><label>El password tiene menos de 7 caracteres</label>";
				val_pass=false;
			} else {
				document.getElementById("pass_reg").className = "form-group has-success has-feedback";
				document.getElementById("regpassglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("regmensaje_pass").className = "hide";
				val_pass=true;
			}
		}
		if(cpass == "" || cpass == null){
			document.getElementById("regconfmensaje_pass").className = "hide";
			document.getElementById("conf_pass_reg").className = "form-group has-error has-feedback";
			document.getElementById("regconfpassglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("regconfmensaje_pass").className = "form-group has-error has-feedback text-danger"
			document.getElementById("regconfmensaje_pass").innerHTML = "<p><br/></p><label>Nos has introducido la confirmacion del password</label>";
			val_confpass=false;
		
		} else {
			if(pass!=cpass){
				document.getElementById("regconfmensaje_pass").className = "hide";
				document.getElementById("conf_pass_reg").className = "form-group has-error has-feedback";
				document.getElementById("regconfpassglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("regconfmensaje_pass").className = "form-group has-error has-feedback text-danger"
				document.getElementById("regconfmensaje_pass").innerHTML = "<p><br/></p><label>Los passwords no coinciden</label>";
				val_confpass=false;
			} else {
				document.getElementById("conf_pass_reg").className = "form-group has-success has-feedback";
				document.getElementById("regconfpassglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("regconfmensaje_pass").className = "hide";
				val_confpass=true;
			}
		}
		if(val_email && val_pass && val_confpass && val_nom){
			document.getElementById("form-register").submit();
			alert("formulario correcto");
		}
}