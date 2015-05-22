/**
 * Created by poo on 22/05/2015.
 */

function logeame() {

    alert($("#mail") + $("#pass"));

    if(IsEmail($("#mail"))){

    }
}

function IsEmail(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}