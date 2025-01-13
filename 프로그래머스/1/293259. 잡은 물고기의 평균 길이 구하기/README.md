# [level 1] 잡은 물고기의 평균 길이 구하기 - 293259 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/293259) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > IS NULL

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 01월 13일 23:29:52

### 문제 설명

<p style="user-select: auto !important;">낚시앱에서 사용하는 <code style="user-select: auto !important;">FISH_INFO</code> 테이블은 잡은 물고기들의 정보를 담고 있습니다. <code style="user-select: auto !important;">FISH_INFO</code> 테이블의 구조는 다음과 같으며 <code style="user-select: auto !important;">ID</code>, <code style="user-select: auto !important;">FISH_TYPE</code>, <code style="user-select: auto !important;">LENGTH</code>, <code style="user-select: auto !important;">TIME</code>은 각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다. </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">FISH_TYPE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">LENGTH</td>
<td style="user-select: auto !important;">FLOAT</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">TIME</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">단, 잡은 물고기의 길이가 10cm 이하일 경우에는 <code style="user-select: auto !important;">LENGTH</code> 가 NULL 이며, <code style="user-select: auto !important;">LENGTH</code> 에 NULL 만 있는 경우는 없습니다.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;">잡은 물고기의 평균 길이를 출력하는 SQL문을 작성해주세요.</p>

<p style="user-select: auto !important;">평균 길이를 나타내는 컬럼 명은 AVERAGE_LENGTH로 해주세요.<br style="user-select: auto !important;">
평균 길이는 소수점 3째자리에서 반올림하며, 10cm 이하의 물고기들은 10cm 로 취급하여 평균 길이를 구해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">FISH_INFO</code> 테이블이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ID</th>
<th style="user-select: auto !important;">FISH_TYPE</th>
<th style="user-select: auto !important;">LENGTH</th>
<th style="user-select: auto !important;">TIME</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">30</td>
<td style="user-select: auto !important;">2021/12/04</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">50</td>
<td style="user-select: auto !important;">2020/03/07</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">0</td>
<td style="user-select: auto !important;">40</td>
<td style="user-select: auto !important;">2020/03/07</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">20</td>
<td style="user-select: auto !important;">2022/03/09</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">2022/04/08</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">2021/04/28</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">10cm 이하의 물고기는 10cm 로 취급하므로 총 물고기의 길이의 합은 30 + 50 + 40 + 20 + 10 +10  = 160 이며 총 물고기의 수는 6마리이므로 잡은 물고기의 평균 길이는 160/6 = 26.666.. 입니다. 이를 소수점 3째자리에서 반올림하면 26.67 이므로 결과는 다음과 같아야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">AVERAGE_LENGTH</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">26.67</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges