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

var tabla_opciones;

var setUpDataTableOptions = function(msgs){

if(msgs && msgs.language){
    dataTablesLanguage = msgs.language;
}else{

    dataTablesLanguage = {
          processing:     "Procesando...",
          lengthMenu:     "Mostrar _MENU_ registros",
          zeroRecords:    "No se encontraron resultados",
          emptyTable:     "Ning&uacute;n dato disponible en esta tabla",
          info:           "Mostrando del _START_ al _END_ , Total _TOTAL_ registros",
          infoEmpty:      "Mostrando del 0 al 0 , Total 0 registros",
          infoFiltered:   "(filtrado de un total de _MAX_ registros)",
          infoPostFix:    "",
          search:         "Buscar:",
          advancedFilter: "Filtro Avanzado",
          loadingRecords: "Cargando...",
          paginate: {
              first:    "&lsaquo;&lsaquo;",
              last:     "&rsaquo;&rsaquo;",
              next:     "&rsaquo;",
              previous: "&lsaquo;"
          },
          aria: {
              sortAscending:  ": Activar para ordenar la columna de manera ascendente",
              sortDescending: ": Activar para ordenar la columna de manera descendente"
          }
      };
    }

   tabla_opciones = {
  //    "sPaginationType": "full_numbers",
//      "sPaginationType": "bootstrap",
      pageLength: 25,
      language: dataTablesLanguage,
      processing: true,
      pagingType: "full_numbers",
  //    "bAutoWidth": true,
  //    "sScrollX": "100%",
  //    "sScrollXInner": "150%",
  //    "bScrollCollapse": true,
      stateSave: true,       
      dom: "<'row'<'col-xs-6'l><'col-xs-6'fA>r>"+"t"+"<'row'<'col-xs-6'i><'col-xs-6'p>>",
//      dom: "<'row header'<'col-xs-6'l><'col-xs-6'fA>>" + "<'row tableContent'<'col-xs-12'rt>>" + "<'row footer'<'col-xs-6'i><'col-xs-6'p>>",
  //            "fnInitComplete" : function(settings, json) {
  //                $('.ColVis_Button').addClass('btn btn-default btn-sm').html('Columnas <i class="icon-arrow-down"></i>');
  //            }
      stateSaveParams: 	function ( settings, value ) {
  //        console.log('fnStateSaveParams sValue: '+JSON.stringify(sValue));
          value.aoAdvancedFilter = settings.aoAdvancedFilter;
  //        console.log('fnStateSaveParams settings.advancedFilter: '+JSON.stringify(settings.advancedFilter,null,'\t'));
  //        console.log('fnStateSaveParams sValue: '+JSON.stringify(sValue));
          return value;
      },
      stateLoadParams: function ( settings, data ) {
          //TODO
  //          console.log('fnStateLoadParams this '+JSON.stringify(this,null,'\t'));
  //        console.log('fnStateLoadParams oData: '+JSON.stringify(oData));

  //        console.log('fnStateLoadParams settings.advancedFilter: '+JSON.stringify(settings.init.advancedFilter,null,'\t'));
          if(data.aoAdvancedFilter){ 
  //            settings.instance.settings().advancedFilter = oData.advancedFilter; 
  //            settings.init.advancedFilter = oData.advancedFilter; 
            AdvancedFilter.fnSetAdvancedFilter(data.aoAdvancedFilter,this);
          }
  //        console.log('fnStateLoadParams settings.advancedFilter: '+JSON.stringify(settings.init.advancedFilter,null,'\t'));
  //        console.log('fnStateLoadParams oData: '+JSON.stringify(oData,null,'\t'));
          return true;
      }
   };

};
        
//FILTER JSON FORMAT, include into $.fn.dataTableExt
//https://datatables.net/docs/DataTables/1.9.4/DataTable.models.ext.html#features 

