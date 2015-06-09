function validarFormulario(){

	  var x = document.getElementById("num_target").value;
	  var y = document.getElementById("date").value;
	  var z = document.getElementById("num_secret").value;
	  var target = /^\d{9}$/;
	  var secret = /^\d{4}$/;
	  var val_target=false;
	  var val_date=false;
	  var val_secret=false;
      var today = new Date();
	  var format_today = formattedDate(today);
		
		if (x == null || x == "") {
			document.getElementById("mensaje_target").className = "hide";
			document.getElementById("targeta").className = "form-group has-error has-feedback";
			document.getElementById("num_targetglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_target").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_target").innerHTML = "<p><br/></p><label>No has introducido el numero de targeta</label>";
			val_target=false;
			
		} else {
			if(!target.test(x)){
				document.getElementById("mensaje_target").className = "hide";
				document.getElementById("targeta").className = "form-group has-error has-feedback";
				document.getElementById("num_targetglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_target").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_target").innerHTML = "<p><br/></p><label>Tiene que ser numerico y contener 9 cifras</label>";
				val_target=false;
			} else {
				document.getElementById("targeta").className = "form-group has-success has-feedback";
				document.getElementById("num_targetglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_target").className = "hide";
				val_target=true;
			}
		}
		
		if (y == null || y == "") {
			document.getElementById("mensaje_date").className = "hide";
			document.getElementById("fecha").className = "form-group has-error has-feedback";
			document.getElementById("dateglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_date").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_date").innerHTML = "<p><br/></p><label>Nos has introducido la fecha de caducidad</label>";
			val_date=false;
			
		} else {
			if(y < format_today){
				document.getElementById("mensaje_date").className = "hide";
				document.getElementById("fecha").className = "form-group has-error has-feedback";
				document.getElementById("dateglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_date").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_date").innerHTML = "<p><br/></p><label>La fecha no es correcta</label>";
				val_date=false;
			} else {
				document.getElementById("fecha").className = "form-group has-success has-feedback";
				document.getElementById("dateglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_date").className = "hide";
				val_date=true;
			}
		}
		if(z == "" || z == null){
			document.getElementById("mensaje_secret").className = "hide";
			document.getElementById("secreto").className = "form-group has-error has-feedback";
			document.getElementById("num_secretglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_secret").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_secret").innerHTML = "<p><br/></p><label>Nos has introducido el numero secreto</label>";
			val_secret=false;
		
		} else {
			if(!secret.test(z)){
				document.getElementById("mensaje_secret").className = "hide";
				document.getElementById("secreto").className = "form-group has-error has-feedback";
				document.getElementById("num_secretglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_secret").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_secret").innerHTML = "<p><br/></p><label>Tiene que ser numerico y contener 4 cifras</label>";
				val_secret=false;
			} else {
				document.getElementById("secreto").className = "form-group has-success has-feedback";
				document.getElementById("num_secretglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_secret").className = "hide";
				val_secret=true;
			}
		}
		if(val_target && val_date && val_secret){
			document.getElementById("form-pago").submit();
			alert("formulario correcto");
		}
}

function formattedDate(date) {
    var d = new Date(date || Date.now()),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}