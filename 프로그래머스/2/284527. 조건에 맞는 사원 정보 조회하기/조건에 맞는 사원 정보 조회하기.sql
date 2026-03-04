# 평가 점수가 가장 높은 사원 정보

# 사원별 총점 계산 후 내림차순 정렬 -> 1행만 잘라서 출력
SELECT SUM(g.SCORE) AS SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
FROM HR_EMPLOYEES e
JOIN HR_GRADE g
ON e.EMP_NO = g.EMP_NO
GROUP BY e.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;

# 사원별 총점 계산한 테이블을 활용하여 최고점 추출
# 총점이 최고점인 사원 필터링
# SELECT SUM(g.SCORE) AS SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
# FROM HR_EMPLOYEES e
# JOIN HR_GRADE g
# ON e.EMP_NO = g.EMP_NO
# GROUP BY e.EMP_NO
# HAVING SUM(g.SCORE) = (
#     SELECT MAX(TOTAL)
#     FROM (
#         SELECT SUM(SCORE) AS TOTAL
#         FROM HR_GRADE
#         GROUP BY EMP_NO
#     ) t
# );