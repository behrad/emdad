var theForm;
var theEntity;
var theEntityL;
var validateMethod = null;

function SetCheckAll(val)
{
	var len = theForm.elements.length;
	for (var i = 0; i < len; i++) {
		var e = theForm.elements[i];
		if (e.name == "selectedItems") {
			e.checked = val;
		}
	}
}

function checkOrClear() {
	obj = document.getElementById("selectDesAll");
    if (obj.checked == true){
        CheckAll();
    }else{
        ClearAll();
    }
}

function clearRefresh() {
	needRefresh = false;
}

function CheckAll()
{
	SetCheckAll(true);
}

function ClearAll()
{
	SetCheckAll(false);
}

function Delete()
{
	question = confirm("\u0622\u064a\u0627 \u0645\u0637\u0645\u0626\u0646\u064a\u062f \u06a9\u0647 \u0645\u064a \u062e\u0648\u0627\u0647\u064a\u062f \u0633\u0637\u0631\u0647\u0627\u064a \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u062f\u0647 \u0631\u0627 \u062d\u0630\u0641 \u06a9\u0646\u064a\u062f\u061f")
	if (question !="0"){
        do_Submit("Remove","d");
	}
}

function SureCancle()
{
	question = confirm("\u0622\u064a\u0627 \u0627\u0632 \u0627\u0646\u0635\u0631\u0627\u0641 \u0645\u0637\u0645\u0626\u0646 \u0647\u0633\u062a\u064a\u062f \u061f")
	if (question !="0"){
        do_Submit("read_all","l");
	}
}


function SureCancle2()
{
	question = confirm("\u0622\u064a\u0627 \u0627\u0632 \u0627\u0646\u0635\u0631\u0627\u0641 \u0645\u0637\u0645\u0626\u0646 \u0647\u0633\u062a\u064a\u062f \u061f")
	if (question !="0"){
		if (top) {
			top.close();
		} else {
	        	close();
		}
	}
}

function makeNew() {
    do_Submit("","c");
}

function setValidateMethod(validMethod) {
	alert(validMethod);
	validateMethod = validMethod;
}

function setForm(form) {
	theForm = form;
}

function setEntity(entity) {
	theEntity = entity;
	theEntityL = theEntity.substring(0,1).toLowerCase()+theEntity.substring(1);
}

function changePage(page) {
    theForm.curpage.value = page;
    do_Submit("read_all" ,"l");
}

function refreshPage() {
    if (isInteger(document.all.pageInput.value)) {
    	changePage(document.all.pageInput.value);
    }
}

function doEditCancel() {
    bCancel=true;
    doSubmit("l");
}

function isEmpty(value)
{ 
	if (value==null)
		return true;
	inputStr=value.toString();
    return inputStr.length<1;
}

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

function read(id) {
    theForm.id.value = id;
    do_Submit("read_by_id","r");
}

function edit(id) {
    theForm.id.value = id;
    do_Submit("edit_by_id","u");
}


function shoro(id) {
    theForm.id.value = id;
    do_Submit("specific,shoro","s");
}

function payan(id) {
    theForm.id.value = id;
    do_Submit("specific,payan","s");
}

function filter() {
    theForm.id.value = "";
    do_Submit("filter","l");
}

function report() {
    theForm.id.value = "";
    do_Submit("report","l");
}

function doAccept() {
    do_Submit("specific,accept","s");
}

function advfilter() {
    theForm.id.value = "";
    do_Submit("advanced_filter","l");
}

function clearfilter() {
    theForm.id.value = "";
    do_Submit("clear_filter","l");
}

function filter_s() {
if(document.all("searching")) document.all("searching").style.display ="inline";
    theForm.id.value = "";
    do_Submit("specific,filter","s");
}

function advfilter_s() {
    theForm.id.value = "";
    do_Submit("specific,advanced_filter","s");
}

function clearfilter_s() {
    theForm.id.value = "";
    do_Submit("specific,clear_filter","s");
}

function do_Submit(action,op) {
    //if ( theForm.action_type.value.indexOf("specific,")==0) {
    //	op = "s";
    //} else {
    //   theForm.action_type.value = action;
    //}
    theForm.action_type.value = action;
    doSubmit(op);
}

