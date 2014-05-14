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
        "sAdvancedFilter": "Filtro Avanzado",
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
    "bProcessing": true,
    
//            "sScrollX": "100%",
//            "sScrollXInner": "150%",
//            "bScrollCollapse": true,
//            "bStateSave": true
//            
    "sDom": "<'row header'<'col-xs-6'l><'col-xs-6'fA>>" + "<'row tableContent'<'col-xs-12'rt>>" + "<'row footer'<'col-xs-6'i><'col-xs-6'p>>",
//            "sDom" : "R<'dt-top-row'Clf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
//            "fnInitComplete" : function(oSettings, json) {
//                $('.ColVis_Button').addClass('btn btn-default btn-sm').html('Columnas <i class="icon-arrow-down"></i>');
//            }
};
        
//FILTER JSON FORMAT, include into $.fn.dataTableExt
//https://datatables.net/docs/DataTables/1.9.4/DataTable.models.ext.html#aoFeatures 

/*
 * AdvancedFilter Main Constructor CLASS
 * 
 * @param {type} oDTSettings
 * @param {type} oInit
 * @returns {unresolved}
 */
var AdvancedFilter = function( oDTSettings, oInit ) {
	/* Santiy check that we are a new instance */
	if ( !this.CLASS || this.CLASS !== "AdvancedFilter" )
	{
		alert( "Warning: AdvancedFilter must be initialised with the keyword 'new'" );
	}

	if ( typeof oInit === 'undefined' )
	{
		oInit = [];
	}
        
        this.s = {
            "oDataTable": null,
            "oInit": oInit
        };
            
        
        this.dom = {
            "wrapper": null,
            "button": null,
            "active":null,
            "foot":null
        };
        
	/* Store global reference */
	AdvancedFilter.aInstances.push( this );
        
        this.s.oDataTable = $.fn.dataTable.Api ?
		new $.fn.dataTable.Api( oDTSettings ).settings()[0] :
		oDTSettings;
//        console.debug("AdvancedFilter oDTSettings: "+JSON.stringify(oDTSettings,null,"\t"));
        
        this._fnConstruct( oDTSettings, oInit );
        
	return this;
};

/*
 * AdvancedFilter Prototype CLASS
 */
