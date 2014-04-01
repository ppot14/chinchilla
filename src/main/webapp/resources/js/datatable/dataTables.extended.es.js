/* 
 * The MIT License
 *
 * Copyright 2014 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

var currentOptions;

//    var dataTablesLanguage = /*[[@{/resources/json/dataTables.spanish.txt}]]*/null;
    var dataTablesLanguage = {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ning&uacute;n dato disponible en esta tabla",
            "sInfo":           "Mostrando del _START_ al _END_ , Total _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando del 0 al 0 , Total 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "&lsaquo;&lsaquo;",
                "sLast":     "&rsaquo;&rsaquo;",
                "sNext":     "&rsaquo;",
                "sPrevious": "&lsaquo;"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        };
    
    var tabla_opciones = {
//            "sPaginationType": "full_numbers",
            "sPaginationType": "bootstrap",
            "iDisplayLength": 10,
            "oLanguage": dataTablesLanguage,
//            "sScrollX": "100%"
//            "sScrollXInner": "150%"
//            "bScrollCollapse": true,
//            "bStateSave": true
//            "sDom" : "R<'dt-top-row'Clf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
//            "fnInitComplete" : function(oSettings, json) {
//                $('.ColVis_Button').addClass('btn btn-default btn-sm').html('Columnas <i class="icon-arrow-down"></i>');
//            }
        };
        
        //FILTER JSON FORMAT, include into $.fn.dataTableExt
        //https://datatables.net/docs/DataTables/1.9.4/DataTable.models.ext.html#aoFeatures Add advanced filter
        //
        //aoAdvancedFilter
        //
        //$.fn.dataTableExt.aoFeatures.push( {
//            "fnInit": function( oSettings ) {
//              return new AdvancedFilter( { "oAFSettings": oSettings } );
//            },
//            "cFeature": "AF",
//            "sFeature": "AdvancedFilter"
//          } );
        //
        //
        //
        $.fn.dataTableExt.afnFiltering.push(
            function( oSettings, aData, iDataIndex ) {
//                console.debug('oSettings.aoAdvancedFilter: '+JSON.stringify(oSettings.aoAdvancedFilter,null,"\t"));
//                console.debug('aData '+aData);
//                console.debug('iDataIndex '+iDataIndex);
                var result = true;
                for (var i=0; i<oSettings.aoAdvancedFilter.lenght; i++){
                    //var sTitle = oSettings.aoAdvancedFilter[i].sTitle;
                    var sTypeTemp, aDataTemp;
                    for (var j=0; j<oSettings.aoColumns.lenght; j++){
                        if(oSettings.aoColumns[j].sTitle===oSettings.aoAdvancedFilter[i].sTitle){
                            sTypeTemp = oSettings.aoColumns[j].sType;
                            aDataTemp = oSettings.aoColumns[j].aData;
                            break;
                        }
                    }
                    var partialResult = false;
                    for (var j=0; j<oSettings.aoAdvancedFilter[i].aoOperations.lenght; j++){
                        var compareTo, value;
                        //Prepare values
                        if(sTypeTemp==="date-spain"){
                            var partsCompareTo = aData[aDataTemp].split('/');
                            compareTo = new Date(partsCompareTo[2], partsCompareTo[1]-1, partsCompareTo[0]);
                            var partsValue = oSettings.aoAdvancedFilter[i].aoOperations[j].sValue.split('/');
                            value = new Date(partsValue[2], partsValue[1]-1, partsValue[0]);
                        }else if(sTypeTemp==="numeric-comma"){
                            var replacedValue = aData[aDataTemp].replace( /\./, "" ).replace( /,/, "." );
                            compareTo = parseFloat( replacedValue );
                            value = oSettings.aoAdvancedFilter[i].aoOperations[j].sValue;
                        }else {
                            compareTo = aData[aDataTemp];
                            value = oSettings.aoAdvancedFilter[i].aoOperations[j].sValue;
                        }
                        console.debug(oSettings.aoAdvancedFilter[i].sTitle+' '+aDataTemp+' - Type: '+sTypeTemp+', '+compareTo+' '+oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation+' '+value);
                        //
                        if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="equals" &&
                                compareTo===value){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="notEqual" &&
                                compareTo!==value){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="contains" &&
                                compareTo.indexOf(value)!==-1){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="notContains" &&
                                compareTo.indexOf(value)===-1){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="starts" &&
                                compareTo.indexOf(value)===0 ){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="ends" &&
                                compareTo.indexOf(value, compareTo.length - value.length) !== -1){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="less/before" &&
                                compareTo<value){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="greater/after" &&
                                compareTo>value){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="lessEqual/beforeAnd" &&
                                compareTo<=value){
                            partialResult = true; break;
                        }else if(oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation==="greaterEqual/afterThan" &&
                                compareTo>=oSettings.aoAdvancedFilter[i].aoOperations[j].sValue){
                            partialResult = true; break;
                        }
                    }
                    if(partialResult===false){
                        return false;
                    }
                }
                    
                return result;
            }
        );
        
        
        