function doSubmit(op) {
    theForm.action="/emdad/"+op+"/"+theEntityL+".run";
    theForm.submit();
}

function sort(type){
    theForm.action="/emdad/l/"+theEntityL+".run";
    theForm.action_type.value = "read_all";
    sort2(type);
}

function sort2(type){
	if (theForm.sorttype.value != type)
		changeOrder = false;
	else
		changeOrder = true;
	theForm.sorttype.value = type;
	theForm.curpage.value = 1;
	if (changeOrder){
		if (theForm.order.value == "ASC" ){
			theForm.order.value = "DESC";
			document.images["sort"].src = "images/descending.gif";
		}
		else{
			theForm.order.value = "ASC";
			document.images["sort"].src = "images/ascending.gif";
		}
	}
    theForm.submit();
}

function fonoff() {
	img = document.images["filter"];
	rf0 = document.all.trFilter0;
	rf1 = document.all.trFilter1;
	if (img.src.indexOf("-off")>0) {
		img.src = "images/f-on.gif";
		rf0.style.display="none";
		rf1.style.display="none";
	}
	else {
		img.src = "images/f-off.gif";
		rf0.style.display="inline";
		rf1.style.display="inline";
	}
}

function popUpFilter (windowTitle, windowWidth, windowHeight) {
	args = "width=" + windowWidth + ", height=" + windowHeight + ", resizable=yes, scrollbars=yes, status=0";
	win2 = window.open("../com/objectj/emdad/jsp/" + theEntityL + ".filter.jsp", windowTitle, args);
    theForm.action="/emdad/l/"+theEntityL+".run";
	win2.creator=theForm;
}

function popUpFilter_s (windowTitle, windowWidth, windowHeight) {
	args = "width=" + windowWidth + ", height=" + windowHeight + ", resizable=yes, scrollbars=yes, status=0";
	win2 = window.open("../com/objectj/emdad/jsp/" + theEntityL + ".filter.jsp", windowTitle, args);
    theForm.action="/emdad/s/"+theEntityL+".run";
    theForm.action_type.value="specific,advanced_filter";
	win2.creator=theForm;
}

function showDetail2(vobj1,vobj2,imgid,divid,framename,url) {
	obj = document.getElementById(divid);
	img = document.getElementById(imgid);

	styl = obj.style;
	vobj = vobj1;
	if (vobj1.value=="") {
		if ((vobj2==null ) || (vobj2.value=="")) {
			return;
		}
		vobj = vobj2;
	}
	if(vobj.changed) { //vobj.value!=vobj.defaultValue) {
		document.frames[framename].location.href = url+"&id="+vobj.value;
		var df = document.frames[framename];
		document.lastCreator = obj;
		//vobj.defaultValue = vobj.value;
		vobj.changed = false;
	}
	img.src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-off.gif";
	styl.display = "inline";
}

function showDetail(vobj1,vobj2,imgid,divid,framename,url) {
	obj = document.getElementById(divid);
	img = document.getElementById(imgid);

	styl = obj.style;
	if (styl.display=="none") {
		vobj = vobj1;
		if (vobj1.value=="") {
			if ((vobj2==null ) || (vobj2.value=="")) {
				return;
			}
			vobj = vobj2;
		}
		if(vobj.changed) { //vobj.value!=vobj.defaultValue) {
			document.frames[framename].location.href = url+"&id="+vobj.value;
			var df = document.frames[framename];
			document.lastCreator = obj;
			//vobj.defaultValue = vobj.value;
			vobj.changed = false;
		}
		img.src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-off.gif";
		styl.display = "inline";
	} else {
		hideDetail(imgid,divid);
	}
}

function showDetailInNew(vobj1,vobj2,imgid,divid,framename,url) {
		vobj = vobj1;
		if (vobj1.value=="") {
			if ((vobj2==null ) || (vobj2.value=="")) {
				return;
			}
			vobj = vobj2;
		}
		if(vobj.changed) {
        	args = "width=700 , height=500 , resizable=yes, scrollbars=yes, status=0";
	        windowTitle = "";
	        win1 = window.open(url+"&id="+vobj.value , windowTitle, args);
		}

}

