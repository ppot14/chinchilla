/*<![CDATA[*/

/* 
 * Variables
 */
var parcelas_json = null;

var coordenadas_json = null;

var menuOverlay = null;

var menuOverlayParcela = null;

var parcelasCoordenadas = new Array();

//var parcelasMapaFormLabor = "";
//var laboresTabla = "";
//var parcelasMapaFormProduccion = "";
//var produccionesTabla = "";

var contextMenu = new Array();

function insertarPoligonos(map, parcelas_json_aux, coordenadas_json_aux) {

//    parcelas_json = $.parseJSON(parcelas_json_aux);
//
//    coordenadas_json = $.parseJSON(coordenadas_json_aux);

    parcelas_json = parcelas_json_aux;

    coordenadas_json = coordenadas_json_aux;

    var parcela;

//    console.debug("parcelas_json.length " + parcelas_json.length);

//    var colors = Util.getRainbowColors(parcelas_json.length);

    for (i = 0; i < parcelas_json.length; i++) {

        parcela = parcelas_json[i];

//        console.debug("parcela.nombre " + parcela.nombre);

        parcela.coordenadas = extraerCoordenadas(parcela);

//        console.debug("parcela.coordenadas.length " + parcela.coordenadas.length);

//        console.debug("parcela.color " + parcela.color);

        var color = Util.validateOrGetRandomColor(parcela.color);

        parcela.poligono = new google.maps.Polygon({
            paths: parcela.coordenadas,
            strokeColor: color,
            strokeOpacity: 0.8,
            strokeWeight: 1,
            fillColor: color,
            fillOpacity: 0.35
        });

        parcela.poligono.setMap(map);

        parcela.area = google.maps.geometry.spherical.computeArea(parcela.coordenadas);

        parcela.perimetro = google.maps.geometry.spherical.computeLength(parcela.coordenadas);

//        console.debug(parcela.nombre + ": Superficie " + (Math.round(parcela.area, 2) / 10000) + " he. Perimetro: " + (Math.round(parcela.perimetro, 2) / 1000) + " km");

//        console.debug(parcela.nombre + ": Superficie " + parcela.extension + " he");

        parcela.menu = crearMenuParcela(parcela);

//        console.debug("menu: " + parcela.menu);

        google.maps.event.addListener(parcela.poligono, 'click', function(event) {

//            console.debug("menuOverlay " + menuOverlay);

//            console.debug("menuOverlayParcela " + menuOverlayParcela);

//            console.debug("this " + this);

            var temp;

            for (k = 0; k < parcelasCoordenadas.length; k++) {

                temp = parcelasCoordenadas[k];

//                console.debug("parcelasCoordenadas " + k + " " + temp.nombre + " " + temp.id_parcela);

                if (temp.poligono === this) {

                    break;

                }

            }

//            console.debug("temp.id_parcela " + temp.id_parcela);

            if (menuOverlay === null || menuOverlayParcela !== temp.id_parcela) {

                if (menuOverlayParcela !== null && menuOverlayParcela !== temp.id_parcela) {

                    menuOverlay.hide();

                    menuOverlay = null;

                    $('#menu').remove();

                }

                $('body').append(temp.menu);

                //$('#menu').menu();

//                console.debug("menu filled: " + $('#menu').html());

//                var posicionM = posicionMenu(temp.coordenadas);

//                console.debug("posicion menu: " + posicionM);

                menuOverlay = new MenuOverlay(document.getElementById('menu'), /*posicionM*/event.latLng, map);

                menuOverlayParcela = temp.id_parcela;

                /*google.maps.event.addListener(menuOverlay, 'mouseout', function() {
                 
                 menuOverlay.hide();
                 
                 google.maps.event.clearListeners(menuOverlay,'mouseout');
                 
                 });*/

//                console.debug("menu showing...");

                menuOverlay.show();

            } else {

//                console.debug("menu hiding...");

                menuOverlay.hide();

                menuOverlay = null;

                menuOverlayParcela = null;

                $('#menu').remove();

                //google.maps.event.clearListeners(menuOverlay,'mouseout');

            }

        });

        parcelasCoordenadas[i] = parcela;

    }

}

function extraerCoordenadas(parcela) {

    var coordenada;

    var coordenadas = new Array();

    for (j = 0; j < coordenadas_json.length; j++) {

        coordenada = coordenadas_json[j];

        if (coordenada.id_parcela === parcela.id_parcela) {

            coordenadas[coordenada.orden - 1] = new google.maps.LatLng(coordenada.latitud, coordenada.longitud);

        }

    }

    return coordenadas;

}

