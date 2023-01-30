N, M = input().split()
A = input().split()

N = int(N)
M = int(M)

maximum = 0
hamster = []
hamsterSum = 0

for i in range(N) :
    A[i] = int(A[i])

for i in range(N) :
    hamster.append(A[i])

    hamsterSum += A[i]

    if hamsterSum > M :
        while hamsterSum > M :
            hamsterSum -= hamster.pop(0)
    maximum = max(maximum, hamsterSum)
print(maximum)