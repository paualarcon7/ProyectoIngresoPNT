escuelita.ui.provincia = (function () {

    var $bodyTablaProvincia = $("#bodyTablaProvincia");
    var $spanIdProvinciaEncontrada = $("#idProvinciaEncontrada");
    var $divMensajeNoEncontrado = $("#mensajeNoEncontrado");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    function buscar(idProvincia) {
        escuelita.service.provincia.buscarPorId(idProvincia)
                .done(mostrar)
                .fail(mostrarMensajeNoEncontrado);
    }

    function mostrar(provincia) {
        $bodyTablaProvincia.html("<tr><td>" + provincia.id + "</td><td>" + provincia.nombre + "</td></tr>");
        $spanIdProvinciaEncontrada.text(provincia.id);
    }

    function bindearEventosABotones() {
        $("#botonBuscarProvinciaPorId").on("click", function () {
            $("#mensajeNoEncontrado").addClass("hide");
            var idProvinciaABuscar = $("#idProvinciaABuscar").val();
            buscar(idProvinciaABuscar);
        });
    }

    function mostrarMensajeNoEncontrado() {
        $bodyTablaProvincia.text("");
        $spanIdProvinciaEncontrada.text("");
        $divMensajeNoEncontrado.removeClass("hide");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.provincia.inicializar();
});