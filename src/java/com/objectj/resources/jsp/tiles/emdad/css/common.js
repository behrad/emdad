 
function openHelpWindowFile(fileName) {
	helpWindow = window.open(fileName,'Help','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=300,height=400,top=100,left=100');
	helpWindow.focus();
}