AdvancedFilter.prototype = {
    fnGetButton: function () {
	return this.dom.wrapper;
    },
    fnSetCounter: function(settings){
        
        var counterSpan = '';
        
        var buttomFilter = $("#"+settings.sTableId+"_ShowHideFilter");
        
        if(settings.oInstance.fnSettings().aoAdvancedFilter && settings.oInstance.fnSettings().aoAdvancedFilter.length>0){
            counterSpan = ' <span class="badge">'+settings.oInstance.fnSettings().aoAdvancedFilter.length+'</span>';
        }
        
        buttomFilter.html('<i class="icon-filter"></i> '+settings.oInit.oLanguage.sAdvancedFilter + counterSpan)
        
        this.dom.button = buttomFilter;
        
    },
    fnSetAdvancedFilter: function(aoAdvancedFilter, settings){
        
//        console.debug("setAdvancedFilter aoAdvancedFilter: "+JSON.stringify(aoAdvancedFilter,null,"\t"));
        
//        var footer = settings.nTFoot;
        
        for (var i=0; i<aoAdvancedFilter.length; i++){
            
            var advFilterTitle = aoAdvancedFilter[i].sTitle;
            
            for (var j=0; j<settings.aoColumns.length; j++){
                var mDataTemp = settings.aoColumns[j].mData;
                var sTitleTemp = settings.aoColumns[j].sTitle;
            
                if(advFilterTitle === sTitleTemp){
        
//        console.debug("setAdvancedFilter aoAdvancedFilter[i]: "+JSON.stringify(aoAdvancedFilter[i],null,"\t"));
                    
                    $('#operation_'+mDataTemp).val(aoAdvancedFilter[i].aoOperations[0].sOperation);
                    
                    $('#value1_'+mDataTemp).val(aoAdvancedFilter[i].aoOperations[0].sValue1);
                    
                    $('#value2_'+mDataTemp).val(aoAdvancedFilter[i].aoOperations[0].sValue2);

                }
                
            }
            
        }
        
        settings.oInstance.fnSettings().aoAdvancedFilter = aoAdvancedFilter;
        
        this.fnSetCounter(settings);
        
        settings.oInstance.fnDraw();
        
    },
    "_fnConstruct": function ( settings, init ) {
        var that = this;
        this.dom.wrapper =document.createElement('div');
	this.dom.wrapper.className = "dataTables_advancedFilter";
        this.dom.wrapper.id = settings.sTableId+"_advancedFilter";
//        console.debug("AdvancedFilter._fnConstruct advancedFilter (init): "+init);
        this.dom.active = init && init.length>0;
//        console.debug("AdvancedFilter._fnConstruct dom.active: "+this.dom.active);
        
        that._fnCreateFilterForm( settings, init );

        this.dom.button = $( '<button/>', {
                        'class': this.dom.active ? "btn btn-default btn-xs active" : "btn btn-default btn-xs",
                        'id': settings.sTableId+"_ShowHideFilter"
                } )
                .append( '<i class="icon-filter"></i> '+settings.oInit.oLanguage.sAdvancedFilter )
                .bind(  "click", function (e) {
                        e.preventDefault();
                        that._fnToggle(settings, init );
                } )
                .appendTo( this.dom.wrapper )[0];
        
//      console.debug('AdvancedFilter._fnConstruct, init: '+JSON.stringify(init,null,"\t"));
        
        settings.oInstance.fnDraw(); 
        
    },
    "_fnCreateFilterForm": function ( settings, init ) {
        
        var that = this;
        
        var tFoot = $('#'+settings.sTableId+' tfoot');
        
        var trFoot = $('<tr/>');
        
        if(true){
            tFoot = $('<tfoot/>');
        }
        
//        console.debug("AdvancedFilter._fnCreateFilterForm tFoot: "+tFoot.html());
        
        for (var i=0; i<settings.aoColumns.length; i++){
            var sTypeTemp = settings.aoColumns[i].sType;
            var mDataTemp = settings.aoColumns[i].mData;
            var sTitleTemp = settings.aoColumns[i].sTitle;
//    console.debug('_fnCreateFilterForm settings.aoColumns['+i+']: '+JSON.stringify(settings.aoColumns[i],null,"\t"));
            
            var filter = that._fnFindFilterColumn(sTitleTemp, init);
//            console.debug("AdvancedFilter._fnCreateFilterForm settings.aoColumns["+i+"]>filter: "+JSON.stringify(filter));
            
//            console.debug("AdvancedFilter._fnCreateFilterForm settings.aoColumns["+i+"]: "+JSON.stringify(settings.aoColumns[i]));
            var operationSelectElement = $('<select id="operation_'+mDataTemp+'" class="form-control input-sm"/>').bind("change",function (e) {
				e.preventDefault();
                                if(this.value === "between" || this.value === "not-between"){
                                    $( this ).next().next().prop('disabled', false);
                                }else{
                                    $( this ).next().next().prop('disabled', true);
                                }
                                var index = $( "tfoot tr th" ).index( $( this ).parent() );
                                var value1 = $( this ).next().val();
                                var value2 = $( this ).next().next().val();
				that._fnApplyAdvancedFilter(value1, value2, this.value, settings, init, index );
			});
            var value1FieldElement = $('<input type="text" id="value1_'+mDataTemp+'" class="form-control input-sm"/>').bind("keyup",function (e) {
				e.preventDefault();
                                var index = $( "tfoot tr th" ).index( $( this ).parent() );
                                var value2 = $( this ).next().val();
				that._fnApplyAdvancedFilter(this.value, value2, $( this ).siblings("select").val(), settings, init, index );
			});
            var value2FieldElement = $('<input type="text" id="value2_'+mDataTemp+'" class="form-control input-sm" disabled/>').bind("keyup",function (e) {
				e.preventDefault();
                                var index = $( "tfoot tr th" ).index( $( this ).parent() );
                                var value1 = $( this ).prev().val();
				that._fnApplyAdvancedFilter(value1, this.value, $( this ).siblings("select").val(), settings, init, index  );
			});
            
            
            if(sTypeTemp){
                
                //Only one operation from now
                if(filter && filter.aoOperations[0]){
                    value1FieldElement.val(filter.aoOperations[0].sValue1);
                    value2FieldElement.val(filter.aoOperations[0].sValue2);
                }
                var optionsList;
                if(sTypeTemp.indexOf("date")!==-1){
                    //TODO
    //                value1FieldElement.datepicker();
    //                value2FieldElement.datepicker();
                    optionsList = ["equals","not-equals","before","after","before-and","after-and","between","not-between"];
                }else if(sTypeTemp.indexOf("numeric")!==-1){
                    optionsList = ["equals","not-equals","less","greater","less-equal","greater-equal","between","not-between"];
                }else {
                    optionsList = ["equals","not-equals","contains","not-contains","starts","ends","before","after","before-and","after-and","between","not-between"];
                }
                for(var j=0; j<optionsList.length; j++){
//                console.debug(optionsList[j]+': '+$.t(optionsList[j]));
                    var selected = (filter && filter.aoOperations[0] && optionsList[j]===filter.aoOperations[0].sOperation)?'selected':'';
                    operationSelectElement.append('<option value="'+optionsList[j]+'" ' +selected+'>'+ $.t(optionsList[j])+'</option>');;
                }
            
            }
            
            var thFoot = $('<th/>');
            
            if(sTypeTemp) thFoot.append(operationSelectElement).append(value1FieldElement).append(value2FieldElement);
            
            trFoot.append(thFoot);
            
        }
        
        tFoot.append(trFoot);
        
        tFoot.css("display","none");
            
//        this.dom.foot = tFoot;
            
//            var aoFooter = settings.aoFooter[0];
//            console.debug("AdvancedFilter._fnCreateFilterForm aoFooter: "+JSON.stringify(aoFooter));
//            var nTFoot = settings.nTFoot;
//            console.debug("AdvancedFilter._fnCreateFilterForm nTFoot: "+JSON.stringify(nTFoot));
            
        settings.nTFoot = tFoot;
        
//        console.debug("AdvancedFilter._fnCreateFilterForm tFoot: "+tFoot.html());
        
        $('#'+settings.sTableId).append(tFoot);
        
//        console.debug("AdvancedFilter._fnCreateFilterForm sTableId: "+$('#'+settings.sTableId).html());

        if(this.dom.active === true) $('#'+settings.sTableId+' tfoot').slideDown( "slow" );
        
//        $('#'+settings.sTableId+"_ShowHideFilter").removeClass("active");
        
    },
    "_fnToggle": function ( settings, init ) {
        
//        var that = this;
        
//        console.debug("AdvancedFilter._fnToggle hasClass.active "+$('#'+settings.sTableId+"_ShowHideFilter").hasClass("active"));
        
        if(!$('#'+settings.sTableId+"_ShowHideFilter").hasClass("active")){
             $('#'+settings.sTableId+' tfoot').slideDown( "slow" );
             $('#'+settings.sTableId+"_ShowHideFilter").addClass("active");
        }else{
             $('#'+settings.sTableId+' tfoot').slideUp( "slow" );
             $('#'+settings.sTableId+"_ShowHideFilter").removeClass("active");
        }
//        console.debug("AdvancedFilter._fnToggle hasClass.active "+$('#'+settings.sTableId+"_ShowHideFilter").hasClass("active"));
        
    },
    "_fnFindFilterColumn": function ( mTitle, init ) {
        
//        var that = this;
        
        for (var i=0; i<init.length; i++){
            
            if(mTitle===init[i].sTitle){
                return init[i];
            }  
            
        }
        
    },
    "_fnApplyAdvancedFilter": function (value1, value2, operation, settings, init, mDataTemp  ) {
        var sTitleTemp;
        for (var j=0; j<settings.aoColumns.length; j++){
            if(settings.aoColumns[j].mData===mDataTemp){
                sTitleTemp = settings.aoColumns[j].sTitle;
                break;
            }
        }
//        console.debug('_fnApplyAdvancedFilter value1: '+value1+', value2: '+value2+', operation: '+operation+', sTitleTemp: '+sTitleTemp+', mDataTemp: '+mDataTemp);
        
        if(!settings.aoAdvancedFilter){
            settings.aoAdvancedFilter = [];
        }
//    console.debug('_fnApplyAdvancedFilter settings.aoAdvancedFilter: '+JSON.stringify(settings.aoAdvancedFilter,null,"\t"));
        
        var found = false;
        
        for (var i=0; i<settings.aoAdvancedFilter.length; i++){
            
            if(settings.aoAdvancedFilter[i].sTitle===sTitleTemp){
                
                if(value1===""){
                    settings.aoAdvancedFilter.splice(i, 1);
                }else{
                    settings.aoAdvancedFilter[i].iIndex = mDataTemp;
                    settings.aoAdvancedFilter[i].aoOperations = [{
                                sOperation:operation,
                                sValue1:value1,
                                sValue2:value2
                                }] ;
                }
                
                found = true;
            
                break;
            }
        }
//    console.debug('_fnApplyAdvancedFilter found: '+found);
        
        if(!found && value1!==""){
//    console.debug('_fnApplyAdvancedFilter mTitleTemp: '+JSON.stringify(sTitleTemp,null,"\t"));
            
            var filter = {
                        sTitle:sTitleTemp,
                        iIndex:mDataTemp,
                        aoOperations:[{
                                sOperation:operation,
                                sValue1:value1,
                                sValue2:value2
                                }]
                    };
        
//    console.debug('_fnApplyAdvancedFilter filter: '+JSON.stringify(filter,null,"\t"));
            
             settings.aoAdvancedFilter.push(filter);
        }
        
        this.fnSetCounter(settings);
        
//    console.debug('_fnApplyAdvancedFilter settings.aoAdvancedFilter: '+JSON.stringify(settings.aoAdvancedFilter,null,"\t"));
        settings.oInstance.fnDraw(); 
    }
};

