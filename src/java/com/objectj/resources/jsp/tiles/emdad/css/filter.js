var ns6=document.getElementById&&!document.all;
var ie=document.all;
var theEntityL;
var elem;

function isInteger(value)
{   inputStr=value.toString();
    for(i=0;i<inputStr.length;i++)
    {
        var oneChar=inputStr.charAt(i);
        if((oneChar<"0") || (oneChar>"9"))
            return false;
    }
    return true;
}

function isDate(dateValue)
{
   date=dateValue.toString();
   var year = 0;
   var month = 0;
   var day = 0;
   if (date.length != 0){
        var d1 = date.indexOf("/");
        var temp = "";
        if (d1 == 4)
            temp = date.substring(0, 4);
        if (d1 == 2)
            temp = "13" + date.substring(0, 2);
        year = temp;
        date =  temp + "*" + date.substring(d1+1, date.length);
        var value = temp + "/";
        var d2 = date.indexOf("/");
        if (d2 == 6){
            temp = temp + "0" + date.substring(5, 6);
            value = value + "0" + date.substring(5, 6) + "/";
            month = date.substring(5,6);
        }
        if (d2 == 7){
             temp = temp + date.substring(5, 7);
             value = value + date.substring(5, 7) + "/";
             month = date.substring(5,7);
        }
        date =  temp + "*" + date.substring(d2 + 1, date.length);
        var d3 = date.length;
        if (d3 == 8){
            value = value + "0" + date.substring(7, 8);
            day = date.substring(7,8);
        }
        if (d3 == 9){
            value = value + date.substring(7, 9);
            day=date.substring(7,9);
        }

        if (value.length == 10)
            elem.value = value;

            if (month < 1 || month > 12) {
                 return false;
             }
             if (day < 1 || day > 32) {
                 return false;
             }
             if ((month > 6) && (day == 31)) {
                 return false;
             }
             if (month == 12) {
                 var leap = (((year - ( year + 45) / 33) % 4) == 0);
                 if (day>30 || (day == 30 && !leap)) {
                     return false;
                 }
             }
             }
             return true;
}

function checkForm()
{
	if (!advFilter() ) {
		alert("!\u062e\u0637\u0627"); //ERROR
		return;
	}
	close();
}

function cancel() {
	close();
}

function an() {
	if (ie) {
		tbl = document.all.srchTBL;
		nr = tbl.insertRow(tbl.rows.length-1);
		sr = tbl.rows[1];
		for (i=0; i<sr.cells.length; i++) {
			oCell=nr.insertCell();
			oCell.align="center";
			oCell.innerHTML = sr.cells[i].innerHTML;
		}
	} else {
	    var tbl     = document.getElementById("srchTBL");
		var tblBody = tbl.getElementsByTagName("tbody").item(0);
		sampRow = document.getElementById("sampRow");
		newRow = sampRow.cloneNode(true);
		tblBody.insertBefore(newRow,document.getElementById("endRow"));
	}

}

function getExpNs()
{
	ch = "";
	ml = document.filterForm;
	len = ml.length;
	expr = "";
	lastExpr = "";
	like = "";
	startwith = "";
	par = 0;
	bool = "";
	cont = 1;

	tbl     = document.getElementById("srchTBL");
	tblBody = tbl.getElementsByTagName("tbody").item(0);
	rows = tblBody.getElementsByTagName("tr");

	for (var j=1; cont==1 && j<rows.length-1; j++) {
		row = rows.item(j).getElementsByTagName("td");
		cc = row.length;
		//alert(row+","+cc);
		for (ii = 0; cont==1 && ii <cc; ii++) {
			e = row[ii].childNodes[1];
			//alert(e);
			cont = processElem(e);
		}
	}

	expr += lastExpr;
	if (par!=0) {
		alert("!\u062e\u0637\u0627 \u062f\u0631 \u067e\u0631\u0627\u0646\u062a\u0632\u0647\u0627"); //Grouping (Paranteses) Error.
		return "";
	}
	//alert(expr);
	if ( cont!=-1 ) {
		ml = document.exprForm;
		ml.cond.value=expr;
		ml.submit();
	}
	return "";
}

