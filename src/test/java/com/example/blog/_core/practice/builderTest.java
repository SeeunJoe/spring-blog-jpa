package com.example.blog._core.practice;

import org.junit.jupiter.api.Test;

// 초기화는 생성자로,,, 디폴트 생성자 놉
// lombok을 런타임 시 작동해서 테스트에서는 안먹는다.
class Member {
    private Integer id;
    private String name;
    private String addr;

    private Member() {}

    public static Member builder(){
        return new Member();
    }
    // setter
    public Member id(Integer id){
        this.id = id;
        return this;
    }
    public Member name(String name){
        this.name = name;
        return this;
    }
    public Member addr(String addr){
        this.addr = addr;
        return this;
    }
}


public class builderTest {
    @Test
    public void new_test(){
        Member m = Member.builder() //build패턴은 내가 값을 채워넣으면 그 객체를 다시 리턴하므로 . 사용해서 이어나갈 수 있다.
//                .id(1)
                .name("이름1")
                .addr("주소1");
    }
}