/*
 * AdvancedFilter Main Constructor CLASS
 * 
 * @param {type} settings
 * @param {type} init
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
            oDataTable: null,
            oInit: oInit
        };
            
        
        this.dom = {
            wrapper: null,
            button: null,
            active: null,
            foot: null
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
        
        var buttomFilter = $("#"+settings.tableId+"_ShowHideFilter");
        
        if(settings.instance.settings().aoAdvancedFilter && settings.instance.settings().aoAdvancedFilter.length>0){
            counterSpan = ' <span class="badge">'+settings.instance.settings().aoAdvancedFilter.length+'</span>';
        }
        
        buttomFilter.html('<i class="icon-filter"></i> '+settings.init.language.advancedFilter + counterSpan);
        
        this.dom.button = buttomFilter;
        
    },
    fnSetAdvancedFilter: function(advancedFilter, settings){
        
//        console.debug("setAdvancedFilter aoAdvancedFilter: "+JSON.stringify(aoAdvancedFilter));
        
//        var footer = settings.nTFoot;
        
        for (var i=0; i<advancedFilter.length; i++){
            
            var advFilterTitle = advancedFilter[i].sTitle;
            
            for (var j=0; j<settings.columns.length; j++){
                var dataTemp = settings.columns[j].mata;
                var titleTemp = settings.columns[j].title;
            
                if(advFilterTitle === titleTemp){
        
//        console.debug("setAdvancedFilter advancedFilter[i]: "+JSON.stringify(advancedFilter[i],null,"\t"));
                    
                    $('#operation_'+dataTemp).val(advancedFilter[i].operations[0].operation);
                    
                    $('#value1_'+dataTemp).val(advancedFilter[i].operations[0].value1);
                    
                    $('#value2_'+dataTemp).val(advancedFilter[i].operations[0].value2);

                }
                
            }
            
        }
        
        settings.instance.settings().advancedFilter = advancedFilter;
        
        this.fnSetCounter(settings);
        
        settings.instance.draw();
        
    },
    _fnConstruct: function ( settings, init ) {
        var that = this;
        this.dom.wrapper =document.createElement('div');
	this.dom.wrapper.className = "dataTables_advancedFilter";
        this.dom.wrapper.id = settings.tableId+"_advancedFilter";
        console.debug("AdvancedFilter._fnConstruct advancedFilter (init): "+init);
        this.dom.active = init && init.length>0;
//        console.debug("AdvancedFilter._fnConstruct dom.active: "+this.dom.active);
        
        that._fnCreateFilterForm( settings, init );

        this.dom.button = $( '<button/>', {
                        'class': this.dom.active ? "btn btn-default btn-xs active" : "btn btn-default btn-xs",
                        'id': settings.tableId+"_ShowHideFilter"
                } )
                .append( '<i class="icon-filter"></i> '+settings.init.language.advancedFilter )
                .bind(  "click", function (e) {
                        e.preventDefault();
                        that._fnToggle(settings, init );
                } )
                .appendTo( this.dom.wrapper )[0];
        
//      console.debug('AdvancedFilter._fnConstruct, init: '+JSON.stringify(init,null,"\t"));
        
        settings.instance.draw(); 
        
    },
    _fnCreateFilterForm: function ( settings, init ) {
        
        var that = this;
        
        var trFoot = $('<tr id="advanced-filter-form"/>');
        
//        console.debug("AdvancedFilter._createFilterForm tFoot: "+tFoot.html());
        
        for (var i=0; i<settings.columns.length; i++){
            var typeTemp = settings.columns[i].type;
            var dataTemp = settings.columns[i].data;
            var titleTemp = settings.columns[i].title;
//    console.debug('_createFilterForm settings.columns['+i+']: '+JSON.stringify(settings.columns[i],null,"\t"));
            
            var filter = that._fnFindFilterColumn(titleTemp, init);
//            console.debug("AdvancedFilter._createFilterForm settings.columns["+i+"]>filter: "+JSON.stringify(filter));
            
//            console.debug("AdvancedFilter._createFilterForm settings.columns["+i+"]: "+JSON.stringify(settings.columns[i]));
            var operationSelectElement = $('<select id="operation_'+dataTemp+'" class="form-control input-sm"/>').bind("change",function (e) {
				e.preventDefault();
                                if(this.value === "between" || this.value === "not-between"){
                                    $( this ).next().next().prop('disabled', false);
                                }else{
                                    $( this ).next().next().prop('disabled', true);
                                }
                                var index = $( "tfoot tr#advanced-filter-form th" ).index( $( this ).parent() );
                                var value1 = $( this ).next().val();
                                var value2 = $( this ).next().next().val();
				that._fnApplyAdvancedFilter(value1, value2, this.value, settings, init, index );
			});
            var value1FieldElement = $('<input type="text" id="value1_'+dataTemp+'" class="form-control input-sm"/>').bind("keyup",function (e) {
				e.preventDefault();
                                var index = $( "tfoot tr#advanced-filter-form th" ).index( $( this ).parent() );
                                var value2 = $( this ).next().val();
				that._fnApplyAdvancedFilter(this.value, value2, $( this ).siblings("select").val(), settings, init, index );
			});
            var value2FieldElement = $('<input type="text" id="value2_'+dataTemp+'" class="form-control input-sm" disabled/>').bind("keyup",function (e) {
				e.preventDefault();
                                var index = $( "tfoot tr#advanced-filter-form th" ).index( $( this ).parent() );
                                var value1 = $( this ).prev().val();
				that._fnApplyAdvancedFilter(value1, this.value, $( this ).siblings("select").val(), settings, init, index  );
			});
            
            
            if(typeTemp){
                
                //Only one operation from now
                if(filter && filter.operations[0]){
                    value1FieldElement.val(filter.operations[0].value1);
                    value2FieldElement.val(filter.operations[0].value2);
                }
                var optionsList;
                if(typeTemp.indexOf("date")!==-1){
                    //TODO
    //                value1FieldElement.datepicker();
    //                value2FieldElement.datepicker();
                    optionsList = ["equals","not-equals","before","after","before-and","after-and","between","not-between"];
                }else if(typeTemp.indexOf("numeric")!==-1){
                    optionsList = ["equals","not-equals","less","greater","less-equal","greater-equal","between","not-between"];
                }else {
                    optionsList = ["equals","not-equals","contains","not-contains","starts","ends","before","after","before-and","after-and","between","not-between"];
                }
                for(var j=0; j<optionsList.length; j++){
//                console.debug(optionsList[j]+': '+$.t(optionsList[j]));
                    var selected = (filter && filter.operations[0] && optionsList[j]===filter.operations[0].operation)?'selected':'';
                    operationSelectElement.append('<option value="'+optionsList[j]+'" ' +selected+'>'+ $.t(optionsList[j])+'</option>');;
                }
            
            }
            
            var thFoot = $('<th/>');
            
            if(typeTemp) thFoot.append(operationSelectElement).append(value1FieldElement).append(value2FieldElement);
            
            trFoot.append(thFoot);
            
        }
        
        trFoot.css("display","none");
        
        var tFoot = $('#'+settings.tableId+' > tfoot');
        
//        console.log('tFoot exist '+tFoot.length);
        
        if(tFoot.length){//check if exist
        
            tFoot.append(trFoot);
        
        }else{
            
            tFoot = $('<tfoot/>');
        
            tFoot.append(trFoot);

            $('#'+settings.tableId).append(tFoot);
            
        }
            
//        this.dom.foot = tFoot;
            
//            var aoFooter = settings.aoFooter[0];
//            console.debug("AdvancedFilter._createFilterForm aoFooter: "+JSON.stringify(aoFooter));
//            var tFoot = settings.tFoot;
//            console.debug("AdvancedFilter._createFilterForm tFoot: "+JSON.stringify(tFoot));
            
        settings.tFoot = tFoot;
        
//        console.debug("AdvancedFilter._createFilterForm tFoot: "+tFoot.html());
        
//        console.debug("AdvancedFilter._createFilterForm tableId: "+$('#'+settings.tableId).html());

        if(this.dom.active === true) $('#'+settings.tableId+' tfoot').slideDown( "slow" );
        
//        $('#'+settings.tableId+"_ShowHideFilter").removeClass("active");
        
    },
    _fnToggle: function ( settings, init ) {
        
//        var that = this;
        
//        console.debug("AdvancedFilter._toggle hasClass.active "+$('#'+settings.tableId+"_ShowHideFilter").hasClass("active"));
        
        if(!$('#'+settings.tableId+"_ShowHideFilter").hasClass("active")){
             $('#'+settings.tableId+' tfoot tr#advanced-filter-form').slideDown( "slow" );
             $('#'+settings.tableId+"_ShowHideFilter").addClass("active");
        }else{
             $('#'+settings.tableId+' tfoot tr#advanced-filter-form').slideUp( "slow" );
             $('#'+settings.tableId+"_ShowHideFilter").removeClass("active");
        }
//        console.debug("AdvancedFilter._toggle hasClass.active "+$('#'+settings.tableId+"_ShowHideFilter").hasClass("active"));
        
    },
    _fnFindFilterColumn: function ( title, init ) {
        
//        var that = this;
        
        for (var i=0; i<init.length; i++){
            
            if(title===init[i].title){
                return init[i];
            }  
            
        }
        
    },
    _fnApplyAdvancedFilter: function (value1, value2, operation, settings, init, dataTemp  ) {
        var titleTemp;
        for (var j=0; j<settings.columns.length; j++){
            if(settings.columns[j].data===dataTemp){
                titleTemp = settings.columns[j].title;
                break;
            }
        }
//        console.debug('_applyAdvancedFilter value1: '+value1+', value2: '+value2+', operation: '+operation+', titleTemp: '+titleTemp+', dataTemp: '+dataTemp);
        
        if(!settings.advancedFilter){
            settings.advancedFilter = [];
        }
//    console.debug('_applyAdvancedFilter settings.advancedFilter: '+JSON.stringify(settings.advancedFilter,null,"\t"));
        
        var found = false;
        
        for (var i=0; i<settings.advancedFilter.length; i++){
            
            if(settings.advancedFilter[i].title===titleTemp){
                
                if(value1===""){
                    settings.advancedFilter.splice(i, 1);
                }else{
                    settings.advancedFilter[i].index = dataTemp;
                    settings.advancedFilter[i].operations = [{
                                operation:operation,
                                value1:value1,
                                value2:value2
                                }] ;
                }
                
                found = true;
            
                break;
            }
        }
//    console.debug('_applyAdvancedFilter found: '+found);
        
        if(!found && value1!==""){
//    console.debug('_applyAdvancedFilter titleTemp: '+JSON.stringify(titleTemp,null,"\t"));
            
            var filter = {
                        title:titleTemp,
                        index:dataTemp,
                        operations:[{
                                operation:operation,
                                value1:value1,
                                value2:value2
                                }]
                    };
        
//    console.debug('_applyAdvancedFilter filter: '+JSON.stringify(filter,null,"\t"));
            
             settings.advancedFilter.push(filter);
        }
        
        this.fnSetCounter(settings);
        
//    console.debug('_applyAdvancedFilter settings.advancedFilter: '+JSON.stringify(settings.advancedFilter,null,"\t"));
        settings.instance.draw(); 
    }
};

/*
* Static object methods
*/

