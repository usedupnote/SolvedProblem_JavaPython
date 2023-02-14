T = int(input()) # 테스트 케이스의 개수 T

for i in range(T) :
    A, B = input().split() # 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    
    A = int(A)
    B = int(B)
    
    print(A+B)