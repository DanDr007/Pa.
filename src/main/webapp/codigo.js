/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validar(){
  var nombre = document.getElementById("texto");
  if (nombre.value.length === 0|| nombre.value.length>150){
      alert ("Escriba entre 1 y 150 caracteres por favor");
      return false;
  }else{
   
    return true;
  }

return true;
}

function validar2(){
    var nombre = document.getElementById("usuario");
    var con = document.getElementById("con");
    if (nombre.value.length === 0|| nombre.value.length>20){
      alert ("Escriba entre 1 y 20 caracteres en su usuario por favor");
      return false;
  }
  if (con.value.length === 0|| con.value.length>10){
      alert ("Escriba entre 1 y 10 caracteres en su contraseña por favor");
      return false;
  }
}

function validar3(){
    var nombre = document.getElementById("usuario");
    var con = document.getElementById("con");
    var cor = document.getElementById("cor");
    if (nombre.value.length === 0|| nombre.value.length>10){
      alert ("Escriba entre 1 y 10 caracteres en su usuario por favor");
      return false;
  }
  if (con.value.length === 0|| con.value.length>10){
      alert ("Escriba entre 1 y 10 caracteres en su contraseña por favor");
      return false;
  }
  if (cor.value.length === 0|| cor.value.length>20){
      alert ("Escriba entre 1 y 20 caracteres en su correo por favor");
      return false;
  }
  var b = /^[^@\s]+@[^@\.\s]+(\.[^@\.\s]+)+$/;

  alert("Email "+(b.test(cor.value)?"":" no ")+" valido");
   
   return b.test(cor.value);
}

function validar4(){
    var cal = document.getElementById("cal");
    if(cal.value>5 || cal.value<1){
        alert("Califique de 1 a 5 por favor");
        return false;    
        
    }
    
    return true;
}