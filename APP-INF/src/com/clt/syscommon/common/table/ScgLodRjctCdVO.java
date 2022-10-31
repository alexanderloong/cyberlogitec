/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgLodRjctCdVO.java
*@FileTitle : ScgLodRjctCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형 
* 1.0 Creation
=========================================================*/


package com.clt.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이도형
 * @since J2EE 1.5
 */

public class ScgLodRjctCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgLodRjctCdVO> models = new ArrayList<ScgLodRjctCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rjctRsnCdDesc = null;
	/* Column Info */
	private String spclCgoLodRjctRsnCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Trim */
	private String trim = "";
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgLodRjctCdVO() {}

	public ScgLodRjctCdVO(String ibflag, String pagerows, String spclCgoCateCd, String spclCgoLodRjctRsnCd, String rjctRsnCdDesc, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rjctRsnCdDesc = rjctRsnCdDesc;
		this.spclCgoLodRjctRsnCd = spclCgoLodRjctRsnCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rjct_rsn_cd_desc", getRjctRsnCdDesc());
		this.hashColumns.put("spcl_cgo_lod_rjct_rsn_cd", getSpclCgoLodRjctRsnCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trim", getTrim());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rjct_rsn_cd_desc", "rjctRsnCdDesc");
		this.hashFields.put("spcl_cgo_lod_rjct_rsn_cd", "spclCgoLodRjctRsnCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getRjctRsnCdDesc() {
		return this.rjctRsnCdDesc;
	}
	public String getSpclCgoLodRjctRsnCd() {
		return this.spclCgoLodRjctRsnCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getTrim() {
		return this.trim;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setRjctRsnCdDesc(String rjctRsnCdDesc) {
		this.rjctRsnCdDesc = rjctRsnCdDesc;
		//this.rjctRsnCdDesc=true;
	}
	public void setSpclCgoLodRjctRsnCd(String spclCgoLodRjctRsnCd) {
		this.spclCgoLodRjctRsnCd = spclCgoLodRjctRsnCd;
		//this.spclCgoLodRjctRsnCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
		//this.spclCgoCateCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setTrim(String trim) {
		this.trim = trim;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRjctRsnCdDesc(JSPUtil.getParameter(request, "rjct_rsn_cd_desc", ""));
		setSpclCgoLodRjctRsnCd(JSPUtil.getParameter(request, "spcl_cgo_lod_rjct_rsn_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, "spcl_cgo_cate_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public ScgLodRjctCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ScgLodRjctCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgLodRjctCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] rjctRsnCdDesc = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_cd_desc".trim(), length));
			String[] spclCgoLodRjctRsnCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_lod_rjct_rsn_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgLodRjctCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rjctRsnCdDesc[i] != null)
					model.setRjctRsnCdDesc(rjctRsnCdDesc[i]);
				if (spclCgoLodRjctRsnCd[i] != null)
					model.setSpclCgoLodRjctRsnCd(spclCgoLodRjctRsnCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getScgLodRjctCdVOs();
	}

	public ScgLodRjctCdVO[] getScgLodRjctCdVOs(){
		ScgLodRjctCdVO[] vos = (ScgLodRjctCdVO[])models.toArray(new ScgLodRjctCdVO[models.size()]);
		return vos;
	}
	
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnCdDesc = this.rjctRsnCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoLodRjctRsnCd = this.spclCgoLodRjctRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