/*
* Static object methods
*/

/**
 * Rebuild the collection for a given table, or all tables if no parameter given
 *  @method  AdvancedFilter.fnSetAdvancedFilter
 *  @static
 *  @param   object aoAdvancedFilter JSON with the advanced filter
 *  @param   object oTable DataTable instance to consider - optional
 *  @returns void
 */
AdvancedFilter.fnSetAdvancedFilter = function ( aoAdvancedFilter, oTable )
{
	var nTable = null;
	if ( typeof oTable !== 'undefined' )
	{
		nTable = oTable.fnSettings().nTable;
	}
        
//        console.debug('nTable: '+nTable);

	for ( var i=0, iLen=AdvancedFilter.aInstances.length ; i<iLen ; i++ )
	{
		if ( typeof oTable === 'undefined' || nTable === AdvancedFilter.aInstances[i].s.oDataTable.nTable )
		{
        
//                        console.debug('AdvancedFilter.aInstances[i].s.oDataTable.nTable: '+AdvancedFilter.aInstances[i].s.oDataTable.nTable);
			AdvancedFilter.aInstances[i].fnSetAdvancedFilter(aoAdvancedFilter, AdvancedFilter.aInstances[i].s.oDataTable);
		}
	}
        
        return true;
};

/**
 * Collection of all AdvancedFilter instances
 *  @property AdvancedFilter.aInstances
 *  @static
 *  @type     Array
 *  @default  []
 */
