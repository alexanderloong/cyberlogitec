/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice1BC.java
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

import java.util.List;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.vo.ErrMsgVO;

/**
 * ALPS-Thaotraining Business Logic Command Interface<br>
 * - ALPS-Thaotraining에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NguyenDinhThao
 * @since J2EE 1.6
 */

public interface Practice1BC {

  /**
   * [비즈니스대상]을 [행위] 합니다.<br>
   * 
   * @param ErrMsgVO	errMsgVO
   * @return List<ErrMsgVO>
   * @exception EventException
   */
  public List < ErrMsgVO > MngErrMsgSearch(ErrMsgVO errMsgVO) throws EventException;

  /**
   * [비즈니스대상]을 [행위] 합니다.<br>
   * 
   * @param ErrMsgVO[] errMsgVO
   * @param account SignOnUserAccount
   * @exception EventException
   */
  public void MngErrMsgMulti(ErrMsgVO[] errMsgVO, SignOnUserAccount account) throws EventException;
}