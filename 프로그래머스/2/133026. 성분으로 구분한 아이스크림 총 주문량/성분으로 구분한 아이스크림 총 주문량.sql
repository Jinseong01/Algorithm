# 아이스크림 가게의 상반기 주문 정보를 담은 FIRST_HALF 테이블
# 아이스크림 성분에 대한 정보를 담은 ICECREAM_INFO 테이블
# 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회


SELECT INGREDIENT_TYPE, SUM(f.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF f
JOIN ICECREAM_INFO i
ON f.FLAVOR = i.FLAVOR
GROUP BY i.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;