AdvancedFilter.aInstances = [];

AdvancedFilter.defaults = {
	active: false
};

/*
* Constants
*/
AdvancedFilter.prototype.CLASS = "AdvancedFilter";

/*
* Initialisation
*/

//Register a new feature AdvancedFilter with DataTables
if ( typeof $.fn.dataTable === "function" &&
     typeof $.fn.dataTableExt.fnVersionCheck === "function" ){
 
//        console.debug('Pushing new feature AdvancedFilter...');
	$.fn.dataTableExt.aoFeatures.push( {
		"fnInit": function( oDTSettings ) {
			var init = oDTSettings.oInit;
//                        console.debug('Pushing new feature AdvancedFilter, init: '+JSON.stringify(init,null,"\t"));
			var advancedFilter = new AdvancedFilter( oDTSettings, init.aoAdvancedFilter || [] );
//                        console.debug('Pushing new feature AdvancedFilter, advancedFilter: '+JSON.stringify(advancedFilter));
//                        console.debug('Pushing new feature AdvancedFilter, advancedFilter.fnGetButton(): '+JSON.stringify(advancedFilter.fnGetButton()));
			return advancedFilter.fnGetButton();
		},
		"cFeature": "A",
		"sFeature": "AdvancedFilter"
	} );
} 
else {
    alert( "Warning: AdvancedFilter requires DataTables 1.9 or greater - www.datatables.net/download");
}  

