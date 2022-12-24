package com.meaningfarm.mall.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
    public List<Board> boardList(){
        return  boardRepository.findAll();
    }
    
    public Page<Board> boardSearchList(String SearchKeyword, Pageable pageable) {
    	return boardRepository.findByBoardTitleContaining(SearchKeyword, pageable);
    }
	
    public Page<Board> boardList(Pageable pageable) {
    	return boardRepository.findAll(pageable);
    }

    @Transactional
	public void boardInsert(Board board) {
		boardRepository.save(board);
	}
    
    @Transactional
    public Integer boardUpdateView(Integer boardNo) {
    	return boardRepository.updateBoardViews(boardNo);
    }

    public Board boardDetail(Integer boardNo){
        return boardRepository.findOneByBoardNo(boardNo);
    }
    
    public void boardDelete(Integer boardNo) {
//    	boardRepository.deleteByBoardNo(boardNo);
   	 boardRepository.deleteById(boardNo);
    }


}
