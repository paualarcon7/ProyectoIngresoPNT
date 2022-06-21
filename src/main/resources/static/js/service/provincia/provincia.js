escuelita.service.provincia = (function () {

    var urlService = "/api/provincia/";

    function buscarPorId(idProvincia) {
        var urlServiceBuscarPorId = urlService + idProvincia;
        return $.get(urlServiceBuscarPorId);
    }

    return {
        buscarPorId: buscarPorId
    };

})();