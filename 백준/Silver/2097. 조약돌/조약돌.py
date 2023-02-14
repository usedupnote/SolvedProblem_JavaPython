import sys

N = int(sys.stdin.readline())

check = (N ** (1/2)) // 1        # 제곱근을 통해 무조건적으로 가지는 정사각형의 한 변의 길이를 알아냄

if check < 2 : check = 2         # 체크의 최솟값 정의

result = (check - 1) * 4         # 무조건 가지는 부피의 둘레의 길이
count = N - (check ** 2)         # 위의 결과값을 제외한 나머지의 갯수 파악

if check < count : result += 4   # 양쪽이 다 필요하므로, 4만큼 더 길어짐(가로 2, 세로 2)
elif 0 < count : result += 2     # 한쪽만 더 필요하므로, 2만큼 더 길어짐(가로 2 or 세로 2)
    # 그 이외에는 늘리는 것이 필요하지 않음

print(int(result))