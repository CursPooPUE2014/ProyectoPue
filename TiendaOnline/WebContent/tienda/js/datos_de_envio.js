function validarFormulario(){

	  var nom = document.getElementById("nominput").value;
	  var dir = document.getElementById("dirinput").value;
	  var num = document.getElementById("numinput").value;
	  var ciu = document.getElementById("ciuinput").value;
	  var prov = document.getElementById("provinput").value;
	  var pob = document.getElementById("pobinput").value;
	  var cp = document.getElementById("cpinput").value;
	  var conf_cp = /^\d{5}$/;
	  var val_nom=false;
	  var val_dir=false;
	  var val_ciu=false;
	  var val_pob=false;
	  var val_prov=false;
	  var val_cp=false;
	  var val_num=false;
	  
		if (nom == null || nom == "") {
			document.getElementById("mensaje_nom").className = "hide";
			document.getElementById("nombre").className = "form-group has-error has-feedback";
			document.getElementById("nomglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_nom").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_nom").innerHTML = "<p><br/></p><label>No has introducido el nombre</label>";
			val_nom=false;
			
		} else {
			document.getElementById("nombre").className = "form-group has-success has-feedback";
			document.getElementById("nomglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_nom").className = "hide";
			val_nom=true;
		}
		
		if (dir == null || dir == "") {
			document.getElementById("mensaje_dir").className = "hide";
			document.getElementById("direccion").className = "form-group has-error has-feedback";
			document.getElementById("dirglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_dir").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_dir").innerHTML = "<p><br/></p><label>Nos has introducido la dirección</label>";
			val_dir=false;
			
		} else {
			document.getElementById("direccion").className = "form-group has-success has-feedback";
			document.getElementById("dirglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_dir").className = "hide";
			val_dir=true;
		}
		if(ciu == "" || ciu == null){
			document.getElementById("mensaje_ciu").className = "hide";
			document.getElementById("ciudad").className = "form-group has-error has-feedback";
			document.getElementById("ciuglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_ciu").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_ciu").innerHTML = "<p><br/></p><label>Nos has introducido la ciudad</label>";
			val_ciu=false;
		
		} else {
			document.getElementById("ciudad").className = "form-group has-success has-feedback";
			document.getElementById("ciuglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_ciu").className = "hide";
			val_ciu=true;
		}
		if(prov == "" || prov == null){
			document.getElementById("mensaje_prov").className = "hide";
			document.getElementById("provincia").className = "form-group has-error has-feedback";
			document.getElementById("provglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_prov").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_prov").innerHTML = "<p><br/></p><label>Nos has introducido la provincia</label>";
			val_prov=false;
		
		} else {
			document.getElementById("provincia").className = "form-group has-success has-feedback";
			document.getElementById("provglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_prov").className = "hide";
			val_prov=true;
		}
		if(pob == "" || pob == null){
			document.getElementById("mensaje_pob").className = "hide";
			document.getElementById("poblacion").className = "form-group has-error has-feedback";
			document.getElementById("pobglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_pob").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_pob").innerHTML = "<p><br/></p><label>Nos has introducido la población</label>";
			val_pob=false;
		
		} else {
			document.getElementById("poblacion").className = "form-group has-success has-feedback";
			document.getElementById("pobglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_pob").className = "hide";
			val_pob=true;
		}
		if(cp == "" || cp == null){
			document.getElementById("mensaje_cp").className = "hide";
			document.getElementById("cp").className = "form-group has-error has-feedback";
			document.getElementById("cpglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_cp").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_cp").innerHTML = "<p><br/></p><label>Nos has introducido el codigo postal</label>";
			val_cp=false;
		
		} else {
			if(!conf_cp.test(cp)){
				document.getElementById("mensaje_cp").className = "hide";
				document.getElementById("cp").className = "form-group has-error has-feedback";
				document.getElementById("cpglyph").className = "glyphicon glyphicon-remove form-control-feedback";
				document.getElementById("mensaje_cp").className = "form-group has-error has-feedback text-danger"
				document.getElementById("mensaje_cp").innerHTML = "<p><br/></p><label>El codigo postal debe ser numerico y tener 5 cifras</label>";
				val_cp=false;
			} else {
				document.getElementById("cp").className = "form-group has-success has-feedback";
				document.getElementById("cpglyph").className = "glyphicon glyphicon-ok form-control-feedback";
				document.getElementById("mensaje_cp").className = "hide";
				val_cp=true;
			}
		}
		if(num == "" || num == null){
			document.getElementById("mensaje_num").className = "hide";
			document.getElementById("num").className = "form-group has-error has-feedback";
			document.getElementById("numglyph").className = "glyphicon glyphicon-remove form-control-feedback";
			document.getElementById("mensaje_num").className = "form-group has-error has-feedback text-danger"
			document.getElementById("mensaje_num").innerHTML = "<p><br/></p><label>Nos has introducido la ciudad</label>";
			val_num=false;
		
		} else {
			document.getElementById("num").className = "form-group has-success has-feedback";
			document.getElementById("numglyph").className = "glyphicon glyphicon-ok form-control-feedback";
			document.getElementById("mensaje_num").className = "hide";
			val_num=true;
		}
		if(val_nom && val_dir && val_ciu && val_pob && val_prov && val_cp && val_num){
			document.getElementById("form-dat-usuario").submit();
			alert("formulario correcto");
		}
}