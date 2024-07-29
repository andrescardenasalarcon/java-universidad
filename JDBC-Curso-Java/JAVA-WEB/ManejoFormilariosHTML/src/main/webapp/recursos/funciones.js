function validarForma(forma) {
    var user = forma.usuario;
    if (user.value == '' || user.value == "Escribir usuario") {
        alert("Debe proporcionar un nombre de usuario");
        user.focus()
        user.select();
        return false;
    }

    var pass = forma.password;
    if (pass.value == '' || pass.value.length < 3) {
        alert("Debe proporcionar un password al menos de 3 caracteres");
        pass.focus();
        pass.select();
        return false;
    }

    var tech = forma.tecnologia;
    var checkSeleccionado = false;

    for (var i = 0; i < tech.length; i++) {
        if (tech[i].checked) {
            checkSeleccionado = true;
        }
    }

    if (!checkSeleccionado) {
        alert("Debe seleccionar una tecnologia")
        return false;
    }

    // var generos = forma.genero;
    // var radioSeleccionado = false;
    //
    // for(var i = 0; i < generos.length; i++){
    //     if(generos[i].checked){
    //         radioSeleccionado = true;
    //     }
    // }

    // if (!radioSeleccionado) {
    //     alert("Debe seleccionar un genero");
    //     return false;
    // }

    var ocupacion = forma.ocupacion;
    if (ocupacion.value == '') {
        alert("Debe seleccionar una ocupacion")
        return false;
    }

    //Formulario valido
    alert("Formulario valido, endiando datos al servidor");
    return true;
}