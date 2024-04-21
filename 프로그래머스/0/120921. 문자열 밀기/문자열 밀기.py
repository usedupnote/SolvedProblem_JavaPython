def solution(A, B):
    answer = 1000
    A += A
    
    for i in range(len(B), -1, -1):
        if A[i : i + len(B)] == B :
            answer = min(answer, len(B) - i)
            
    return -1 if answer == 1000 else answer