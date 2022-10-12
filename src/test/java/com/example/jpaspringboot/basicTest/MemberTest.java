package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.repository.MemberRepository;
import com.example.jpaspringboot.service.MemberService;
import com.example.jpaspringboot.test.JpaServiceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private JpaServiceTest jpaServiceTest;

	@Autowired
	private MemberService memberService;

	@Test
	void proxyTest() {
		jpaServiceTest.proxyTest();
	}

}
