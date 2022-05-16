package com.victolee.board.controller;

import com.victolee.board.dto.BoardDto;
import com.victolee.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    @GetMapping
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }
}