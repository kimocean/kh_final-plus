package com.meaningfarm.mall.board;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meaningfarm.mall.reply.Reply;

import lombok.Data;

@Entity
@Data
@Table(name = "board")
public class Board {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "board_no")
	private Integer boardNo;
	
	@Column(name = "board_title")
	private String boardTitle;

	@Column(name = "board_content")
	private String boardContent;
	
	@Column(name = "board_view", columnDefinition = "number default 0", nullable = false)
	private Integer boardView;
	
	@OrderBy("replyNo desc")
	@JsonIgnoreProperties({"board"})
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private List<Reply> replyList;
	
}
