package edu.springboard.scheduler;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SampleScheduler {
	
	@Autowired
	SqlSession sqlSession; //스케쥴러는 dispatcherservlet 내에서 동작하므로 자동 의존 주입 가능

	@Scheduled(cron="* 0/1 * * * ? ") // 초 분 시 일 월 요일 연도 
	public void logScheduler() {
		System.out.println("매 분마다 호출 중...");
	}
	
}
