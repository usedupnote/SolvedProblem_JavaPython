-- 코드를 입력하세요
SELECT animal_type, IF (NAME IS NULL, "No name", NAME), sex_upon_intake 
FROM animal_ins;