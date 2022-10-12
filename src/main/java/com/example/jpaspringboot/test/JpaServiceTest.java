package com.example.jpaspringboot.test;

import com.example.jpaspringboot.domain.Member;
import com.example.jpaspringboot.domain.Team;
import com.example.jpaspringboot.repository.MemberRepository;
import com.example.jpaspringboot.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class JpaServiceTest {
	private final MemberService memberService;
	private final MemberRepository memberRepository;

	@Transactional
	public void proxyTest() {
		Team team = memberService.proxyTest();
		log.info("team : " + team.toString());
		log.info("member1111 : " + team.getMembers().get(0).getTeam().getName());
		Member member = getMember(team);
		log.info("team name : " + member.getTeam().getName());
	}

	//@Transactional // no session error
	public Member getMember(Team team) {
		Optional<Member> member = memberRepository.findById(team.getMembers().get(0).getId());
		if (member.isPresent())
			log.info("member2222 : " + member.get().getUserName());
		return member.get();
	}
}