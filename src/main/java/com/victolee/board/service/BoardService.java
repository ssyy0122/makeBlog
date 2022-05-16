package com.victolee.board.service;


import com.victolee.board.domain.entity.BoardEntity;
import com.victolee.board.dto.BoardDto;
import com.victolee.board.domain.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor //레파지토리 주입
@Service //서비스 계층이라고 알려줌
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<BoardEntity>boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();
            boardDtoList.add(boardDTO);
        }
        return boardDtoList;
    }
}
