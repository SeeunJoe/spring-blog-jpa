package com.example.blog.borad;

import com.example.blog.board.Board;
import com.example.blog.board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

// @RequiredArgsConstuctor -> test에서는 롬복을 따로 추가하지 않아 사용할 수 없으므로 @Autowired를 사용한다.
@Import(BoardRepository.class)
@DataJpaTest // DB관련된 자원들을 메모리(IoC)에 올린다.
public class BoardRepositoryTest {

    @Autowired // -> 의존성 주입 : Spring
    private BoardRepository boardRepository;

    @Test
    public void findByIdJoinUserAndReply_test(){
        int id = 1;
        boardRepository.findByIdJoinUserAndReply(id);
    }


    @Test
    public void findByIdJoinUser_test(){
        int id = 1;
        boardRepository.findByIdJoinUser(id);
    }


    @Test
    public void findById_Test(){
        //given
        Integer id = 1;

        //when
        Optional<Board> boardOP = boardRepository.findById(id);
        Board board = boardOP.get();

        //eye
        System.out.println("Lazy Loading 직전");
        String title = board.getUser().getUsername();
        System.out.println("Lazy Loading 직후");


    }

    @Test
    public void findAll_test(){
        // given - parameter를 넣는다. testcode에서는 junit이 제어해서

        // when - 실제로 테스트할 코드
        List<Board> boardList = boardRepository.findAll();
        System.out.println();

        // eye - 눈으로 보슈
        for(Board board : boardList){
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
            System.out.println(board.getCreatedAt());
            System.out.println("=================");
        }

        // then - 상태 검증하기 - 초보자라 우선은 패스 : 나중에 배포할 때 쓰걸아^^


    }
}