function crearMenuParcela(parcela) {

    //var menuUl = $("<ul></ul>").attr({ id : "menu",display : "none"});
    //var menuUl = $("<ul/>");
    var menuString = "<ul class='dropdown-menu' role='menu' id='menu' style='display:none'>";
    
//    console.debug("parcelasMapaFormLabor "+parcelasMapaFormLabor);
//    console.debug("laboresTabla "+laboresTabla);
//    console.debug("parcelasMapaTablaLabores "+parcelasMapaTablaLabores);
//    console.debug("produccionesTabla "+produccionesTabla);

    menuString += "<li role='presentation' class='dropdown-header'>" + parcela.nombre + " (" + parcela.extension + " ha)</li>";
    for(var i=0; i<contextMenu.length; i++){
        console.debug("contextMenu "+contextMenu[i].link);
        console.debug("contextMenu "+contextMenu[i].tag);
        menuString += "<li role='presentation'><a role='menuitem' href='"+contextMenu[i].link+"?id=" + parcela.id_parcela + "'>"+contextMenu[i].tag+"</a></li>";
    }
//    menuString += "<li role='presentation'><a role='menuitem' href='"+parcelasMapaFormLabor+"?id=" + parcela.id_parcela + "'>A&ntilde;adir labor</a></li>";
//    menuString += "<li role='presentation'><a role='menuitem' href='"+laboresTabla+"?id=" + parcela.id_parcela + "'>Ver labores</a></li>";
//    menuString += "<li role='presentation'><a role='menuitem' href='"+parcelasMapaFormProduccion+"?id=" + parcela.id_parcela + "'>A&ntilde;adir produccion</a></li>";
//    menuString += "<li role='presentation'><a role='menuitem' href='"+produccionesTabla+"?id=" + parcela.id_parcela + "'>Ver producciones</a></li>";

    menuString += "</ul>";

    return menuString;

}

function posicionMenu(coordenadas) {

    var lat = -999.999999, lng = -999.9999999;

    for (i = 0; i < coordenadas.length; i++) {

        var latlon = coordenadas[i];

        if (latlon.lat() > lat)
            lat = latlon.lat();

        if (latlon.lng() > lng)
            lng = latlon.lng();

    }

    return new google.maps.LatLng(lat, lng);

}

/*
 * Menu overlay situado en el mapa
 */
function MenuOverlay(menu, position, map) {

//    console.info('MenuOverlay');

    this.menu_ = menu;

    this.position_ = position;

    this.div_ = null;

    this.setMap(map);
}

MenuOverlay.prototype = new google.maps.OverlayView();

MenuOverlay.prototype.onAdd = function() {

//    console.info('MenuOverlay.prototype.onAdd');

    var div = document.createElement('div');
    div.style.border = "none";
    div.style.borderWidth = "0px";
    div.style.position = "absolute";
    div.className = "dropdown";

    div.appendChild(this.menu_);

    this.div_ = div;

    var panes = this.getPanes();
    panes.overlayMouseTarget.appendChild(div);
};

MenuOverlay.prototype.draw = function() {

//    console.info('MenuOverlay.prototype.draw');

    var overlayProjection = this.getProjection();

    var ne = overlayProjection.fromLatLngToDivPixel(this.position_);

    var div = this.div_;
    div.style.left = ne.x + 'px';
    div.style.top = ne.y + 'px';
    div.style.display = 'block';

    $("#menu").show();
};

MenuOverlay.prototype.onRemove = function() {
//    console.info('MenuOverlay.prototype.onRemove');
    this.div_.parentNode.removeChild(this.div_);
};

MenuOverlay.prototype.hide = function() {

//    console.info('MenuOverlay.prototype.hide');
    if (this.div_) {
        this.div_.style.visibility = 'hidden';
    }
};

MenuOverlay.prototype.show = function() {

//    console.info('MenuOverlay.prototype.show');
    if (this.div_) {
        this.div_.style.visibility = 'visible';
    }
};

MenuOverlay.prototype.toggle = function() {
//    console.info('MenuOverlay.prototype.toggle');
    if (this.div_) {
        if (this.div_.style.visibility === 'hidden') {
            this.show();
        } else {
            this.hide();
        }
    }
};

/*]]>*/