package org.dsu.dc.controller;

import org.dsu.dc.domain.BoardVO;
import org.dsu.dc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("list")
	public void list( Model model) throws Exception {
		log.info("[Board] show all list... : {}");
		model.addAttribute("list", service.list());
		
		
	}
	
	@GetMapping("register")
	public void register() {
		
	}
	
	@PostMapping("register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("[Board] register: {}", board);
		service.register(board);
		rttr.addAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("read")
	public void read(@RequestParam("bno") long bno, Model model) {
		log.info("[Board] Read... bno={}", bno);
		model.addAttribute("board", service.get(bno));
	}


	@GetMapping("modify")
	public void modify(@RequestParam("bno") long bno, Model model) {
		log.info("[Board] Modify... bno={}", bno);
		model.addAttribute("board", service.get(bno));
	}

	
	@PostMapping("modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("[Board] Modify Post: {}", board);
		if(service.modify(board)) {
		rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
	@PostMapping("remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("[Board] remove... bno={}", bno);
		if(service.remove(bno)) {
		rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
}
