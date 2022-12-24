package com.meaningfarm.mall.reply;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.meaningfarm.mall.board.Board;
import com.meaningfarm.mall.member.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reply")
public class Reply {
	
	@Id
	@Column(name = "reply_no")
	private Integer replyNo;
	
	@Column(name = "reply_content")
	private String replyContent;

	@CreationTimestamp
	private Timestamp replyDate;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "board_no")
	private Board board;
	
	public void save(Board board, Member member) {
        this.board = board;
        this.member = member;
    }
}