// Make AdvancedFilter accessible from the DataTables instance
$.fn.dataTable.AdvancedFilter = AdvancedFilter;
$.fn.DataTable.AdvancedFilter = AdvancedFilter;
        
        
/*
 * Insert new Filtering function to process aoAdvancedFilter
 * 
 * @param {type} param
 */
$.fn.dataTableExt.afnFiltering.push( function( oSettings, aData, iDataIndex ) {
//    console.debug(iDataIndex+' oSettings.aoAdvancedFilter: '+JSON.stringify(oSettings.aoAdvancedFilter,null,"\t"));
    //console.debug('aData '+aData);
    //console.debug('iDataIndex '+iDataIndex);
    var result = true;
    if(oSettings.aoAdvancedFilter){
        for (var i=0; i<oSettings.aoAdvancedFilter.length; i++){
            //var sTitle = oSettings.aoAdvancedFilter[i].sTitle;
            var sTypeTemp, mDataTemp;
//            console.debug(i+' oSettings.aoColumns: '+JSON.stringify(oSettings.aoColumns,null,"\t"));
            for (var j=0; j<oSettings.aoColumns.length; j++){
            //console.debug(oSettings.aoColumns[j].sTitle+' === '+oSettings.aoAdvancedFilter[i].sTitle);
                if(oSettings.aoColumns[j].sTitle===oSettings.aoAdvancedFilter[i].sTitle){
                    sTypeTemp = oSettings.aoColumns[j].sType;
                    mDataTemp = oSettings.aoColumns[j].mData;
                    break;
                }
            }
//            console.debug('sTypeTemp: '+sTypeTemp+' ,mDataTemp: '+mDataTemp);
            var partialResult = false;
            for (var j=0; j<oSettings.aoAdvancedFilter[i].aoOperations.length; j++){
                var compareTo, value1, value2, value1temp, value2temp;
                value1temp = oSettings.aoAdvancedFilter[i].aoOperations[j].sValue1;
                value2temp = oSettings.aoAdvancedFilter[i].aoOperations[j].sValue2;
//                console.debug('['+aData[mDataTemp]+'],['+value1temp+'],['+value2temp+']');                
                //Prepare values
                if(sTypeTemp==="date-spain"){
                    var partsCompareTo = aData[mDataTemp].split('/');
                    compareTo = partsCompareTo[2] + partsCompareTo[1] + partsCompareTo[0];
                    var partsValue1 = value1temp.split('/');
                    if(typeof value2temp !== 'undefined') var partsValue2 = value2temp.split('/');
                    value1 = partsValue1[2] + partsValue1[1] + partsValue1[0];
                    if(typeof value2temp !== 'undefined') value2 = partsValue2[2] + partsValue2[1] + partsValue2[0];
                }else if(sTypeTemp==="numeric-comma"){
                    var replacedValue = aData[mDataTemp].replace( /\./, "" ).replace( /,/, "." );
                    compareTo = parseFloat( replacedValue );
                    value1 = parseFloat( value1temp.replace( /\./, "" ).replace( /,/, "." ));
                    if(typeof value2temp !== 'undefined') value2 = parseFloat( value2temp.replace( /\./, "" ).replace( /,/, "." ));
                }else if(sTypeTemp==="html"){
                    compareTo = $( aData[mDataTemp] ).text().toLowerCase().trim();
                    value1 = value1temp?value1temp.toLowerCase():value1temp;
                    if(typeof value2temp !== 'undefined') value2 = value2temp?value2temp.toLowerCase():value2temp;
                }else{
                    compareTo = aData[mDataTemp].toLowerCase();
                    value1 = value1temp?value1temp.toLowerCase():value1temp;
                    if(typeof value2temp !== 'undefined') value2 = value2temp?value2temp.toLowerCase():value2temp;
                }
                
                var operation = oSettings.aoAdvancedFilter[i].aoOperations[j].sOperation;
//                console.debug(oSettings.aoAdvancedFilter[i].sTitle+' '+mDataTemp+' - Type: '+sTypeTemp+', '+compareTo+' '+operation+' '+value1+' '+value2);                
                if(operation==="equals" && compareTo===value1){
                    partialResult = true; break;
                }else if(operation==="not-equals" && compareTo!==value1){
                    partialResult = true; break;
                }else if(operation==="contains" && compareTo.indexOf(value1)!==-1){
                    partialResult = true; break;
                }else if(operation==="not-contains" && compareTo.indexOf(value1)===-1){
                    partialResult = true; break;
                }else if(operation==="starts" && compareTo.indexOf(value1)===0 ){
                    partialResult = true; break;
                }else if(operation==="ends" && compareTo.indexOf(value1, compareTo.length - value1.length) !== -1){
                    partialResult = true; break;
                }else if((operation==="less" || operation==="before") && compareTo<value1){
                    partialResult = true; break;
                }else if((operation==="greater" || operation==="after") && compareTo>value1){
                    partialResult = true; break;
                }else if((operation==="less-equal" || operation==="before-and") && compareTo<=value1){
                    partialResult = true; break;
                }else if((operation==="greater-equal" || operation==="after-and") && compareTo>=value1){
                    partialResult = true; break;
                }else if(operation==="between" && compareTo>=value1 && compareTo<=value2){
                    partialResult = true; break;
                }else if(operation==="not-between" && (compareTo<value1 || compareTo>value2)){
                    partialResult = true; break;
                }
            }
            if(partialResult===false){
                return false;
            }
        }
    }
    return result;
});
        
        
/*
 * aoAdvancedFilter sample TO DELETE
 */      
