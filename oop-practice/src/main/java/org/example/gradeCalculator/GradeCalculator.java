package org.example.gradeCalculator;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;
//    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 핵심 포인트
     */
    // 이수한 과목 : 객체지향 프로그래밍, 자료구조, 중국어회화 --> 과목(코스)라는 클래스로 표현
    // 이수한 과목을 전달하여 평균학점 계산을 요청 -----> 학점 계산기 ------> (학점수 * 교과목 평점)의 합계 ----> 과목(코스) 일급 컬렉션
    //                                                      ------> 수강신청 총 학점 수        -----> 과목(코스) 일급 컬렉션
    public Double calculateGrade() {
        // (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            // 아래처럼 코딩을 하면 아래와 같이 코딩한 모든 부분을 수정해 줘야한다.
////            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//            // 아래처럼 작성하면 한 곳만 수정하면 된다.
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
//        int totalCompletedCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
