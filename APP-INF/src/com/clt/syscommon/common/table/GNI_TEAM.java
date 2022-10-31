/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : GNI_TEAM.java
*@FileTitle : 결합테스트 현황
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Seongwook_kim
*@LastVersion : 1.0
* 2006-12-20 Seongwook_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author Seongwook_kim
 * @since J2EE 1.4
 */
public final class GNI_TEAM implements java.io.Serializable {

	private String      ibflag      = "";
	private String      page_rows   = "";
	private String      team_cd     = "";
	private String      team_nm     = "";
	private String      team_krn_nm = "";
	private String      dp_seq      = "";
	private String      cre_usr_id  = "";
	private String      cre_dt      = "";
	private String      upd_usr_id  = "";
	private String      upd_dt      = "";

	public GNI_TEAM(){}

	public GNI_TEAM(
			String      ibflag     ,
			String      page_rows  ,
			String      team_cd    ,
			String      team_nm    ,
			String      team_krn_nm,
			String      dp_seq     ,
			String      cre_usr_id ,
			String      cre_dt     ,
			String      upd_usr_id ,
			String      upd_dt     ){
		this.ibflag      = ibflag     ;
		this.page_rows   = page_rows  ;
		this.team_cd     = team_cd    ;
		this.team_nm     = team_nm    ;
		this.team_krn_nm = team_krn_nm;
		this.dp_seq      = dp_seq     ;
		this.cre_usr_id  = cre_usr_id ;
		this.cre_dt      = cre_dt     ;
		this.upd_usr_id  = upd_usr_id ;
		this.upd_dt      = upd_dt     ;
	}

	// getter method is proceeding ..
	public String      getIbflag     (){	return ibflag     	;	}
	public String      getPage_rows  (){	return page_rows  	;	}
	public String      getTeam_cd    (){	return team_cd    	;	}
	public String      getTeam_nm    (){	return team_nm    	;	}
	public String      getTeam_krn_nm(){	return team_krn_nm	;	}
	public String      getDp_seq     (){	return dp_seq     	;	}
	public String      getCre_usr_id (){	return cre_usr_id 	;	}
	public String      getCre_dt     (){	return cre_dt     	;	}
	public String      getUpd_usr_id (){	return upd_usr_id 	;	}
	public String      getUpd_dt     (){	return upd_dt     	;	}

	// setter method is proceeding ..
	public void setIbflag     ( String      ibflag      ){	this.ibflag      = ibflag     	;	}
	public void setPage_rows  ( String      page_rows   ){	this.page_rows   = page_rows  	;	}
	public void setTeam_cd    ( String      team_cd     ){	this.team_cd     = team_cd    	;	}
	public void setTeam_nm    ( String      team_nm     ){	this.team_nm     = team_nm    	;	}
	public void setTeam_krn_nm( String      team_krn_nm ){	this.team_krn_nm = team_krn_nm	;	}
	public void setDp_seq     ( String      dp_seq      ){	this.dp_seq      = dp_seq     	;	}
	public void setCre_usr_id ( String      cre_usr_id  ){	this.cre_usr_id  = cre_usr_id 	;	}
	public void setCre_dt     ( String      cre_dt      ){	this.cre_dt      = cre_dt     	;	}
	public void setUpd_usr_id ( String      upd_usr_id  ){	this.upd_usr_id  = upd_usr_id 	;	}
	public void setUpd_dt     ( String      upd_dt      ){	this.upd_dt      = upd_dt     	;	}