//        oSettings.aoAdvancedFilter = [{
//                sTitle:"columnName",
//                iIndex:1,
////                sType: ["date","string","numeric","boolean"],
//                aoOperations:[{
//                        sOperation:["equal","notEqual","contains","notContains","starts","ends","less/before","greater/after","lessEqual/beforeAnd","greaterEqual/afterThan"],
//                        sValue1:"",
//                        sValue2:"",
//                        }]
//                }];
        
//
//        "equal";"notEqual";"contains";"notContains";"starts";"ends";"less/before";"greater/after";"lessEqual/beforeAnd";"greaterEqual/afterThan"
//        "=";"!=";"~";"!~";"^";"$";"<";">";"<=";">="
        

/*
 * Columns data types for datatable, Comma decimal separator
 * 
 * @param {type} param
 */
$.fn.dataTableExt.aTypes.unshift( function ( sData ) {
    var sValidChars = "0123456789,.";
    var Char;
    //var bDecimal = false;
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

/*
 * Sort extension for Comma decimal separator
 * 
 * @param {type} param1
 * @param {type} param2
 */
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

 /*
  * Columns data types for datatable, Spanish date
  */
 $.fn.dataTableExt.aTypes.unshift( function ( sData ) {
    if (sData !== null && sData.match(/(\d{2})\/(\d{2})\/(\d{4})/)){

        return 'date-spain';
    }
    return null;
 }); 

/*
 * Sort extension for Spanish date
 * 
 * @param {type} param1
 * @param {type} param2
 */
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

