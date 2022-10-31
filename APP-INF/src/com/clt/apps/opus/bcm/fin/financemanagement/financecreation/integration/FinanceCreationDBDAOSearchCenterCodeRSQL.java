/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FinanceCreationDBDAOSearchCenterCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2012.05.10 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.fin.financemanagement.financecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang-yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FinanceCreationDBDAOSearchCenterCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Center Code 조회
	  * </pre>
	  */
	public FinanceCreationDBDAOSearchCenterCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_erp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_erp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.fin.financemanagement.financecreation.integration").append("\n"); 
		query.append("FileName : FinanceCreationDBDAOSearchCenterCodeRSQL").append("\n"); 
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
		query.append("SELECT CTR_ERP_NO" ).append("\n"); 
		query.append("      ,CTR_ERP_CD" ).append("\n"); 
		query.append("      ,CTR_LOCL_NM" ).append("\n"); 
		query.append("      ,CTR_ENG_NM" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,CNT_CD" ).append("\n"); 
		query.append("      ,RGN_CD" ).append("\n"); 
		query.append("      ,JNL_SMRY_TRNS_FLG" ).append("\n"); 
		query.append("      ,BIZ_DIV_CD" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append(" 	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("  FROM GL_CTR_ERP" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("	1=1" ).append("\n"); 
		query.append("#if (${ctr_erp_no} != '')" ).append("\n"); 
		query.append("   AND CTR_ERP_NO = @[ctr_erp_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctr_erp_cd} != '')" ).append("\n"); 
		query.append("   AND CTR_ERP_CD = @[ctr_erp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}