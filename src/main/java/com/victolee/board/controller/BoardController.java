package com.victolee.board.controller;

import com.victolee.board.dto.BoardDto;
import com.victolee.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@SuppressWarnings("ALL")
@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/post{no}")
    public String detail(@PathVariable("no")Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto",boardDTO);
        return "board/detail.html";
    }
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no")Long no, Model model){
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto",boardDTO);
        return "board/update.html";
    }
    @PostMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO, @PathVariable String no) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no")Long no) {
        boardService.deletePost(no);
        return "reditect:/";
    }
}
//위에서부터 차례대로 "게시글 상세조회 페이지" ,"게시글 수정페이지","게시글 수정","게시글 삭제"
