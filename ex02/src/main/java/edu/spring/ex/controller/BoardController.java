package edu.spring.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex.domain.Board;
import edu.spring.ex.service.BoardService;
import edu.spring.ex.service.BoardServiceImple;

@Controller
@RequestMapping (value = "board")
public class BoardController {
	private final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	// DI (Dependency Injecttion) : 의존성 주입
	// application 
	
	@Autowired private BoardService boardService;
	// 요청 주소 : board/list
	// 뷰(JSP): board/list.jsp
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) {
		logger.info("list() 호출");
		
		// BoardService를 사용해서 게시글 전체 목록을 검색
		List<Board> list = boardService.select();
		// 검색한 결과를 View(JSP)를 전달
		// JSP에서는 attribute의 이름(boardList)을 EL에서 사용함
		model.addAttribute("boardList", list);
	}
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert() {
		logger.info("insert() get 호출");
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(Board board) {
		logger.info("insert(board) POST 호출");
		
		// BoardService를 사용해서  DB 테이블에 insert를 한 후
		boardService.insert(board);
		
		// 게시판 메인 페이지로 redirect
		return "redirect:list";//board/list 이동
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(int bno, Model model) {
		
		Board board = boardService.select(bno);
		model.addAttribute("board", board);
		
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(int bno, Model model) {
		logger.info("update(bno={}", bno);
		Board board = boardService.select(bno);
		model.addAttribute("board", board);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Board board, RedirectAttributes reAttrs) {
		logger.info("update({}) POST 호출",board.toString());;
		int result = boardService.update(board);
		logger.info("게시글 수정결과: {}", result);
		
		if(result == 1) {
			// RedirectAttributes: 콘트롤러에서 redirect 방식의
			// 페이지 이동을 할 때, 이동되는 페이지까지 데이터를 보낼 때 사용하는 객체
			// addFlashAttribute(name, value) 메소드에서 설정한
			// attribute 값은 이동된 페이지에서 한번 사용된 후 자동 삭제
			// 이동한 JSP페이지에서는 EL을 사용해서 flash attribute 값을 읽음
			reAttrs.addFlashAttribute("updateResult", "success");
		}
		// 게시글 수정이 끝난 후에는 게시글 메인 페이지로 이동(redirect)
		return "redirect:list";
	}
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bno, RedirectAttributes reAtts) {
		logger.info("delete(bno={})", bno);
		
		int result = boardService.delete(bno);
		if (result == 1) {
			reAtts.addFlashAttribute("deleteResult", "success");
			reAtts.addFlashAttribute("deleteBno", bno);
		}
		return "redirect:list";
	}
}// end class BoardController
