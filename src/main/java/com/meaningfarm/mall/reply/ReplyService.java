package com.meaningfarm.mall.reply;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meaningfarm.mall.board.Board;
import com.meaningfarm.mall.board.BoardRepository;
import com.meaningfarm.mall.member.Member;
import com.meaningfarm.mall.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyService {

	private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    
    public String replyInsert(Reply reply, Member member, Integer boardNo){

    	Member findMember = memberRepository.findOneByMemberId(member.getMemberId());
        Board findBoard = boardRepository.findOneByBoardNo(boardNo);

        reply.setBoard(findBoard);
        reply.setMember(findMember);
        replyRepository.save(reply);

        return "board/boardList";
    }

    public String replyDelete(Reply reply){

        replyRepository.delete(reply);

        return "board/boardList";
    }

    
}
