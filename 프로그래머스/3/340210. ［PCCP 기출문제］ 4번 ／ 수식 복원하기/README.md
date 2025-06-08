# [level 3] [PCCP 기출문제] 4번 / 수식 복원하기 - 340210 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/340210?language=python3) 

### 성능 요약

메모리: 9.44 MB, 시간: 0.70 ms

### 구분

코딩테스트 연습 > PCCP 기출문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 06월 08일 23:36:05

### 문제 설명

<p>당신은 덧셈 혹은 뺄셈 수식이 여러 개 적힌 고대 문명의 유물을 찾았습니다. 이 수식들을 관찰하던 당신은 이 문명이 사용하던 진법 체계가 10진법이 아니라는 것을 알아냈습니다. (2 ~ 9진법 중 하나입니다.)</p>

<p>수식들 중 몇 개의 수식은 결괏값이 지워져 있으며, 당신은 이 문명이 사용하던 진법에 맞도록 지워진 결괏값을 채워 넣으려 합니다.</p>

<p>다음은 그 예시입니다.</p>

<p>&lt;<strong>수식</strong>&gt;</p>
<div class="highlight"><pre class="codehilite"><code>14 + 3 = 17
13 - 6 = X
51 - 5 = 44
</code></pre></div>
<ul>
<li><code>X</code>로 표시된 부분이 지워진 결괏값입니다.</li>
</ul>

<p><code>51 - 5 = 44</code>에서 이 문명이 사용하던 진법이 8진법임을 알 수 있습니다. 따라서 <code>13 - 6 = X</code>의 지워진 결괏값을 채워 넣으면 <code>13 - 6 = 5</code>가 됩니다.</p>

<p>다음은 또 다른 예시입니다.</p>

<p>&lt;<strong>수식</strong>&gt;</p>
<div class="highlight"><pre class="codehilite"><code>1 + 1 = 2
1 + 3 = 4
1 + 5 = X
1 + 2 = X
</code></pre></div>
<p>주어진 수식들에서 이 문명에서 사용한 진법이 6 ~ 9진법 중 하나임을 알 수 있습니다. <br>
<code>1 + 5 = X</code>의 결괏값은 6진법일 때 10, 7 ~ 9진법일 때 6이 됩니다. 이와 같이 결괏값이 불확실한 수식은 <code>?</code>를 사용해 <code>1 + 5 = ?</code>와 같이 결괏값을 채워 넣습니다. <br>
<code>1 + 2 = X</code>의 결괏값은 6 ~ 9진법에서 모두 3으로 같습니다. 따라서 <code>1 + 2 = X</code>의 지워진 결괏값을 채워 넣으면 <code>1 + 2 = 3</code>이 됩니다.</p>

<p>덧셈 혹은 뺄셈 수식들이 담긴 1차원 문자열 배열 <code>expressions</code>가 매개변수로 주어집니다. 이때 결괏값이 지워진 수식들의 결괏값을 채워 넣어 순서대로 문자열 배열에 담아 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>expressions</code>의 길이 ≤ 100

<ul>
<li><code>expressions</code>의 원소는 <code>"A + B = C"</code> 혹은 <code>"A - B = C"</code> 형태의 문자열입니다. A, B, C와 연산 기호들은 공백 하나로 구분되어 있습니다.</li>
<li>A, B는 음이 아닌 두 자릿수 이하의 정수입니다.</li>
<li>C는 알파벳 <code>X</code> 혹은 음이 아닌 세 자릿수 이하의 정수입니다. C가 알파벳 <code>X</code>인 수식은 결괏값이 지워진 수식을 의미하며, 이러한 수식은 한 번 이상 등장합니다. </li>
<li>결괏값이 음수가 되거나 서로 모순되는 수식은 주어지지 않습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>expressions</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>["14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"]</td>
<td>["13 - 6 = 5"]</td>
</tr>
<tr>
<td>["1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"]</td>
<td>["1 + 5 = ?", "1 + 2 = 3"]</td>
</tr>
<tr>
<td>["10 - 2 = X", "30 + 31 = 101", "3 + 3 = X", "33 + 33 = X"]</td>
<td>["10 - 2 = 4", "3 + 3 = 10", "33 + 33 = 110"]</td>
</tr>
<tr>
<td>["2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"]</td>
<td>["2 + 2 = 4", "7 + 4 = ?", "5 - 5 = 0"]</td>
</tr>
<tr>
<td>["2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"]</td>
<td>["2 + 2 = 4", "7 + 4 = 12", "8 + 4 = 13"]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p><code>30 + 31 = 101</code>에서 이 문명이 사용하던 진법이 6진법임을 알 수 있습니다. 따라서 <code>10 - 2 = X</code>, <code>3 + 3 = X</code>, <code>33 + 33 = X</code>의 지워진 결괏값을 채워 넣으면 <code>10 - 2 = 4</code>, <code>3 + 3 = 10</code>, <code>33 + 33 = 110</code>이 됩니다.</p>

<p>따라서 <code>["10 - 2 = 4", "3 + 3 = 10", "33 + 33 = 110"]</code>을 return 해야 합니다.</p>

<p><strong>입출력 예 #4</strong></p>

<p>수식에 등장하는 숫자들을 통해 이 문명이 사용하던 진법이 8진법 혹은 9진법임을 알 수 있습니다. <code>2 + 2 = X</code>와 <code>5 - 5 = X</code>의 지워진 결괏값을 채워 넣으면 8진법, 9진법에 관계없이 <code>2 + 2 = 4</code>, <code>5 - 5 = 0</code>이 됩니다. <code>7 + 4 = X</code>의 결괏값은 불확실하므로 지워진 결괏값을 채워 넣으면 <code>7 + 4 = ?</code>가 됩니다.</p>

<p>따라서 <code>["2 + 2 = 4", "7 + 4 = ?", "5 - 5 = 0"]</code>을 return 해야 합니다.</p>

<p><strong>입출력 예 #5</strong></p>

<p>네 번째 예시와 같지만 <code>5 - 5 = X</code>가 <code>8 + 4 = X</code>로 바뀌었습니다. 이 문명이 사용하던 진법이 9진법임을 알 수 있으므로 <code>7 + 4 = X</code>와 <code>8 + 4 = X</code>의 지워진 결괏값을 채워 넣으면 <code>7 + 4 = 12</code>, <code>8 + 4 = 13</code>이 됩니다.</p>

<p>따라서 <code>["2 + 2 = 4", "7 + 4 = 12", "8 + 4 = 13"]</code>을 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges