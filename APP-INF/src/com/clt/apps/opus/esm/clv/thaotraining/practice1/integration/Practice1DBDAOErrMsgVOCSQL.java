/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice1DBDAOErrMsgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2022.10.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.thaotraining.practice1.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NguyenDinhThao
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Practice1DBDAOErrMsgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log = Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public Practice1DBDAOErrMsgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.clv.thaotraining.practice1.integration").append("\n"); 
		query.append("FileName : Practice1DBDAOErrMsgVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("INSERT INTO COM_ERR_MSG (" ).append("\n"); 
		query.append("	EDW_UPD_DT" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	ERR_DESC" ).append("\n"); 
		query.append(",	ERR_MSG" ).append("\n"); 
		query.append(",	ERR_LVL_CD" ).append("\n"); 
		query.append(",	ERR_TP_CD" ).append("\n"); 
		query.append(",	LANG_TP_CD" ).append("\n"); 
		query.append(",	ERR_MSG_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'OPUSADM'" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[err_desc]" ).append("\n"); 
		query.append(",	@[err_msg]" ).append("\n"); 
		query.append(",	@[err_lvl_cd]" ).append("\n"); 
		query.append(",	@[err_tp_cd]" ).append("\n"); 
		query.append(",	'ENG'" ).append("\n"); 
		query.append(",	@[err_msg_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}