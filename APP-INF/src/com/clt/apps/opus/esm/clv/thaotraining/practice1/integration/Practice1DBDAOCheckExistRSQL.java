/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice1DBDAOCheckExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2022.10.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.thaotraining.practice1.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NguyenDinhThao
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Practice1DBDAOCheckExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check exist msg_code
	  * </pre>
	  */
	public Practice1DBDAOCheckExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.clv.thaotraining.practice1.integration ").append("\n"); 
		query.append("FileName : Practice1DBDAOCheckExistRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	ERR_MSG_CD" ).append("\n"); 
		query.append("FROM COM_ERR_MSG" ).append("\n"); 
		query.append("WHERE	ERR_MSG_CD = @[err_msg_cd]" ).append("\n"); 

	}
}