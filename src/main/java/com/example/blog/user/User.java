package com.example.blog.user;

import com.example.blog.board.Board;
import com.example.blog.reply.Reply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

/*@Builder // 1.allargsconstructor꼭 필요하다, 2.컬렉션 빌더 못함.
@AllArgsConstructor*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_tb")
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder //컬렉션 제외한 나머지로 AllArgsConstructor만들기
    public User(Integer id, String username, String password, String email, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
}