/**
 * Rebuild the collection for a given table, or all tables if no parameter given
 *  @method  AdvancedFilter.setAdvancedFilter
 *  @static
 *  @param   advancedFilter JSON with the advanced filter
 *  @param   oTable DataTable instance to consider - optional
 *  @returns void
 */
AdvancedFilter.fnSetAdvancedFilter = function ( advancedFilter, oTable )
{
	var table = null;
        console.log('.setAdvancedFilter oTable '+JSON.stringify(oTable));
	if ( typeof oTable !== 'undefined' )
	{
		table = oTable.settings().table;
	}
        
//        console.debug('.setAdvancedFilter table: '+table);
        
//        console.debug('.setAdvancedFilter AdvancedFilter.aInstances.length: '+AdvancedFilter.aInstances.length);

	for ( var i=0, len=AdvancedFilter.aInstances.length ; i<len ; i++ )
	{
		if ( typeof oTable === 'undefined' || table === AdvancedFilter.aInstances[i].s.oDataTable.table )
		{
        
//                        console.debug('AdvancedFilter.aInstances[i].s.oDataTable.table: '+AdvancedFilter.aInstances[i].s.oDataTable.table);
			AdvancedFilter.aInstances[i].setAdvancedFilter(advancedFilter, AdvancedFilter.aInstances[i].s.oDataTable);
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
		"fnInit": function( settings ) {
			var init = settings.init;
                        console.debug('Pushing new feature AdvancedFilter, init: '+JSON.stringify(init,null,"\t"));
			var advancedFilter = new AdvancedFilter( settings, init.advancedFilter || [] );
//                        console.debug('Pushing new feature AdvancedFilter, advancedFilter: '+JSON.stringify(advancedFilter));
//                        console.debug('Pushing new feature AdvancedFilter, advancedFilter.getButton(): '+JSON.stringify(advancedFilter.getButton()));
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
 * Insert new Filtering function to process advancedFilter
 * 
 * @param {type} param
 */
$.fn.dataTableExt.afnFiltering.push( function( settings, data, iDataIndex ) {
//    console.debug(iDataIndex+' settings.advancedFilter: '+JSON.stringify(settings.advancedFilter,null,"\t"));
    //console.debug('data '+data);
    //console.debug('iDataIndex '+iDataIndex);
    var result = true;
    if(settings.advancedFilter){
        for (var i=0; i<settings.advancedFilter.length; i++){
            //var title = settings.advancedFilter[i].title;
            var typeTemp, dataTemp;
//            console.debug(i+' settings.columns: '+JSON.stringify(settings.columns,null,"\t"));
            for (var j=0; j<settings.columns.length; j++){
            //console.debug(settings.columns[j].title+' === '+settings.advancedFilter[i].title);
                if(settings.columns[j].title===settings.advancedFilter[i].title){
                    typeTemp = settings.columns[j].type;
                    dataTemp = settings.columns[j].data;
                    break;
                }
            }
//            console.debug('typeTemp: '+typeTemp+' ,dataTemp: '+dataTemp);
            var partialResult = false;
            for (var j=0; j<settings.advancedFilter[i].operations.length; j++){
                var compareTo, value1, value2, value1temp, value2temp;
                value1temp = settings.advancedFilter[i].operations[j].value1;
                value2temp = settings.advancedFilter[i].operations[j].value2;
//                console.debug('['+data[dataTemp]+'],['+value1temp+'],['+value2temp+']');                
                //Prepare values
                if(typeTemp==="date-spain"){
                    var partsCompareTo = data[dataTemp].split('/');
                    compareTo = partsCompareTo[2] + partsCompareTo[1] + partsCompareTo[0];
                    var partvalue1 = value1temp.split('/');
                    if(typeof value2temp !== 'undefined') var partvalue2 = value2temp.split('/');
                    value1 = partvalue1[2] + partvalue1[1] + partvalue1[0];
                    if(typeof value2temp !== 'undefined') value2 = partvalue2[2] + partvalue2[1] + partvalue2[0];
                }else if(typeTemp==="numeric-comma"){
                    var replacedValue = data[dataTemp].replace( /\./, "" ).replace( /,/, "." );
                    compareTo = parseFloat( replacedValue );
                    value1 = parseFloat( value1temp.replace( /\./, "" ).replace( /,/, "." ));
                    if(typeof value2temp !== 'undefined') value2 = parseFloat( value2temp.replace( /\./, "" ).replace( /,/, "." ));
                }else if(typeTemp==="html"){
                    compareTo = $( data[dataTemp] ).text().toLowerCase().trim();
                    value1 = value1temp?value1temp.toLowerCase():value1temp;
                    if(typeof value2temp !== 'undefined') value2 = value2temp?value2temp.toLowerCase():value2temp;
                }else{
                    compareTo = data[dataTemp].toLowerCase();
                    value1 = value1temp?value1temp.toLowerCase():value1temp;
                    if(typeof value2temp !== 'undefined') value2 = value2temp?value2temp.toLowerCase():value2temp;
                }
                
                var operation = settings.advancedFilter[i].operations[j].operation;
//                console.debug(settings.advancedFilter[i].title+' '+dataTemp+' - Type: '+typeTemp+', '+compareTo+' '+operation+' '+value1+' '+value2);                
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
 * advancedFilter sample TO DELETE
 */      
//        settings.advancedFilter = [{
//                title:"columnName",
//                index:1,
////                type: ["date","string","numeric","boolean"],
//                operations:[{
//                        operation:["equal","notEqual","contains","notContains","starts","ends","less/before","greater/after","lessEqual/beforeAnd","greaterEqual/afterThan"],
//                        value1:"",
//                        value2:"",
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
        var b = a.match(/(\d{2})\/(\d{2})\/(\d{4})/);
        var tt = "00000000";
        if(b){
            var day = b[1];
            var month = b[2];
            var year = b[3];

            tt = year+month+day;
        }
        return  tt;
    },
    "date-spain-asc": function ( a, b ) {
        return a - b;
    },
    "date-spain-desc": function ( a, b ) {
        return b - a;
    }
 }); 

