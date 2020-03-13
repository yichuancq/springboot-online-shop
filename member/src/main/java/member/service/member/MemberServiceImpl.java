package member.service.member;

import member.domain.member.Member;
import member.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        assert (member != null);
        return memberRepository.save(member);
    }

    @Override
    public Member findOne(Member member) {
        //
        Example<Member> example = Example.of(member);
        Optional<Member> optional = memberRepository.findOne(example);
        if (optional.isPresent()) {
            member = optional.get();
            return member;
        } else {
            return null;
        }
    }

    @Override
    public Member modMemberInfo(Member member) {
        assert (member != null);
        return memberRepository.save(member);
    }
}
