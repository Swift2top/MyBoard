package org.dsu.dc;

import org.dsu.dc.domain.BoardVO;
import org.dsu.dc.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyBoardApplicationTests {
	@Autowired
	BoardService service;
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setSno("학번");
		board.setSname("이름");
		board.setPCno("PCno");
		
		service.register(board);
		log.info("[Board Insert] {}", board);
	}
	

		
	@Test
	public void testRead() {
		BoardVO board=new BoardVO();
		log.info("[Board Read] {}", board);
	}
}
