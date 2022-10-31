/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FinanceCreationDBDAOAddCenterCodeCSQL.java
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

public class FinanceCreationDBDAOAddCenterCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Create GL_CTR_ERP
	  * </pre>
	  */
	public FinanceCreationDBDAOAddCenterCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctr_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_erp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jnl_smry_trns_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.fin.financemanagement.financecreation.integration").append("\n"); 
		query.append("FileName : FinanceCreationDBDAOAddCenterCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_CTR_ERP" ).append("\n"); 
		query.append("           (CTR_ERP_NO" ).append("\n"); 
		query.append("           ,CTR_ERP_CD" ).append("\n"); 
		query.append("           ,CTR_LOCL_NM" ).append("\n"); 
		query.append("           ,CTR_ENG_NM" ).append("\n"); 
		query.append("	       ,CURR_CD" ).append("\n"); 
		query.append("           ,CNT_CD" ).append("\n"); 
		query.append("		   ,RGN_CD" ).append("\n"); 
		query.append("		   ,JNL_SMRY_TRNS_FLG" ).append("\n"); 
		query.append("		   ,BIZ_DIV_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("VALUES(@[ctr_erp_no]" ).append("\n"); 
		query.append("      ,@[ctr_erp_cd]" ).append("\n"); 
		query.append("      ,@[ctr_locl_nm]" ).append("\n"); 
		query.append("      ,@[ctr_eng_nm]" ).append("\n"); 
		query.append("	  ,@[curr_cd]" ).append("\n"); 
		query.append("      ,@[cnt_cd]" ).append("\n"); 
		query.append("	  ,@[rgn_cd]" ).append("\n"); 
		query.append("	  ,@[jnl_smry_trns_flg]" ).append("\n"); 
		query.append("	  ,@[biz_div_cd]" ).append("\n"); 
		query.append("	  ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}