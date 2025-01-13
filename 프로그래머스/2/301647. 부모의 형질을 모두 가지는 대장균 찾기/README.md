# [level 2] 부모의 형질을 모두 가지는 대장균 찾기 - 301647 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/301647) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > SELECT

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 01월 13일 23:11:03

### 문제 설명

<p style="user-select: auto !important;">대장균들은 일정 주기로 분화하며, 분화를 시작한 개체를 부모 개체, 분화가 되어 나온 개체를 자식 개체라고 합니다.<br style="user-select: auto !important;">
다음은 실험실에서 배양한 대장균들의 정보를 담은 <code style="user-select: auto !important;">ECOLI_DATA</code> 테이블입니다. <code style="user-select: auto !important;">ECOLI_DATA</code> 테이블의 구조는 다음과 같으며,  <code style="user-select: auto !important;">ID</code>, <code style="user-select: auto !important;">PARENT_ID</code>, <code style="user-select: auto !important;">SIZE_OF_COLONY</code>, <code style="user-select: auto !important;">DIFFERENTIATION_DATE</code>, <code style="user-select: auto !important;">GENOTYPE</code> 은 각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.</p>
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
<td style="user-select: auto !important;">PARENT_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">TRUE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">SIZE_OF_COLONY</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DIFFERENTIATION_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">GENOTYPE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">최초의 대장균 개체의 <code style="user-select: auto !important;">PARENT_ID</code> 는 NULL 값입니다.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;">부모의 형질을 모두 보유한 대장균의 ID(<code style="user-select: auto !important;">ID</code>), 대장균의 형질(<code style="user-select: auto !important;">GENOTYPE</code>), 부모 대장균의 형질(<code style="user-select: auto !important;">PARENT_GENOTYPE</code>)을 출력하는 SQL 문을 작성해주세요. 이때 결과는 ID에 대해 오름차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">ECOLI_DATA</code> 테이블이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ID</th>
<th style="user-select: auto !important;">PARENT_ID</th>
<th style="user-select: auto !important;">SIZE_OF_COLONY</th>
<th style="user-select: auto !important;">DIFFERENTIATION_DATE</th>
<th style="user-select: auto !important;">GENOTYPE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">NULL</td>
<td style="user-select: auto !important;">10</td>
<td style="user-select: auto !important;">2019/01/01</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2019/01/01</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">100</td>
<td style="user-select: auto !important;">2020/01/01</td>
<td style="user-select: auto !important;">3</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">16</td>
<td style="user-select: auto !important;">2020/01/01</td>
<td style="user-select: auto !important;">2</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">17</td>
<td style="user-select: auto !important;">2020/01/01</td>
<td style="user-select: auto !important;">8</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">101</td>
<td style="user-select: auto !important;">2021/01/01</td>
<td style="user-select: auto !important;">5</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">101</td>
<td style="user-select: auto !important;">2022/01/01</td>
<td style="user-select: auto !important;">5</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022/01/01</td>
<td style="user-select: auto !important;">13</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">각 대장균 별 형질을 2진수로 나타내면 다음과 같습니다.</p>

<p style="user-select: auto !important;">ID 1 : 1₍₂₎<br style="user-select: auto !important;">
ID 2 : 1₍₂₎<br style="user-select: auto !important;">
ID 3 : 11₍₂₎<br style="user-select: auto !important;">
ID 4 : 10₍₂₎<br style="user-select: auto !important;">
ID 5 : 1000₍₂₎<br style="user-select: auto !important;">
ID 6 : 101₍₂₎<br style="user-select: auto !important;">
ID 7 : 101₍₂₎<br style="user-select: auto !important;">
ID 8 : 1101₍₂₎</p>

<p style="user-select: auto !important;">각 대장균 별 보유한 형질을 다음과 같습니다.</p>

<p style="user-select: auto !important;">ID 1 : 1<br style="user-select: auto !important;">
ID 2 : 1<br style="user-select: auto !important;">
ID 3 : 1, 2<br style="user-select: auto !important;">
ID 4 : 2<br style="user-select: auto !important;">
ID 5 : 4<br style="user-select: auto !important;">
ID 6 : 1, 3<br style="user-select: auto !important;">
ID 7 : 1, 3<br style="user-select: auto !important;">
ID 8 : 1, 3, 4</p>

<p style="user-select: auto !important;">각 개체별로 살펴보면 다음과 같습니다.</p>

<p style="user-select: auto !important;">ID 1 : 최초의 대장균 개체이므로 부모가 없습니다.<br style="user-select: auto !important;">
ID 2 : 부모는 ID 1 이며 부모의 형질인 1번 형질을 보유하고 있습니다.<br style="user-select: auto !important;">
ID 3 : 부모는 ID 1 이며 부모의 형질인 1번 형질을 보유하고 있습니다.<br style="user-select: auto !important;">
ID 4 : 부모는 ID 2 이며 부모의 형질인 1번 형질을 보유하고 있지 않습니다.<br style="user-select: auto !important;">
ID 5 : 부모는 ID 4 이며 부모의 형질인 2번 형질을 보유하고 있지 않습니다.<br style="user-select: auto !important;">
ID 6 : 부모는 ID 3 이며 부모의 형질 1, 2번 중 2 번 형질을 보유하고 있지 않습니다.<br style="user-select: auto !important;">
ID 7 : 부모는 ID 2 이며 부모의 형질인 1번 형질을 보유하고 있습니다.<br style="user-select: auto !important;">
ID 8 : 부모는 ID 6 이며 부모의 형질 1, 3번을 모두 보유하고 있습니다.</p>

<p style="user-select: auto !important;">따라서 부모의 형질을 모두 보유한 개체는 ID 2, ID 3, ID 7, ID 8 이며 결과를 ID 에 대해 오름차순 정렬하면 다음과 같아야 합니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">ID</th>
<th style="user-select: auto !important;">GENOTYPE</th>
<th style="user-select: auto !important;">PARENT_GENOTYPE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">1</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">13</td>
<td style="user-select: auto !important;">5</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges