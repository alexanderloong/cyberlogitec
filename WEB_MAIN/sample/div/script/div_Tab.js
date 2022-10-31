/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : div_Tab.js
*@FileTitle  : Tan div sample page
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/22
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;

document.onclick=processButtonClick;

function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    var formObject=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName) {
	       	case "btn_retrieve":
	       		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	       		break;
	       	case "btn_downexcel":
	       		doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
	       		break;
	       	case "btn_grid_btn":
	       		break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		}else{
			ComShowMessage(e);
		}
	}
}

function setSheetObject(sheetObj){
	sheetObjects[sheetCnt++]=sheetObj;
}

function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
}

function initSheet(sheetObj,sheetNo) {
	var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
        	with(sheetObj){
	        	var headers = [ {Text:"순번|상태|삭제|개봉일|영화명|영문제목|감독|주연배우|등급", Align:"Center"} ];
	        	var info = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
	        	var cols = [
	        		{Type:"Seq",SaveName:"SEQ",Align:"Center"},
	        		{Type:"Status",Width:30,SaveName:"STATUS",Align:"Center"},
	        		{Type:"DelCheck",Width:50,SaveName:"DEL_CHK"},
	        		{Type:"Date",Width:85,SaveName:"OPEN_DATE",Format:"Ymd",Align:"Center"},
	        		{Type:"Text",Width:180,SaveName:"MOVIE_NM"},
	        		{Type:"Text",Width:120,SaveName:"ENG_NM"},
	        		{Type:"Text",Width:100,SaveName:"DIRECTOR"},
	        		{Type:"Text",Width:120,SaveName:"ACTOR"},
	        		{Type:"Combo",Width:50,SaveName:"FILM_RATE",Align:"Center",ComboText:"12세|15세|18세|전체|청불",ComboCode:"01|02|03|04|05"}
	        	];
	
        		InitHeaders(headers,info);
        		InitColumns(cols);
        		resizeSheet();
            }
        break;
        case "sheet2":
        	with(sheetObj){
        	var headers = [ {Text:"순번|상태|삭제|개봉일|영화명|영문제목|감독|주연배우|등급", Align:"Center"} ];
        	var info = {Sort:1,ColMove:1,ColResize:1,HeaderCheck:0};
        	var cols = [
        	            {Type:"Seq",SaveName:"SEQ",Align:"Center"},
        	            {Type:"Status",Width:30,SaveName:"STATUS",Align:"Center"},
        	            {Type:"DelCheck",Width:50,SaveName:"DEL_CHK"},
        	            {Type:"Date",Width:85,SaveName:"OPEN_DATE",Format:"Ymd",Align:"Center"},
        	            {Type:"Text",Width:180,SaveName:"MOVIE_NM"},
        	            {Type:"Text",Width:120,SaveName:"ENG_NM"},
        	            {Type:"Text",Width:100,SaveName:"DIRECTOR"},
        	            {Type:"Text",Width:120,SaveName:"ACTOR"},
        	            {Type:"Combo",Width:50,SaveName:"FILM_RATE",Align:"Center",ComboText:"12세|15세|18세|전체|청불",ComboCode:"01|02|03|04|05"}
        	            ];
        	
        	InitHeaders(headers,info);
        	InitColumns(cols);
        	resizeSheet();
        }
        	break;
    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
		case IBSEARCH:      //조회
			sheetObj.DoSearch("sample/div/datasource/Data.json?cacheblock="+new Date());
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel();
			break;
    }
}

function tab1_OnChange(tabObj , nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	beforetab=nItem;
	resizeSheet();
}

function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0 ;
				InsertItem( "tab1" , "");
				InsertItem( "tab2" , "");
			}
		break;
	}
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}