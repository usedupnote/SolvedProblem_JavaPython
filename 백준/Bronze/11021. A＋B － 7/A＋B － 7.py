# 첫째 줄에 테스트 케이스의 개수 T
T = int(input())

# 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
for i in range(1, T + 1) :
    n1, n2 = input().split()
    
    n1 = int(n1)
    n2 = int(n2)
    
    print("Case #", i, ":", sep = "", end = " ")
    print(n1+n2)    # Case #1: 2