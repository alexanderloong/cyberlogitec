/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ErrorMessageDAOComErrMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.syscommon.management.opus.errormessage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ErrorMessageDAOComErrMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select error message   
	  * </pre>
	  */
	public ErrorMessageDAOComErrMsgVORSQL(){
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
		params.put("err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.syscommon.management.opus.errormessage.integration").append("\n"); 
		query.append("FileName : ErrorMessageDAOComErrMsgVORSQL").append("\n"); 
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
		query.append("SELECT                                                                " ).append("\n"); 
		query.append("   	err_msg_cd,  " ).append("\n"); 
		query.append(" 	err_lvl_cd,                      " ).append("\n"); 
		query.append("   	err_tp_cd,                                               " ).append("\n"); 
		query.append("   	err_msg,                                               " ).append("\n"); 
		query.append("   	err_desc                                                            " ).append("\n"); 
		query.append("FROM com_err_msg                                                      " ).append("\n"); 
		query.append("WHERE lang_tp_cd = 'ENG'" ).append("\n"); 
		query.append("#if (${err_msg_cd} != '') " ).append("\n"); 
		query.append("AND   err_msg_cd LIKE '%'||@[err_msg_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${err_msg} != '') " ).append("\n"); 
		query.append("and	UPPER(err_msg) like '%'||UPPER(@[err_msg])|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}