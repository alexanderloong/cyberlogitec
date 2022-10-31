/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : UI_COM_SYS_009.jsp
*@FileTitle  : 사용자 매핑
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var sheetObjects=new Array();
var sheetCnt=0;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
	/**
	 * IBSheet Object를 배열로 등록
	 * comSheetObject(id)에서 호출한다
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화 
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
      var formObject=document.form;
    		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    		doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
    var cnt=0;
		sheetObj.UseUtf8=true;
		switch(sheetNo) {
             case 1:      //IBSheet1 init
            	    with(sheetObj){
			                 
			              // (4, 0, 0, true);
			               var HeadTitle="OfficeCode|English Office Name|Local Office Name";
			
			               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			
			               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			               var headers = [ { Text:HeadTitle, Align:"Center"} ];
			               InitHeaders(headers, info);
			
			               var cols = [ {Type:"Text",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TreeCol:1 ,  LevelSaveName:"level" },
			                      {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"ofc_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"ofc_krn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			                
			               InitColumns(cols);
			               SetCountPosition(0);
			               SetEditable(1);
//			               SetSheetHeight(280);
			               resizeSheet();
               }


             break;
			case 2:	  //IBSheet2 init
			    with(sheetObj){
		        
		      //(5, 0, 0, true);
				      var HeadTitle="|STS|User ID|User Name|User Local Name" ;
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"check_val" },
				             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"usr_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"usr_locl_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetCountPosition(0);
				      SetEditable(1);
//				      SetSheetHeight(280);
				      resizeSheet();
		            }

                                                 
               break;
		}
	}
	
	function resizeSheet(){
   	         ComResizeSheet(sheetObjects[0]);
   	         ComResizeSheet(sheetObjects[1]);
   }
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var sheetObject=sheetObjects[0];
		 var sheetObject1=sheetObjects[1];
		 /******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			/***********************************************************************************************************
				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.		
			 **********************************************************************************************************/
			switch(srcName) {
				case "btn_save":
					doActionIBSheet2(sheetObject1,formObject,IBSAVE);
					//ComClosePopup(); 
					break;
		      case "btn_close":
		    	  ComClosePopup(); 
		        break;
		      case "btn_DownExcel":
		    	  doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
        		break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(getMsg('COM12111'));
			} else {
				ComFuncErrMsg(e);
			}
		}
	}
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH01;
 				sheetObj.DoSearch("searchUserMapping.do", FormQueryString(formObj) );
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
 				sheetObj.Down2Excel({ HiddenColumn:true});
				break;
		}
	}
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH02;
 				sheetObj.DoSearch("searchUserMapping.do", FormQueryString(formObj) );
				break;
			case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("searchUserMapping.do", FormQueryString(formObj),"ibflag",false);
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
 				sheetObj.Down2Excel({ HiddenColumn:true});
				break;
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			/**
			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
			 */
			//if (!isNumber(formObj.iPage)) {
			//	return false;
		   // }
		}
		return true;
	}
  /**
   */
  function sheet1_OnDblClick(sheetObj, Row, Col) {
      var formObject=document.form;
formObject.ofc_cd.value=sheetObj.GetCellValue(Row,"ofc_cd");
    	doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
  }
  
  /**
   * 데이타를 저장한 후에 처리하는 함수
   * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
   */
  function sheet2_OnSaveEnd(sheetObj, code, msg, stCode, stMsg){
  	if(msg == null || msg == ""){
  		ComClosePopup(); 
    }
  }
