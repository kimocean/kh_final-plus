package com.meaningfarm.mall.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private final BoardRepository boardRepository;
	
    @GetMapping("/boardList")
    public String boardList(Model model,
    		@PageableDefault(page = 0, size = 1, sort = "boardNo", direction = Sort.Direction.DESC) Pageable pageable,
    		String searchKeyword){
    	Page<Board> pageList = null;
    	if(searchKeyword == null) {
    		pageList = boardService.boardList(pageable);
    	} else {
    		pageList = boardService.boardSearchList(searchKeyword, pageable);
    	}
    	
    	int nowPage = pageList.getPageable().getPageNumber() + 1;
    	int startPage = Math.max(nowPage - 4, 1);
    	int endPage = Math.min(nowPage + 5, pageList.getTotalPages());
    	
//        model.addAttribute("list",boardService.boardList());
    	model.addAttribute("list", pageList);
    	model.addAttribute("nowPage", nowPage);
    	model.addAttribute("startPage", startPage);
    	model.addAttribute("endPage", endPage);
        return "board/boardList";
    }
	
	@GetMapping("/boardInsert")
	public String boardInsert(HttpServletRequest request) {
		return "board/boardInsert";
	}
	
	@PostMapping("/boardInsert")
		public String boardInsert(Board board) {
		System.out.println(board);
		boardService.boardInsert(board); 
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/boardDetail/{boardNo}")
	public String boardDetail(Model model, @PathVariable("boardNo") Integer boardNo){
	    model.addAttribute("board",boardService.boardDetail(boardNo));
	    boardService.boardUpdateView(boardNo);
	    return "board/boardDetail";
	}
	
	@GetMapping("/boardUpdate/{boardNo}")
	public String boardUpdate(@PathVariable("boardNo") Integer boardNo, Model model) {
		model.addAttribute("board", boardService.boardDetail(boardNo));
		return "board/boardUpdate";
	}
	
	@PutMapping("/boardUpdate/{boardNo}")
	public String boardUpdate(Board board) {
		boardService.boardInsert(board);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/boardDelete")
	public String boardDelete(Integer boardNo) {
		boardService.boardDelete(boardNo);
		return "redirect:/board/boardList";
	}
}
