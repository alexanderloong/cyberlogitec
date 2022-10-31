/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : ThaoTrainingSC.java
*@FileTitle : ThaoTrainingPractice1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2022.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.thaotraining;

import java.util.List;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.basic.Practice1BC;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.basic.Practice1BCImpl;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.event.ThaoTrn001Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.clv.thaotraining.practice1.vo.ErrMsgVO;

/**
 * ALPS-ThaoTraining Business Logic ServiceCommand - ALPS-ThaoTraining 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author NguyenDinhThao
 * @see Practice1DBDAO
 * @since J2EE 1.6
 */

public class ThaoTrainingSC extends ServiceCommandSupport {
  // Login User Information
  private SignOnUserAccount account = null;

  /**
   * ThaoTraining system 업무 시나리오 선행작업<br>
   * 업무 시나리오 호출시 관련 내부객체 생성<br>
   */
  public void doStart() {
    log.debug("ThaoTrainingSC 시작");
    try {
      // 일단 comment --> 로그인 체크 부분
      account = getSignOnUserAccount();
    } catch (Exception e) {
      log.error(e.getLocalizedMessage());
    }
  }

  /**
   * ThaoTraining system 업무 시나리오 마감작업<br>
   * 업무 시나리오 종료시 관련 내부객체 해제<br>
   */
  public void doEnd() {
    log.debug("ThaoTrainingSC 종료");
  }

  /**
   * 각 이벤트에 해당하는 업무 시나리오 수행<br>
   * ALPS-ThaoTraining system 업무에서 발생하는 모든 이벤트의 분기처리<br>
   * 
   * @param e Event
   * @return EventResponse
   * @exception EventException
   */
  public EventResponse perform(Event e) throws EventException {
    // RDTO(Data Transfer Object including Parameters)
    EventResponse eventResponse = null;

    // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
    if (e.getEventName().equalsIgnoreCase("ThaoTrn001Event")) {
      if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        eventResponse = MngErrMsgSearch(e);  // Tai sao la event
      } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        eventResponse = MngErrMsgMulti(e);
      }
    }
    return eventResponse;
  }
  /**
   * THAO_TRN_001 : [이벤트]<br>
   * [비즈니스대상]을 [행위]합니다.<br>
   * 
   * @param Event e
   * @return EventResponse
   * @exception EventException
   */
  private EventResponse MngErrMsgSearch(Event e) throws EventException {
    // PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = new GeneralEventResponse();
    ThaoTrn001Event event = (ThaoTrn001Event) e; // Tai sao phai convert
    Practice1BC command = new Practice1BCImpl();

    try {
      List < ErrMsgVO > list = command.MngErrMsgSearch(event.getErrMsgVO());
      eventResponse.setRsVoList(list);	
    } catch (EventException ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    } catch (Exception ex) {
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    }
    return eventResponse;
  }
  /**
   * THAO_TRN_001 : [이벤트]<br>
   * [비즈니스대상]을 [행위]합니다.<br>
   *
   * @param Event e
   * @return EventResponse
   * @exception EventException
   */
  private EventResponse MngErrMsgMulti(Event e) throws EventException {
    // PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = new GeneralEventResponse();
    ThaoTrn001Event event = (ThaoTrn001Event) e;
    Practice1BC command = new Practice1BCImpl();
    try {
      begin();
      command.MngErrMsgMulti(event.getErrMsgVOS(), account);
      eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());

      commit();
    } catch (EventException ex) {
      rollback();
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    } catch (Exception ex) {
      rollback();
      throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    }
    return eventResponse;
  }
}