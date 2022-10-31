/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MessagesDAOComMgsRcvCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.syscommon.common.messages.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MessagesDAOComMgsRcvCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * receive message check query
	  * </pre>
	  */
	public MessagesDAOComMgsRcvCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.syscommon.common.messages.integration").append("\n"); 
		query.append("FileName : MessagesDAOComMgsRcvCheckRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("a.msg_id," ).append("\n"); 
		query.append("a.sndr_usr_id," ).append("\n"); 
		query.append("a.sndr_usr_nm," ).append("\n"); 
		query.append("a.msg_ctnt" ).append("\n"); 
		query.append("from com_msg_snd a, com_msg_rcv b" ).append("\n"); 
		query.append("where a.msg_id = b.msg_id" ).append("\n"); 
		query.append("and b.rcv_dt is null" ).append("\n"); 
		query.append("and b.rcvr_usr_id = @[usr_id]" ).append("\n"); 
		query.append("and b.delt_flg = 'N'" ).append("\n"); 
		query.append("and b.kep_flg = 'N'" ).append("\n"); 
		query.append("order by a.snd_dt" ).append("\n"); 

	}
}