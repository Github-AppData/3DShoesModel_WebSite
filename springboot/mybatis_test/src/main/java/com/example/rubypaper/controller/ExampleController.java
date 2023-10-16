package com.example.rubypaper.controller;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Balance;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.model.StorageType;
import net.nurigo.sdk.message.request.MessageListRequest;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.MessageListResponse;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class ExampleController {

    final DefaultMessageService messageService;

    public ExampleController() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
    	String api_key ="NCS7RXH7A199EHSV";
    	String api_secret ="8C0CQ16WGSRMQXRENXWDIPNEVCQ6COJB";
        this.messageService = NurigoApp.INSTANCE.initialize(api_key, api_secret, "https://api.coolsms.co.kr");
    }

    /**
     * 메시지 조회 예제
     */
    @GetMapping("/get-message-list")
    public MessageListResponse getMessageList() {
        // 검색 조건이 있는 경우에 MessagListRequest를 초기화 하여 getMessageList 함수에 파라미터로 넣어서 검색할 수 있습니다!.
        // 수신번호와 발신번호는 반드시 -,* 등의 특수문자를 제거한 01012345678 형식으로 입력해주셔야 합니다!
        MessageListRequest request = new MessageListRequest();

        // 검색할 건 수, 값 미지정 시 20건 조회, 최대 500건 까지 설정 가능
        // request.setLimit(1);

        // 조회 후 다음 페이지로 넘어가려면 조회 당시 마지막의 messageId를 입력해주셔야 합니다!
        // request.setStartKey("메시지 ID");

        // request.setTo("검색할 수신번호");
        // request.setFrom("검색할 발신번호");

        // 메시지 상태 검색, PENDING은 대기 건, SENDING은 발송 중,COMPLETE는 발송완료, FAILED는 발송에 실패한 모든 건입니다.
        /*
        request.setStatus(MessageStatusType.PENDING);
        request.setStatus(MessageStatusType.SENDING);
        request.setStatus(MessageStatusType.COMPLETE);
        request.setStatus(MessageStatusType.FAILED);
        */

        // request.setMessageId("검색할 메시지 ID");

        // 검색할 메시지 목록
        /*
        ArrayList<String> messageIds = new ArrayList<>();
        messageIds.add("검색할 메시지 ID");
        request.setMessageIds(messageIds);
         */

        // 조회 할 메시지 유형 검색, 유형에 대한 값은 아래 내용을 참고해주세요!
        // SMS: 단문
        // LMS: 장문
        // MMS: 사진문자
        // ATA: 알림톡
        // CTA: 친구톡
        // CTI: 이미지 친구톡
        // NSA: 네이버 스마트알림
        // RCS_SMS: RCS 단문
        // RCS_LMS: RCS 장문
        // RCS_MMS: RCS 사진문자
        // RCS_TPL: RCS 템플릿문자
        // request.setType("조회 할 메시지 유형");

        return this.messageService.getMessageList(request);
    }

    /**
     * 단일 메시지 발송 예제
     */
    
    @PostMapping("/send-one")
  
    
    @ResponseBody
    public Map<String, String> sendOne(@RequestBody Map<String, String> requestData) {
        String phoneNumber = requestData.get("phoneNumber");

        Random rand = new Random();
        int verificationCode = rand.nextInt(900000) + 100000;

        Message message = new Message();
        message.setFrom("01030613357");  // 발신 번호
        message.setTo(phoneNumber);      // 입력한 휴대폰 번호
        message.setText("본인인증 코드: " + verificationCode);

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("verificationCode", String.valueOf(verificationCode)); // 인증 코드 전달
        System.out.println("responeMap : " + responseMap);
        
        return responseMap;
    }
 
    /**
     * 잔액 조회 예제
     */
    @GetMapping("/get-balance")
    public Balance getBalance() {
        Balance balance = this.messageService.getBalance();
        System.out.println(balance);

        return balance;
    }
}
