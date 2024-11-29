package com.example.blog.board;

import com.example.blog.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.swing.text.html.parser.Entity;

public class BoardRequest {

    @Data
    public static class SaveDTO {
        @NotBlank
        private String title;
        @NotBlank
        private String content;

        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        @NotBlank
        private String title;
        @NotBlank
        private String content;

        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }


}