//        oSettings.aoAdvancedFilter = [{
//                sTitle:"columnName",
//                iIndex:1,
////                sType: ["date","string","numeric","boolean"],
//                aoOperations:[{
//                        sOperation:["equal","notEqual","contains","notContains","starts","ends","less/before","greater/after","lessEqual/beforeAnd","greaterEqual/afterThan"],
//                        sValue:""
//                        }]
//                }];
        
//
//        "equal";"notEqual";"contains";"notContains";"starts";"ends";"less/before";"greater/after";"lessEqual/beforeAnd";"greaterEqual/afterThan"
//        "=";"!=";"~";"!~";"^";"$";"<";">";"<=";">="
        
        //Columns data types for datatable
        //Comma decimal separator
        $.fn.dataTableExt.aTypes.unshift( function ( sData ) {
            var sValidChars = "0123456789,.";
            var Char;
//            var bDecimal = false;
            var iStart=0;

            /* Negative sign is valid -  the number check start point */
            if ( sData.charAt(0) === '-' ) {
                iStart = 1;
            }

            /* Check the numeric part */
            for ( i=iStart ; i<sData.length ; i++ )
            {
                Char = sData.charAt(i);
                if (sValidChars.indexOf(Char) === -1)
                {
                    return null;
                }
            }

            return 'numeric-comma';
        } );
        
        $.extend( $.fn.dataTableExt.oSort, {
            "numeric-comma-pre": function ( a ) {
                var x = (a === "-") ? 0 : a.replace( /\./, "" ).replace( /,/, "." );
                x = parseFloat( x );
                return  x;
            },
            "numeric-comma-asc": function ( a, b ) {
                return ((a < b) ? -1 : ((a > b) ?  1 : 0));
            },
            "numeric-comma-desc": function ( a, b ) {
                return ((a < b) ?  1 : ((a > b) ? -1 : 0));
            }
         }); 
         
         //Dates
         $.fn.dataTableExt.aTypes.unshift( function ( sData ) {
            if (sData !== null && sData.match(/(\d{2})\/(\d{2})\/(\d{4})/)){

                return 'date-spain';
            }
            return null;
         }); 
            
        $.extend( $.fn.dataTableExt.oSort, {
            "date-spain-pre": function ( a ) {
                var b = a.match(/(\d{2})\/(\d{2})\/(\d{4})/),
                    day = b[1],
                    month = b[2],
                    year = b[3];

                var tt = year+month+day;
                return  tt;
            },
            "date-spain-asc": function ( a, b ) {
                return a - b;
            },
            "date-spain-desc": function ( a, b ) {
                return b - a;
            }
         }); 



/*
 * oSetting sample
 */
var oSettings_Sample= {
	"oFeatures": {
		"bAutoWidth": true,
		"bDeferRender": false,
		"bFilter": true,
		"bInfo": true,
		"bLengthChange": true,
		"bPaginate": true,
		"bProcessing": false,
		"bServerSide": false,
		"bSort": true,
		"bSortClasses": true,
		"bStateSave": null
	},
	"oScroll": {
		"bAutoCss": true,
		"bCollapse": false,
		"bInfinite": false,
		"iBarWidth": 0,
		"iLoadGap": 100,
		"sX": "",
		"sXInner": "",
		"sY": ""
	},
	"oLanguage": {
		"fnInfoCallback": null,
		"oAria": {
			"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
			"sSortDescending": ": Activar para ordenar la columna de manera descendente"
		},
		"oPaginate": {
			"sFirst": "&lsaquo;&lsaquo;",
			"sLast": "&rsaquo;&rsaquo;",
			"sNext": "&rsaquo;",
			"sPrevious": "&lsaquo;"
		},
		"sEmptyTable": "Ning&uacute;n dato disponible en esta tabla",
		"sInfo": "Mostrando del _START_ al _END_ , Total _TOTAL_ registros",
		"sInfoEmpty": "Mostrando del 0 al 0 , Total 0 registros",
		"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
		"sInfoPostFix": "",
		"sInfoThousands": ",",
		"sLengthMenu": "Mostrar _MENU_ registros",
		"sLoadingRecords": "Cargando...",
		"sProcessing": "Procesando...",
		"sSearch": "Buscar:",
		"sUrl": "",
		"sZeroRecords": "No se encontraron resultados"
	},
	"oBrowser": {
		"bScrollOversize": false
	},
	"aanFeatures": [],
	"aoData": [
		{
			"nTr": {
				"_DT_RowIndex": 0
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000001\">9000001</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Rancho</li>\n                                          </ul>",
				"",
				"Rulado",
				"20/02/2012",
				"48,26",
				"7,80",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6830</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Rulo</li>\n                                          </ul>",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20120220"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "odd"
		},
		{
			"nTr": {
				"_DT_RowIndex": 1
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000002\">9000002</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Rancho</li>\n                                          </ul>",
				"",
				"Grada",
				"14/02/2012",
				"120,54",
				"9,76",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6830</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Gradas</li>\n                                          </ul>",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20120214"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "even"
		},
		{
			"nTr": {
				"_DT_RowIndex": 2
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000003\">9000003</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Pozo</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Canal</li>\n                                          </ul>",
				"Aplicacion Herbicida",
				"Herbi. Pos. Doble Sal",
				"12/03/2012",
				"150,00",
				"12,00",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">24 D+ MCPA</li>\n                                          </ul>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20120312"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "odd"
		},
		{
			"nTr": {
				"_DT_RowIndex": 3
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000004\">9000004</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo este</li>\n                                          </ul>",
				"Aplicacion Herbicida",
				"Herbi. Pos. Fluoxi 0,35 Glifo 3 Ph 0,075",
				"12/03/2012",
				"30,00",
				"6,00",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ph</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Esta. Fluroxipir 20%</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Glifosato 45%</li>\n                                          </ul>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20120312"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "even"
		},
		{
			"nTr": {
				"_DT_RowIndex": 4
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000023\">9000023</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>\n                                          </ul>",
				"null",
				"null",
				"27/03/2014",
				"2,00",
				"2,00",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">8-24-8</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Bioacidos 0-0-12</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Doble sal FCPO</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Girasol Neoma</li>\n                                          </ul>",
				""
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140327"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "odd"
		},
		{
			"nTr": {
				"_DT_RowIndex": 5
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000022\">9000022</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>\n                                          </ul>",
				"null",
				"null",
				"27/03/2014",
				"1,00",
				"1,00",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6220</li>\n                                          </ul>",
				"",
				""
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140327"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "even"
		},
		{
			"nTr": {
				"_DT_RowIndex": 6
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000013\">9000013</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Canal</li>\n                                          </ul>",
				"null",
				"null",
				"26/03/2014",
				"122,00",
				"113,00",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Gradas</li>\n                                          </ul>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ac. Ni.</li>\n                                          </ul>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Eventual</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140326"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "odd"
		},
		{
			"nTr": {
				"_DT_RowIndex": 7
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000021\">9000021</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>\n                                          </ul>",
				"",
				"",
				"13/03/2014",
				"2,00",
				"2,00",
				"",
				"",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>\n                                          </ul>"
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140313"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "even"
		},
		{
			"nTr": {
				"_DT_RowIndex": 8
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000020\">9000020</a>",
				"",
				"",
				"",
				"21/03/2014",
				"1,00",
				"1,00",
				"",
				"",
				""
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140321"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "even"
		},
		{
			"nTr": {
				"_DT_RowIndex": 9
			},
			"_aData": [
				"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000024\">9000024</a>",
				"<ul class=\"nav nav-pills nav-stacked\">\n                                            <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>\n                                          </ul>",
				"null",
				"null",
				"20/03/2014",
				"0,00",
				"0,00",
				"",
				"",
				""
			],
			"_aSortData": [
				null,
				null,
				null,
				null,
				"20140320"
			],
			"_anHidden": [
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
			],
			"_sRowStripe": "odd"
		}
	],
	"aiDisplay": [
		4,
		5,
		6,
		8,
		9,
		7,
		2,
		3,
		0,
		1
	],
	"aiDisplayMaster": [
		4,
		5,
		6,
		8,
		9,
		7,
		2,
		3,
		0,
		1
	],
	"aoColumns": [
		{
			"aDataSort": [
				0
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 0,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Id Labor",
			"sType": "html",
			"sWidth": "49px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				1
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 1,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Parcela",
			"sType": "html",
			"sWidth": "44px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				2
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 2,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Grupo",
			"sType": "string",
			"sWidth": "81px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				3
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 3,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Nombre",
			"sType": "string",
			"sWidth": "166px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				4
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 4,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Fecha Comienzo",
			"sType": "date-spain",
			"sWidth": "97px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				5
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 5,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Gasoil (l)",
			"sType": "numeric-comma",
			"sWidth": "52px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				6
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 6,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Duración (h)",
			"sType": "numeric-comma",
			"sWidth": "74px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				7
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 7,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Maquinaria",
			"sType": "html",
			"sWidth": "69px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				8
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 8,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Producto",
			"sType": "html",
			"sWidth": "79px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		},
		{
			"aDataSort": [
				9
			],
			"asSorting": [
				"asc",
				"desc"
			],
			"bSearchable": true,
			"bSortable": true,
			"bUseRendered": true,
			"bVisible": true,
			"_bAutoType": true,
			"fnCreatedCell": null,
			"fnRender": null,
			"mData": 9,
			"mRender": null,
			"nTh": {},
			"nTf": null,
			"sClass": "",
			"sContentPadding": "",
			"sDefaultContent": null,
			"sName": "",
			"sSortDataType": "std",
			"sSortingClass": "sorting",
			"sSortingClassJUI": "",
			"sTitle": "Personal",
			"sType": "html",
			"sWidth": "52px",
			"sWidthOrig": null,
			"iDataSort": -1,
			"sCellType": "td"
		}
	],
	"aoHeader": [
		[
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			},
			{
				"cell": {},
				"unique": true
			}
		]
	],
	"aoFooter": [],
	"asDataSearch": [
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000023\">9000023</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>                                           </ul>  null  null  27/03/2014  2,00  2,00    <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">8-24-8</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Bioacidos 0-0-12</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Doble sal FCPO</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Girasol Neoma</li>                                           </ul>  ",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000022\">9000022</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>                                           </ul>  null  null  27/03/2014  1,00  1,00  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6220</li>                                           </ul>    ",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000013\">9000013</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Canal</li>                                           </ul>  null  null  26/03/2014  122,00  113,00  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Gradas</li>                                           </ul>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ac. Ni.</li>                                           </ul>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Eventual</li>                                           </ul>",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000020\">9000020</a>        21/03/2014  1,00  1,00      ",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000024\">9000024</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>                                           </ul>  null  null  20/03/2014  0,00  0,00      ",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000021\">9000021</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Chinchilla</li>                                           </ul>      13/03/2014  2,00  2,00      <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>                                           </ul>",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000003\">9000003</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Pozo</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo Canal</li>                                           </ul>  Aplicacion Herbicida  Herbi. Pos. Doble Sal  12/03/2012  150,00  12,00    <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">24 D+ MCPA</li>                                           </ul>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>                                           </ul>",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000004\">9000004</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ruedo este</li>                                           </ul>  Aplicacion Herbicida  Herbi. Pos. Fluoxi 0,35 Glifo 3 Ph 0,075  12/03/2012  30,00  6,00    <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Ph</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Esta. Fluroxipir 20%</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Glifosato 45%</li>                                           </ul>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>                                           </ul>",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000001\">9000001</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Rancho</li>                                           </ul>    Rulado  20/02/2012  48,26  7,80  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6830</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Rulo</li>                                           </ul>    <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>                                           </ul>",
		"<a href=\"/Chinchilla/labores/tabla/form/labor.html;jsessionid=9169BDBAB77F553090D5FB4E008E33DE?id=9000002\">9000002</a>  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">V Rancho</li>                                           </ul>    Grada  14/02/2012  120,54  9,76  <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Tractor 6830</li><li class=\"label label-primary\" style=\"margin-bottom: 3px\">Gradas</li>                                           </ul>    <ul class=\"nav nav-pills nav-stacked\">                                             <li class=\"label label-primary\" style=\"margin-bottom: 3px\">Fijo</li>                                           </ul>"
	],
	"oPreviousSearch": {
		"bCaseInsensitive": true,
		"sSearch": "",
		"bRegex": false,
		"bSmart": true
	},
	"aoPreSearchCols": [
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		},
		{
			"bCaseInsensitive": true,
			"sSearch": "",
			"bRegex": false,
			"bSmart": true
		}
	],
	"aaSorting": [
		[
			4,
			"desc",
			1
		]
	],
	"aaSortingFixed": null,
	"asStripeClasses": [
		"odd",
		"even"
	],
	"asDestroyStripes": [],
	"sDestroyWidth": 1151,
	"aoRowCallback": [],
	"aoHeaderCallback": [],
	"aoFooterCallback": [],
	"aoDrawCallback": [
		{
			"sName": "information"
		},
		{
			"sName": "pagination"
		}
	],
	"aoRowCreatedCallback": [],
	"aoPreDrawCallback": [],
	"aoInitComplete": [],
	"aoStateSaveParams": [],
	"aoStateLoadParams": [],
	"aoStateLoaded": [],
	"sTableId": "tabla_labores",
	"nTable": {},
	"nTHead": {},
	"nTFoot": null,
	"nTBody": {},
	"nTableWrapper": {},
	"bDeferLoading": false,
	"bInitialised": true,
	"aoOpenRows": [],
	"sDom": "<'row header'<'col-xs-6'l><'col-xs-6'f>r>t<'row footer'<'col-xs-6'i><'col-xs-6'p>>",
	"sPaginationType": "bootstrap",
	"iCookieDuration": 7200,
	"sCookiePrefix": "SpryMedia_DataTables_",
	"fnCookieCallback": null,
	"aoStateSave": [],
	"aoStateLoad": [],
	"oLoadedState": null,
	"sAjaxSource": null,
	"sAjaxDataProp": "aaData",
	"bAjaxDataGet": true,
	"jqXHR": null,
	"aoServerParams": [],
	"sServerMethod": "GET",
	"aLengthMenu": [
		10,
		25,
		50,
		100
	],
	"iDraw": 2,
	"bDrawing": false,
	"iDrawError": -1,
	"_iDisplayLength": 10,
	"_iDisplayStart": 0,
	"_iDisplayEnd": 10,
	"_iRecordsTotal": 0,
	"_iRecordsDisplay": 0,
	"bJUI": false,
	"oClasses": {
		"sTable": "dataTable",
		"sPagePrevEnabled": "paginate_enabled_previous",
		"sPagePrevDisabled": "paginate_disabled_previous",
		"sPageNextEnabled": "paginate_enabled_next",
		"sPageNextDisabled": "paginate_disabled_next",
		"sPageJUINext": "",
		"sPageJUIPrev": "",
		"sPageButton": "paginate_button",
		"sPageButtonActive": "paginate_active",
		"sPageButtonStaticDisabled": "paginate_button paginate_button_disabled",
		"sPageFirst": "first",
		"sPagePrevious": "previous",
		"sPageNext": "next",
		"sPageLast": "last",
		"sStripeOdd": "odd",
		"sStripeEven": "even",
		"sRowEmpty": "dataTables_empty",
		"sWrapper": "dataTables_wrapper form-inline",
		"sFilter": "dataTables_filter",
		"sInfo": "dataTables_info",
		"sPaging": "dataTables_paginate paging_",
		"sLength": "dataTables_length",
		"sProcessing": "dataTables_processing",
		"sSortAsc": "sorting_asc",
		"sSortDesc": "sorting_desc",
		"sSortable": "sorting",
		"sSortableAsc": "sorting_asc_disabled",
		"sSortableDesc": "sorting_desc_disabled",
		"sSortableNone": "sorting_disabled",
		"sSortColumn": "sorting_",
		"sSortJUIAsc": "",
		"sSortJUIDesc": "",
		"sSortJUI": "",
		"sSortJUIAscAllowed": "",
		"sSortJUIDescAllowed": "",
		"sSortJUIWrapper": "",
		"sSortIcon": "",
		"sScrollWrapper": "dataTables_scroll",
		"sScrollHead": "dataTables_scrollHead",
		"sScrollHeadInner": "dataTables_scrollHeadInner",
		"sScrollBody": "dataTables_scrollBody",
		"sScrollFoot": "dataTables_scrollFoot",
		"sScrollFootInner": "dataTables_scrollFootInner",
		"sFooterTH": "",
		"sJUIHeader": "",
		"sJUIFooter": "",
		"sFilterInput": "form-control input-sm",
		"sLengthSelect": "form-control input-sm"
	},
	"bFiltered": false,
	"bSorted": true,
	"bSortCellsTop": false,
	"oInit": {
		"sPaginationType": "bootstrap",
		"iDisplayLength": 10,
		"oLanguage": {
			"sProcessing": "Procesando...",
			"sLengthMenu": "Mostrar _MENU_ registros",
			"sZeroRecords": "No se encontraron resultados",
			"sEmptyTable": "Ning&uacute;n dato disponible en esta tabla",
			"sInfo": "Mostrando del _START_ al _END_ , Total _TOTAL_ registros",
			"sInfoEmpty": "Mostrando del 0 al 0 , Total 0 registros",
			"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix": "",
			"sSearch": "Buscar:",
			"sUrl": "",
			"sInfoThousands": ",",
			"sLoadingRecords": "Cargando...",
			"oPaginate": {
				"sFirst": "&lsaquo;&lsaquo;",
				"sLast": "&rsaquo;&rsaquo;",
				"sNext": "&rsaquo;",
				"sPrevious": "&lsaquo;"
			},
			"oAria": {
				"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
				"sSortDescending": ": Activar para ordenar la columna de manera descendente"
			}
		},
		"aaSorting": [
			[
				4,
				"desc"
			]
		]
	},
	"aoDestroyCallback": [],
	"oInstance": {
		"length": 1,
		"0": {},
		"context": {
			"location": {}
		},
		"selector": "#tabla_labores",
		"oApi": {}
	},
	"sInstance": "tabla_labores",
	"iTabIndex": 0,
	"nScrollHead": null,
	"nScrollFoot": null,
	"oApi": {},
	"iInitDisplayStart": -1,
	"nTableReinsertBefore": {},
	"_bInitComplete": true
};