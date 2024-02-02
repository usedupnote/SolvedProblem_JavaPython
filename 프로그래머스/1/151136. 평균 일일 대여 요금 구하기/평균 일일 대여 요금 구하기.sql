-- 코드를 입력하세요
SELECT round(SUM(daily_fee)/COUNT(daily_fee)) AVERAGE_FEE from CAR_RENTAL_COMPANY_CAR
-- SELECT car_type, daily_fee / count(daily_fee) AVERAGE_FEE from CAR_RENTAL_COMPANY_CAR
-- SELECT car_type, daily_fee from CAR_RENTAL_COMPANY_CAR
where car_type = 'SUV'
-- GROUP BY car_type
