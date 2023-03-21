package org.example.gradeCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계/수강신청 총 학점 수
 * 일급 컬렉션 사용 : 리스트 형태로 된 정보를 인스턴스 변수로 가지는 클래스
 */
public class GradeCalculatorTest {
    // 학점계산기 도메인 : 이수 과목, 학점 계산기

    /**
     * 핵심 포인트
     */
    // 이수한 과목 : 객체지향 프로그래밍, 자료구조, 중국어회화 --> 과목(코스)라는 클래스로 표현
    // 이수한 과목을 전달하여 평균학점 계산을 요청 -----> 학점 계산기 ------> (학점수 * 교과목 평점)의 합계 ----> 과목(코스)
    //                                                      ------> 수강신청 총 학점 수        -----> 과목(코스)

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        // 이수한 과목을 전달
        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        // 학점 계산을 요청
        Double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }

}
