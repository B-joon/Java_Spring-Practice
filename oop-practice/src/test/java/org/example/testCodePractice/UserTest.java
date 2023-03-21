package org.example.testCodePractice;

import org.example.testCodePratice.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        // 메서드가 하나인 FunctionalInterface인 경우 구현체를 만들 필요 없이
        // 람다를 사용하면 된다. (31줄 참고)
        // FunctionalInterface : 메서드가 하나인 인터페이스
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }
    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixedPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNull();
    }
}