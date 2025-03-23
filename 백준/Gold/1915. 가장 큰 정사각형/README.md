# [Gold IV] 가장 큰 정사각형 - 1915 

[문제 링크](https://www.acmicpc.net/problem/1915) 

### 성능 요약

메모리: 24172 KB, 시간: 228 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 24일 02:15:04

### 문제 설명

<p style="user-select: auto !important;">n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.</p>

<table class="table table-bordered" style="width: 16%; user-select: auto !important;">
	<tbody style="user-select: auto !important;">
		<tr style="user-select: auto !important;">
			<td style="width: 4%; text-align: center; user-select: auto !important;">0</td>
			<td style="width: 4%; text-align: center; user-select: auto !important;">1</td>
			<td style="width: 4%; text-align: center; user-select: auto !important;">0</td>
			<td style="width: 4%; text-align: center; user-select: auto !important;">0</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="text-align: center; user-select: auto !important;">0</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">0</td>
		</tr>
		<tr style="user-select: auto !important;">
			<td style="text-align: center; user-select: auto !important;">0</td>
			<td style="text-align: center; user-select: auto !important;">0</td>
			<td style="text-align: center; user-select: auto !important;">1</td>
			<td style="text-align: center; user-select: auto !important;">0</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto !important;">위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.</p>

### 입력 

 <p style="user-select: auto !important;">첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.</p>

### 출력 

 <p style="user-select: auto !important;">첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.</p>

