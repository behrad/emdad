// JavaScript Grid Control By Behrad Zari
var entities = new Array();
var grid_data = entities;
var cur_start = 0;
var size = 10;
var start_row = 2;
var pages = 0;

function submitenter(myfield,e)
{
	var key;
	if (window.event)
	   key = window.event.keyCode;
	else if (e)
	key = e.which;
	if ((key>=0x06A9) && (key<=0x06AE)){
		if (window.event)
		    window.event.keyCode= 0x0643;
		else if (e)
		   e.which=0x0643;
	}	   
	if (((key>=0x06CC) && (key<=0x06D1)) || (key==0x0649)){
		if (window.event)
		    window.event.keyCode= 0x064A;
		else if (e)
		   e.which=0x064A;
	}	   
	return true;
}

function Entity( id, name, gheimat ) {
	this.id = id;
	this.name = name;
	this.gheimat = gheimat;
}

function BY_ID( obj1, obj2 ) {
	if( obj1.id > obj2.id ) return 1;
	if( obj1.id == obj2.id ) return 0;
	if( obj1.id < obj2.id ) return -1;
}

function BY_NAME( obj1, obj2 ) {
	if( obj1.name > obj2.name ) return 1;
	if( obj1.name == obj2.name ) return 0;
	if( obj1.name < obj2.name ) return -1;
}

function BY_GHEIMAT( obj1, obj2 ) {
	return obj1.gheimat - obj2.gheimat;
}

function sortById() {
	grid_data.sort( BY_ID );
	renderGrid( mainGrid, grid_data, cur_start );
}

function sortByName() {
	grid_data.sort( BY_NAME );
	renderGrid( mainGrid, grid_data, cur_start );
}

function sortByGheimat() {
	grid_data.sort( BY_GHEIMAT );
	renderGrid( mainGrid, grid_data, cur_start );
}

function insert( row, entity, index ) {
	row.cells[0].innerHTML = index;
	row.cells[1].innerHTML = entity.id;
	row.cells[2].innerHTML = entity.name;
	row.cells[3].innerHTML = entity.gheimat;
}

function clearGrid() {
	var rows = grid.rows;
	for( i = start_row; i < rows.length; i++ )
		for( j = 0; j < rows[i].cells.length; j++ )
			rows[i].cells[j].innerHTML = "&nbsp;";			
	cur_start = 0;
}

function renderGrid( grid, data, start ) {
	if ( start < 0 || start >= data.length && data.length != 0 )
		return;
	clearGrid();
	var rows = grid.rows;
	grid_data = data;
	cur_start = start;
	for( i = 0; i < rows.length - start_row && i + cur_start < data.length; i++ ) {
		insert( rows[ i + start_row ], data[ cur_start + i ], cur_start + i + 1 );
	}		
	document.getElementById( "cur_page" ).innerHTML = ( cur_start + size ) / size;
	document.getElementById( "pages" ).innerHTML = Math.ceil( data.length / size );
	document.getElementById( "data_size" ).innerHTML = data.length;
}

function doFilter( filter_type ) {
	var filteredData = new Array();		
	switch ( filter_type ) {
		case 1 :
			filteredData = filterById( document.getElementById( "id" ).value );
			document.getElementById( "id" ).value = "";
			break;
		case 2 : 
			filteredData = filterByName( document.getElementById( "name" ).value );
			document.getElementById( "name" ).value = "";
			break;
		case 3 :
			filteredData = filterByTel( document.getElementById( "gheimat" ).value );
			document.getElementById( "gheimat" ).value = "";
			break;
	}
	renderGrid( mainGrid, filteredData, 0 );
	return false;
}

function filterById( key ) {
	var data = new Array();
	for( var i in entities ) {			
		if( findMatch( entities[i].id, key, "^" ) ) {
			data.push( entities[i] );
		}				
	}
	return data;
}

function filterByName( key ) {
	var data = new Array();
	for( var i in entities ) {
		if( findMatch( entities[i].name, key, "" ) ) {
			data.push( entities[i] );
		}				
	}
	return data;
}

function filterByGheimat( key ) {
	var data = new Array();
	for( var i in entities ) {
		if( key == entities[i].gheimat ) {
			data.push( entities[i] );
		}				
	}
	return data;
}

function clearFilter() {
	renderGrid( mainGrid, entities, 0 );
}

function findMatch( source, pattern, flag ) {		
	pattern = flag + pattern;
	if ( source.search( new RegExp( pattern, "i" ) ) < 0 )
		return false;
	return true;
}