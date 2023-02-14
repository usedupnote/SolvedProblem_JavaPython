K, N, M = input().split()

K = int(K) # 과자 한 개의 가격
N = int(N) # 사려고 하는 과자의 개수
M = int(M) # 현재 가진 돈의 액수

result = M - (K * N) # 동수가 부모님께 받아야 하는 모자란 돈

if result > 0 :
    result = 0
else :
    result = -result
    
print(result)
    
