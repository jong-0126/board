package com.example.board.controller;

import com.example.board.dto.board.BoardResponseDto;
import com.example.board.dto.board.CreateBoardRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto){

        boardService.save(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserName());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
