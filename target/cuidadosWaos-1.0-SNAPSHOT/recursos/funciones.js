function ValidarForma(forma){
    var grande = forma.grande;
    var mediano = forma.mediano;
    var pequeno = forma.pequeno;
    var horas = forma.horas;
    
    if (grande.value=="") {
        alert("Este espacio no puede estar vacío (minimo 0)");
        grande.focus();
        grande.select();
        return false;
    }
    
    if (mediano.value=="") {
        alert("Este espacio no puede estar vacío (minimo 0)");
        mediano.focus();
        mediano.select();
        return false;
    }
    
    if (pequeno.value=="") {
        alert("Este espacio no puede estar vacío (minimo 0)");
        pequeno.focus();
        pequeno.select();
        return false;
    }
    
    if (horas.value=="" || horas.value<=0 || horas>12) {
        alert("Este espacio no puede estar vacío (minimo 0, maximo 12)");
        horas.focus();
        horas.select();
        return false;
    }
    
    if (grande.value==0 && mediano.value==0 && pequeno.value==0) {
        alert("Debes llenar almenos una casilla de perro para continuar");
        grande.focus();
        grande.select();        
        return false;
    }
}
