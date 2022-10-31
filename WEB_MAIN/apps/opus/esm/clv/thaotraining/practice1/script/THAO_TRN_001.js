/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : THAO_TRN_001.js
*@FileTitle : ThaoTrainingPractice1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2022.10.20 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class THAO_TRN_001 : THAO_TRN_001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/* Start */
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;

// Step 1
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// Step 2
function loadPage() {
	//generate Grid Layout
	
	ComConfigSheet(sheetObjects[0]);
	initSheet(sheetObjects[0], 1);
	ComEndConfigSheet(sheetObjects[0]);

	//auto search data after loading finish.
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

//Step 3
function initSheet(sheetObj, sheetNo) {
	switch (sheetNo) {
		case 1: // sheet1 init
			with(sheetObj) {
				// Setting Sheet
				SetConfig({SearchMode: 3, Page: 10});

				// Setting Header Sheet
				var info = {Sort: 0, ColMove: 0, HeaderCheck: 0, ColResize: 0};
				
				var HeadTitle = "STS|Del|Msg Cd|Msg Type|Msg Level|Message|Description";
				
				var headers = [{Text: HeadTitle, Align: "Center"}];
				
				InitHeaders(headers, info);

				// Setting Column
				var cols = [
		            {Type: "Status", Hidden: 0, Width: 50, Align: "Center",	ColMerge: 0, SaveName: "ibflag"},
					{Type: "DelCheck", Hidden: 0, Width: 50, Align: "Center", ColMerge: 0, SaveName: "del_chk"},
					{Type: "Text", Hidden: 0, Width: 100, Align: "Center", ColMerge: 0, SaveName: "err_msg_cd", KeyField: 1, UpdateEdit: 0, InsertEdit: 1, EditLen: 8},
					{Type: "Combo", Hidden: 0, Width: 130, Align: "Center", ColMerge: 0, SaveName: "err_tp_cd", KeyField: 1, UpdateEdit: 1, InsertEdit: 1, EditLen: 1, ComboCode: "S|B|D|P", ComboText: "SC|BC|DAO|Presentation Layer"},
					{Type: "Combo", Hidden: 0, Width: 100, Align: "Center", ColMerge: 0, SaveName: "err_lvl_cd", KeyField: 1, UpdateEdit: 1, InsertEdit: 1, EditLen: 1, ComboCode: "E|W|I|D|F", ComboText: "ERROR|WARN|INFO|DEBUG|FATAL"},
					{Type: "Text", Hidden: 0, Width: 600, Align: "Left", ColMerge: 0, SaveName: "err_msg", KeyField: 1, UpdateEdit: 1, InsertEdit: 1, EditLen: 100},
					{Type: "Text", Hidden: 0, Width: 100, Align: "Left", ColMerge: 0, SaveName: "err_desc", KeyField: 0, UpdateEdit: 1, InsertEdit: 1, EditLen: 100}
					];

				InitColumns(cols);
				SetEditable(1);
				SetWaitImageVisible(0);  // khác gì vs comopenwait
				
				ComResizeSheet(sheetObjects[0]);
			}
			break;
	}

}


// Step 4
function processButtonClick() {
	/** *** setting sheet object **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = ComGetEvent("name");
		
		if (srcName == null) {
			return;
		}
		
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				
				break;
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
				break; 
				
			case "btn_Add":
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
				break;
				
			default:
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
		} else {
			ComShowMessage(e.message);
		}
	}
}

// Step 5
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH;
			
			ComOpenWait(true);
		
//			sheetObj.DoSearch("THAO_TRN_001GS.do", FormQueryString(formObj));
			
			var xml = sheetObj.GetSearchData("THAO_TRN_001GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(xml);
	
			break;
			
		case IBSAVE: // Save
			formObj.f_cmd.value = MULTI;
	
			sheetObj.DoSave("THAO_TRN_001GS.do", FormQueryString(formObj));
			
			break;
			
		case IBINSERT: //Row Add button event
			sheetObj.DataInsert();
			
			break;
			
		case IBDOWNEXCEL: // Down excel button
	
			sheetObj.Down2Excel({DownCols: "err_msg_cd|err_tp_cd|err_lvl_cd|err_msg|err_desc"});

			break;
	}
}

// Sheet1 is ID sheet
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	
	if (Code === 0) {
		alert("Save successfully!");
	} else {
		alert("Save fail!");
	}
}


/* End */