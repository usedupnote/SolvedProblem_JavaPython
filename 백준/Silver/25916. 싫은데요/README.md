# [Silver I] 싫은데요 - 25916 

[문제 링크](https://www.acmicpc.net/problem/25916) 

### 성능 요약

메모리: 72100 KB, 시간: 656 ms

### 분류

두 포인터(two_pointer)

### 문제 설명

<p style="text-align: center;"><img alt="" src="" style="width: 120px; height: 104px;"></p>

<p>싫은데요 햄스터는 콩쥐를 위해서 깨진 독을 자기 몸으로 막으려고 한다.</p>

<p>햄스터는 유체라 자기 몸을 그림처럼 늘릴 수 있다.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 591px; height: 186px;"></p>

<p>또, 햄스터는 유체라 자기 몸을 아래 그림처럼 늘릴 수도 있다.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 591px; height: 180px;"></p>

<p>하지만 햄스터의 부피는 $M$으로 정해져 있기 때문에, 늘릴 수 있는 크기에는 한계가 있다.</p>

<p>독에 왼쪽부터 $N$개의 구멍이 일렬로 뚫려 있고, $i$번째 구멍의 크기 $A_i$가 주어진다. 햄스터는 구멍을 막기 위해 정확히 그 크기만큼의 부피를 소모해야 한다.</p>

<p>싫은데요 햄스터는 콩쥐에게 최대한 도움이 되길 원하기 때문에 자기 부피를 가능한 한 많이 활용하길 원한다.</p>

<p>어떻게 막으면 햄스터가 원하는 방식으로 독을 막는지 구해서 알려주자.</p>

<p>아무리 햄스터가 유체라고 하지만 몸을 둘로 나눌 수는 없기 때문에 막는 모든 구멍은 연속되어야 한다.</p>

### 입력 

 <p>입력은 아래와 같이 주어진다.</p>

<div style="background:#eeeeee;border:1px solid #cccccc;padding:5px 10px;">
<p>$N$ $M$</p>

<p>$A_1$ $A_2$ ... $A_N$</p>
</div>

### 출력 

 <p>구멍을 막는 데에 활용할 수 있는 최대 부피를 출력한다.</p>

