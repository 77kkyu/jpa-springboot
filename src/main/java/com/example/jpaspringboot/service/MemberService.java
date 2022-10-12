package com.example.jpaspringboot.service;

import com.example.jpaspringboot.domain.Member;
import com.example.jpaspringboot.domain.Team;
import com.example.jpaspringboot.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Log4j2
@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//@Transactional(readOnly = true)
	public Team proxyTest() {
		Optional<Member> member = memberRepository.findById(5L);
		if (member.isPresent())
			log.info("name : " + member.get().getTeam().getName());
		return member.get().getTeam();
	}
}