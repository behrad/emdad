function doFilterByEnter()
{
	if( window.event.keyCode == 13)
		filter();
}

function submitenter(myfield,e)
{
	//alert( "bb" );
	var key;
	if (window.event)
	   key = window.event.keyCode;
	else if (e)
	key = e.which;
//	alert(key);
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

function submitenter2(myfield,e)
{
	//alert( "bb" );
	var key;
	if (window.event)
	   key = window.event.keyCode;
	else if (e)
	key = e.which;
//	alert(key);
switch(String.fromCharCode(key)){
	case 'h' :
//	alert(key);
      window.event.keyCode = 1575;break;
    case 'H' :
      window.event.keyCode = 1570;break;
    case 's' :
      window.event.keyCode = 1587;break;
    case 'F' : case 'f':
      window.event.keyCode = 1576;break;
    case '`' :
      window.event.keyCode = 1662;break;
    case 'j' :case 'J':
      window.event.keyCode = 1578;break;
    case 'e' :case 'E': 
      window.event.keyCode = 1579;break;
    case '[' : 
      window.event.keyCode = 1580;break;
    case ']' :
      window.event.keyCode = 1670;break;
    case 'P' :case 'p':
      window.event.keyCode = 1581;break;
    case 'o' :case 'O':
      window.event.keyCode = 1582;break;
    case 'n' :case 'N' :
      window.event.keyCode = 1583;break;
    case 'b' :case 'B':
      window.event.keyCode = 1584;break;
    case 'V' :case 'v' :
      window.event.keyCode = 1585;break;
    case 'C' :case 'c' :
      window.event.keyCode = 1586;break;
    case '\\': 
      window.event.keyCode = 1688;break;
    case 's' :case 'S':
      window.event.keyCode = 1587;break;
    case 'a' :case 'A' :
      window.event.keyCode = 1588;break;
    case 'w' :case 'W': 
      window.event.keyCode = 1589;break;
    case 'q' :case 'Q':
      window.event.keyCode = 1590;break;
    case 'X' :case 'x':
      window.event.keyCode = 1591;break;
    case 'Z' :case 'z':
      window.event.keyCode = 1592;break;
    case 'U' :case 'u':
      window.event.keyCode = 1593;break;
    case 'Y' :case 'y':
      window.event.keyCode = 1594;break;
    case 't' :case 'T':
      window.event.keyCode = 1601;break;
    case 'R' :case 'r':
      window.event.keyCode = 1602;break;
    case ';': 
      window.event.keyCode = 1603;break;
    case '\'': 
      window.event.keyCode = 1711;break;
    case 'G': case 'g':
      window.event.keyCode = 1604;break;
    case 'l' :case 'L' :
      window.event.keyCode = 1605;break;
    case 'k' :case 'K':
      window.event.keyCode = 1606;break;
    case ',': 
      window.event.keyCode = 1608;break;
    case 'i' :case 'I':
      window.event.keyCode = 1607;break;
    case 'd' :
      window.event.keyCode = 1610;break;
    case 'D' :
      window.event.keyCode = 1740;break;
    case 'm' :case 'M':
      window.event.keyCode = 1574;break;
    case '?': 
      window.event.keyCode = 1567;break;
	  	
}

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

function help() {
	window.open(document.all.helpUrl.value , "help", "resizable=yes, scrollbars=yes, status=0");		
}

function checkLength(length) {
   return (window.event.srcElement.value.length < length);
}

/**function count(elem) {
	alert(elem);
	elem.disabled = true;
	alert(elem.disabled );
	return true;
	//counter++;
	//if(counter > 1) { return false; }
	//return true;
}**/ 