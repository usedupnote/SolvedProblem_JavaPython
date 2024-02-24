-- 코드를 입력하세요
SELECT H.FLAVOR FROM FIRST_HALF H
GROUP BY 1
ORDER BY SUM(H.TOTAL_ORDER)+
(
    SELECT SUM(J.TOTAL_ORDER) FROM JULY J
    WHERE H.FLAVOR = J.FLAVOR
    GROUP BY J.FLAVOR
) DESC
LIMIT 3