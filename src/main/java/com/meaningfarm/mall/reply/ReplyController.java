package com.meaningfarm.mall.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.meaningfarm.mall.member.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {

	@Autowired
    private final ReplyService replyService;
	
	@PostMapping("/replyInsert")
    public String replyWrite(@ModelAttribute Reply reply, Integer boardNo, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            Member member){

        return replyService.replyInsert(reply, member, boardNo);

    }

    @PostMapping("/replyDelete")
    public String replyDelete(@ModelAttribute Reply reply, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
    	Member member){


        return replyService.replyDelete(reply);
    }

}