package com.victolee.board.service;


import com.victolee.board.domain.dto.BoardDto;
import com.victolee.board.domain.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor //레파지토리 주입
@Service //서비스 계층이라고 알려줌
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
