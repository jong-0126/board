package com.example.board.controller;

import com.example.board.dto.board.BoardResponseDto;
import com.example.board.dto.board.CreateBoardRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //전체 게시글 조회
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll(){

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

}
