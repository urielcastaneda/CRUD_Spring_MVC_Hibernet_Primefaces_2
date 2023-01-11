/* ----------------------- 
*  Definición de herraientas para apoyar la nevegación y usabilidad 
*  del sitio web
* ------------------------
*/

function confirmarBorrado(userID) {
  swal({
	
    title: "Confirmar Accion",
    text: "Estás seguro que deseas eliminar el registro?",
    showCancelButton: true,
    confirmButtonColor: '#f7505a',
    cancelButtonColor: '#f7505a',
    confirmButtonText: "SI",
    cancelButtonText: "NO"
// ------ 
}).then((result) => {
    if (result.isConfirmed) {
		 swal("OK! El registro ha sido borrado!", {icon: "success",  });
setTimeout(() => {          
        $.ajax({
          url: "borrarContacto/" + userID,
          type: "POST",
        });
      }, 2300);
    }
});
//-----
}

/*

  }).then(function() {
    $('#txt_test').val(idtema);
    $('#formTest').submit();
  })
*/