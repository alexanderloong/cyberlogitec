/*=========================================================
*Copyright(c) 2020 CyberLogitec
*@FileName : MuonSachSC.java
*@FileTitle : Muon Sach
*Open Issues :
*Change history :
*@LastModifyDate : 2020.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2020.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.dou.muonsach;

import java.util.List;
import com.clt.apps.opus.dou.muonsach.muonsach.basic.MuonSachBC;
import com.clt.apps.opus.dou.muonsach.muonsach.basic.MuonSachBCImpl;
import com.clt.apps.opus.dou.muonsach.muonsach.event.MuonsachEvent;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.dou.muonsach.muonsach.vo.MuonSachVO;


/**
 * ALPS-MuonSach Business Logic ServiceCommand - ALPS-MuonSach 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Vi Nguyen
 * @see MuonSachDBDAO
 * @since J2EE 1.6
 */

public class MuonSachSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * MuonSach system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("MuonSachSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MuonSach system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("MuonSachSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-MuonSach system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("MuonsachEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMuonSach(e);
			}
		}
		return eventResponse;
	}
	/**
	 * MuonSach : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMuonSach(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MuonsachEvent event = (MuonsachEvent)e;
		MuonSachBC command = new MuonSachBCImpl();

		try{
			List<MuonSachVO> list = command.searchMuonSach(event.getMuonSachVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}