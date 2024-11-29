package com.example.blog.board;

import com.example.blog.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor(access= AccessLevel.PROTECTED) // DB에서 조회해서 가져온 RS를 디폴트 생성자를 호출해서 new하고 값을 채워준다.
@Getter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY) // 연관관계 설정
    private User user;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Board(Integer id, String title, String content, User user, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = createdAt;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}





/**
 * 행위를 통해 바꾼다. -> setter의미있는 행위를 만들어준다.
 * @Entity 붙여야 EntityManager이 관리할 수 있다!
 *
 */