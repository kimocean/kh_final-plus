package com.meaningfarm.mall.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	Board findOneByBoardNo(Integer boardNo);
	
	Page<Board> findByBoardTitleContaining(String searchKeyword, Pageable pageable);
	
	@Modifying
	@Query("update Board set board_view = board_view + 1 where board_no = :board_no")
	Integer updateBoardViews(@Param("board_no") Integer boardNo);

	@Transactional
	Board deleteByBoardNo(Integer boardNo);
}