function hideDetail(imgid,divid) {
	obj = document.getElementById(divid);
	img = document.getElementById(imgid);

	styl = obj.style;
	CloseShow(this);
	styl.display = "none";
	img.src="/emdad/com/objectj/resources/jsp/tiles/emdad/images/show-on.gif";
}

function showDone() {
	this.creator = parent.document.lastCreator;
	OpenShow(this);
}

function OpenShow(obj) {
	ii = 0;
	while ( (obj.parent!=null) && (ii<10)) {
		if (obj.parent.creator!=null) {
			obj2 = obj.parent.creator;
			ii++;
			i = obj2.style.height;
			i = i.substring(0,i.length-2);
			obj2.style.height = parseInt(i)+200;
			obj = obj.parent;
		} else {
			return;
		}
	}
	return;
}

function CloseShow(obj) {
	return;
	ii = 0;
	while ( (obj.parent!=null) && (ii<10)) {
		if (obj.parent.creator!=null) {
			obj2 = obj.parent.creator;
			ii++;
			i = obj2.style.height;
			i = i.substring(0,i.length-2);
			obj2.style.height = parseInt(i)-200;
			obj = obj.parent;
		} else {
			return;
		}
	}
	return;
}

function doSearch(divId, url, creator) {
	args = "width=700 , height=500 , resizable=yes, scrollbars=yes, status=0";
	windowTitle = "Search";
	obj = document.getElementById(divId);
	win1 = window.open(url , windowTitle, args);
	win1.creator=creator;
}

function doSearchAndHide (divId, url, creator, imgid) {
	hideDetail(imgid,divId);
	doSearch(divId, url, creator);
}

function valueChanged(obj) {
	obj.changed = true;
}

function fastCombo(theList){
    var key;
    submitenter2(theList,window.event);
    if (window.event) {
        var now = (new Date()).getSeconds();
        if (now - document.all.fastComboHdn.lastTime>1) {
            document.all.fastComboHdn.value = "";
        }
        document.all.fastComboHdn.lastTime = now;
       document.all.fastComboHdn.value += String.fromCharCode(window.event.keyCode);

       setSelection( theList, document.all.fastComboHdn.value);
	window.event.returnValue = false;
    }
}

function Sabt(){
  var key;
  if (window.event) {
    key = window.event.keyCode;
        if(key == 83 && window.event.ctrlKey){
        window.event.returnValue = false;
        document.all.sabtBtn.click();
	    document.body.onkeydown = null;
	}
  }
}

function Jadid(){
  var key;
  if (window.event) {
   key = window.event.keyCode;
       if(key == 74 && window.event.ctrlKey){
        makeNew();}
      }
}

function setSelection(field,val) {

    var length = field.length;
    var vl = val.length;

    for (var i=0; i < length; i++) {
	   if (field.options[i].text.substring(0,vl) == val) {
		field.selectedIndex = i;
		  return;
	}
    }

}

function emptyFastCombo() {
    document.all.fastComboHdn.value = "";
}

function chkSabt(elem) {
	elem.disabled = true;
	theForm.submit();
}

function fitWidth(win) {
	win.moveTo(0,0);
	win.resizeTo(screen.width, screen.height/2);
}

function help() {
	window.open(document.all.helpUrl.value , "help", "resizable=yes, scrollbars=yes, status=0");		
}

function setHelpURL(url) {
	document.all.helpUrl.value=url;
}

/*
function rs(n,u,w,h,x) {
	args="width="+w+",height="+h+",resizable=yes,scrollbars=yes,status=0";
	remote=window.open(u,n,args);
	if (remote != null) {
	    if (remote.opener == null)
		remote.opener = self;
	}
	if (x == 1) { return remote; }
}
*/
	function moshtarakSearch() {
		doSearch("showMoshtari",
			"/emdad/com/objectj/emdad/jsp/general.findf.jsp?url=/emdad/s/moshtarak.run?action_type=specific,find",
			theForm);
	}