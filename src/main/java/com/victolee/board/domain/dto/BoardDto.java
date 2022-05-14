package com.victolee.board.domain.dto;

import com.victolee.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .tiltle(title)
                .content(content)
                .build();
        return boardEntity;
    }
    @Builder
    public BoardDto(Long id,String title,String content,String writer, LocalDateTime createdDate,LocalDateTime modifiedDate){
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.title = title;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
