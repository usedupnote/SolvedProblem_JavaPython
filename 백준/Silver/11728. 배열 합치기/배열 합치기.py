import sys
N, M = map(int, sys.stdin.readline().split())

A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

position_A = 0
position_B = 0

result = []

while True :
    if A[position_A] > B[position_B] :
        result.append(B[position_B])
        position_B += 1
        if M == position_B :
            while N > position_A :
                result.append(A[position_A])
                position_A += 1
            break
    else :
        result.append(A[position_A])
        position_A += 1
        if N == position_A :
            while M > position_B :
                result.append(B[position_B])
                position_B += 1
            break
    
print(*result)
