package com.example.ogh_test_backend.board;

import com.example.ogh_test_backend.board.model.dto.BoardRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(
            summary = "게시글 등록",
            description = "게시글을 등록 합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "404", description = "사용자 없음")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<BoardRegisterDto.BoardRegisterRes> register(@RequestBody BoardRegisterDto.BoardRegisterReq dto) {
        BoardRegisterDto.BoardRegisterRes response = boardService.register(dto);
        return ResponseEntity.ok(response);
    }
}
