package com.victolee.board.service;

import com.victolee.board.domain.entity.BoardEntity;
import com.victolee.board.domain.repository.BoardRepository;
import com.victolee.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@SuppressWarnings("ALL")
@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public BoardDto getPost(Long id){
        Optional<BoardEntity>boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createdDate(boardEntity.getCreatedDate())
                .build();
        return boardDto;
    }
    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
