package com.meaningfarm.mall.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "board")
@SequenceGenerator(
	name="SEQ_BOARD_NO",
	sequenceName = "SEQ_BOARD_NO",
	initialValue=1, allocationSize=1
)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_NO")
	@Column(name = "board_no")
	private Integer boardNo;
	
	@Column(name = "board_title")
	private String boardTitle;

	@Column(name = "board_content")
	private String boardContent;
	
	@Column(name = "board_view", columnDefinition = "number default 0", nullable = false)
	private Integer boardView;
	
//	@OrderBy("replyNo desc")
//	@JsonIgnoreProperties({"board"})
//	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
//	private List<Reply> replyList;
	
	
	
}