	public static GNI_TEAM fromRequest(HttpServletRequest request) {
		GNI_TEAM model = new GNI_TEAM();
		try {
			model.setIbflag     	(JSPUtil.getParameter(request, "ibflag     		".trim(), ""));
			model.setPage_rows  	(JSPUtil.getParameter(request, "page_rows  		".trim(), ""));
			model.setTeam_cd    	(JSPUtil.getParameter(request, "team_cd    		".trim(), ""));
			model.setTeam_nm    	(JSPUtil.getParameter(request, "team_nm    		".trim(), ""));
			model.setTeam_krn_nm	(JSPUtil.getParameter(request, "team_krn_nm		".trim(), ""));
			model.setDp_seq     	(JSPUtil.getParameter(request, "dp_seq     		".trim(), ""));
			model.setCre_usr_id 	(JSPUtil.getParameter(request, "cre_usr_id 		".trim(), ""));
			model.setCre_dt     	(JSPUtil.getParameter(request, "cre_dt     		".trim(), ""));
			model.setUpd_usr_id 	(JSPUtil.getParameter(request, "upd_usr_id 		".trim(), ""));
			model.setUpd_dt     	(JSPUtil.getParameter(request, "upd_dt     		".trim(), ""));
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		GNI_TEAM model = null;
		Collection models = new ArrayList();
		try {
			String[] ibflag      =  (JSPUtil.getParameter(request, "ibflag     		".trim(), length));
			String[] page_rows   =  (JSPUtil.getParameter(request, "page_rows  		".trim(), length));
			String[] team_cd     =  (JSPUtil.getParameter(request, "team_cd    		".trim(), length));
			String[] team_nm     =  (JSPUtil.getParameter(request, "team_nm    		".trim(), length));
			String[] team_krn_nm =  (JSPUtil.getParameter(request, "team_krn_nm		".trim(), length));
			String[] dp_seq      =  (JSPUtil.getParameter(request, "dp_seq     		".trim(), length));
			String[] cre_usr_id  =  (JSPUtil.getParameter(request, "cre_usr_id 		".trim(), length));
			String[] cre_dt      =  (JSPUtil.getParameter(request, "cre_dt     		".trim(), length));
			String[] upd_usr_id  =  (JSPUtil.getParameter(request, "upd_usr_id 		".trim(), length));
			String[] upd_dt      =  (JSPUtil.getParameter(request, "upd_dt     		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new GNI_TEAM();
				model.setIbflag     		  (ibflag     	[i]);
				model.setPage_rows  		  (page_rows  	[i]);
				model.setTeam_cd    		  (team_cd    	[i]);
				model.setTeam_nm    		  (team_nm    	[i]);
				model.setTeam_krn_nm		  (team_krn_nm	[i]);
				model.setDp_seq     		  (dp_seq     	[i]);
				model.setCre_usr_id 		  (cre_usr_id 	[i]);
				model.setCre_dt     		  (cre_dt     	[i]);
				model.setUpd_usr_id 		  (upd_usr_id 	[i]);
				model.setUpd_dt     		  (upd_dt     	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		GNI_TEAM model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues("ibflag").length;
		try {
			String[] ibflag      =  (JSPUtil.getParameter(request, prefix + "ibflag     		".trim(), length));
			String[] page_rows   =  (JSPUtil.getParameter(request, prefix + "page_rows  		".trim(), length));
			String[] team_cd     =  (JSPUtil.getParameter(request, prefix + "team_cd    		".trim(), length));
			String[] team_nm     =  (JSPUtil.getParameter(request, prefix + "team_nm    		".trim(), length));
			String[] team_krn_nm =  (JSPUtil.getParameter(request, prefix + "team_krn_nm		".trim(), length));
			String[] dp_seq      =  (JSPUtil.getParameter(request, prefix + "dp_seq     		".trim(), length));
			String[] cre_usr_id  =  (JSPUtil.getParameter(request, prefix + "cre_usr_id 		".trim(), length));
			String[] cre_dt      =  (JSPUtil.getParameter(request, prefix + "cre_dt     		".trim(), length));
			String[] upd_usr_id  =  (JSPUtil.getParameter(request, prefix + "upd_usr_id 		".trim(), length));
			String[] upd_dt      =  (JSPUtil.getParameter(request, prefix + "upd_dt     		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new GNI_TEAM();
				model.setIbflag     		  ( ibflag     	[i]);
				model.setPage_rows  		  ( page_rows  	[i]);
				model.setTeam_cd    		  ( team_cd    	[i]);
				model.setTeam_nm    		  ( team_nm    	[i]);
				model.setTeam_krn_nm		  ( team_krn_nm	[i]);
				model.setDp_seq     		  ( dp_seq     	[i]);
				model.setCre_usr_id 		  ( cre_usr_id 	[i]);
				model.setCre_dt     		  ( cre_dt     	[i]);
				model.setUpd_usr_id 		  ( upd_usr_id 	[i]);
				model.setUpd_dt     		  ( upd_dt     	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}

	// toString() method is overriding ..
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space="                              ";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr=null;
				try {
					arr = (String[]) field[i].get(this);
				}catch(Exception ex) {
					arr=new String[1];
					arr[0]=String.valueOf(field[i].get(this));
				}
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0,30).concat("= ") + arr[j] +"\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}

}