function isValid(t,v) {
    elem.value = v;
	if (t=="Integer") {
		if (!isInteger(v)) {
			return false;
		}
	} else if (t=="Date") {
		if (!isDate(v)) {
			return false;
		}
	}
	return true;
}

function processElem(e)
{
	if (e==null)
		return 1;
	elem = e;
	if (e.id == "gr2") {
		expr += lastExpr;
		if (e.value=="(") { par++; }
		lastExpr = bool + " "+e.value;
	} else {
		if (e.id!=="") {
			if (e.id=="bool") {
				bool = " "+e.value;
			} else {
				v1 = "";
				v2 = "";
				if (e.id=="val") {
					if (e.value=="") {
						question = confirm("\u0633\u0637\u0631(\u0647\u0627\u064a) \u062e\u0627\u0644\u064a \n\n \u060c\u0631\u0627 \u0627\u0646\u062a\u062e\u0627\u0628 \u06a9\u0646\u064a\u062f OK \u0627\u06af\u0631 \u0645\u0627\u064a\u0644\u064a\u062f \u0627\u0632 \u0627\u0648\u0644\u064a\u0646 \u062e\u0637 \u062e\u0627\u0644\u064a \u062a\u0627 \u0622\u062e\u0631\u064a\u0646 \u062e\u0637 \u0641\u064a\u0644\u062a\u0631 \u062f\u0631 \u0646\u0638\u0631 \u06af\u0631\u0641\u062a\u0647 \u0646\u0634\u0648\u0646\u062f\n.\u0631\u0627 \u0627\u0646\u062a\u062e\u0627\u0628 \u06a9\u0646\u064a\u062f Cancel \u062f\u0631\u063a\u064a\u0631 \u0627\u064a\u0646 \u0635\u0648\u0631\u062a") //Value Empty \n\n Ignore from the first empty value upto end of form and continue?
						if (expr=="" || question =="0"){
							e.focus();
							return -1;
						}
						lastExpr = "";
						return 0;
					}
					if (!isValid(type,e.value)) {
						e.focus();
                		alert("!\u062e\u0637\u0627 \u062f\u0631 \u0646\u0648\u0639 \u062f\u0627\u062f\u0647"); //Error in Data Type
						return -1;
					}
					e.value = elem.value;
					v1 = "'"+type.substring(0,1)+like ;
					v2 = like +"'";
					like = "";
					if (startwith!="") {
						v2 = startwith +"'";
					}
					startwith = "";
				} else {
					if (e.id=="operator") {
						if (e.value=="LIKE") {
							like = "%";
						} else {
							if (e.value=="START") {
								e.value = "LIKE";
								startwith = "%";
							}
						}
					} else {
						if (e.id=="gr1") {
							if (e.value==")") { par--; }
						} else {
							if (e.id=="field") {
								type = e.options[e.selectedIndex].id;
							}
						}
					}
				}
				lastExpr += " "+v1+e.value+v2;
			}
		}
	}
	return 1;
}

function getExpIe()
{
	ch = "";
	ml = document.filterForm;
	len = ml.elements.length;
	expr = "";
	lastExpr = "";
	like = "";
	type = "";
	startwith = "";
	par = 0;
	bool = "";
	cont = 1;

	for (var i = 0; cont==1 && i < len; i++) {
		var e = ml.elements[i];
		cont = processElem(e);
	}
	expr += lastExpr;
	if (par!=0) {
		alert("!\u062e\u0637\u0627 \u062f\u0631 \u067e\u0631\u0627\u0646\u062a\u0632\u0647\u0627");//Grouping (Paranteses) Error.
		return "";
	}
	if ( cont!=-1 ) {
		creator.id.value = expr;
		creator.action_type.value = "advanced_filter";
		creator.submit();
		close();
		return true;
	}
	return "";
}

function getExp()
{
	if (ie) {
		return getExpIe();
	}
	return getExpNs();
}
