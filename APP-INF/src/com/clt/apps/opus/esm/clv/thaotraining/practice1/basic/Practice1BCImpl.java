/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice1BCImpl.java
*@FileTitle : ThaoTrainingPractice1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2022.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.thaotraining.practice1.basic;

import java.util.ArrayList;
import java.util.List;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.integration.Practice1DBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.vo.ErrMsgVO;

/**
 * ALPS-ThaoTraining Business Logic Command Interface<br>
 * - ALPS-ThaoTraining에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NguyenDinhThao
 * @since J2EE 1.6
 */
public class Practice1BCImpl extends BasicCommandSupport implements Practice1BC {

  // Database Access Object
  private transient Practice1DBDAO dbDao = null;

  /**
   * Practice1BCImpl 객체 생성<br>
   * Practice1DBDAO를 생성한다.<br>
   */
  public Practice1BCImpl() {
    dbDao = new Practice1DBDAO();
  }
  /**
   * [비즈니스대상]을 [행위] 합니다.<br>
   * 
   * @param ErrMsgVO errMsgVO
   * @return List<ErrMsgVO>
   * @exception EventException
   */
  public List < ErrMsgVO > MngErrMsgSearch(ErrMsgVO errMsgVO) throws EventException {
    try {
    	   
      return dbDao.MngErrMsgSearch(errMsgVO);

    } catch (DAOException ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);

    } catch (Exception ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    }

  }

  /**
   * [비즈니스대상]을 [행위] 합니다.<br>
   * 
   * @param ErrMsgVO[] errMsgVO
   * @param account SignOnUserAccount
   * @exception EventException
   */
  public void MngErrMsgMulti(ErrMsgVO[] errMsgVO, SignOnUserAccount account) throws EventException {
    try {
      List < ErrMsgVO > insertVoList = new ArrayList < ErrMsgVO > ();
      List < ErrMsgVO > updateVoList = new ArrayList < ErrMsgVO > ();
      List < ErrMsgVO > deleteVoList = new ArrayList < ErrMsgVO > ();
      
      ArrayList <String> row = new ArrayList<>();

      for (int i = 0; i < errMsgVO.length; i++) {
        if (errMsgVO[i].getIbflag().equals("I")) {
          errMsgVO[i].setCreUsrId(account.getUsr_id());
          
          if (dbDao.MngErrMsgCheckMsgCode(errMsgVO[i]).isEmpty() == false) {
         	  row.add(errMsgVO[i].getErrMsgCd());
         	  continue;
           }
        	   
          
          insertVoList.add(errMsgVO[i]);

        } else if (errMsgVO[i].getIbflag().equals("U")) {
          errMsgVO[i].setUpdUsrId(account.getUsr_id());
          updateVoList.add(errMsgVO[i]);

        } else if (errMsgVO[i].getIbflag().equals("D")) {
          deleteVoList.add(errMsgVO[i]);
        }
      }
      
      if (row.isEmpty() == false) {
    	  String code = row.get(0);
    	  
    	  for (int i = 1; i < row.size(); i++)
    		  code += ", " + row.get(i);
    	  
    	  throw new EventException(new ErrorHandler("ERR12356").getMessage().replace("$s", code));
      }

      if (insertVoList.size() > 0) {
        dbDao.addMngErrMsgMultiS(insertVoList);
      }

      if (updateVoList.size() > 0) {
        dbDao.modifyMngErrMsgMultiS(updateVoList);
      }

      if (deleteVoList.size() > 0) {
        dbDao.removeMngErrMsgMultiS(deleteVoList);
      }

    } catch (DAOException ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);

    } catch (Exception ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    }
  }

}