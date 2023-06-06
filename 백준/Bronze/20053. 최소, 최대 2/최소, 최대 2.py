import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T) :
    N = int(input())
    num = list(map(int, input().split()))
    
    max = -1000000
    min = 1000000
    
    for i in num :
        if max < i :
            max = i
        if min > i :
            min = i
            
    print(min, max)
