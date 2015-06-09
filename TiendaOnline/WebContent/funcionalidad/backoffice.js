function redireccionar() {
    alert('Falta Validar');


    $.ajax( {
        type: "POST",
        url: "helloworld.action",  //will this declaration of action work?
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: "",
        success: function() {
            alert("success");
        }
    });

    window.location = "indice.html";
}

function validacion(){
    $.ajax({
        type: "POST",
        url: "/altaArticulo",
        //data: "name=" + name,
        success: function(response){
            // we have the response
            $('#info').html(response);
            alert("Hace algo");
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
}