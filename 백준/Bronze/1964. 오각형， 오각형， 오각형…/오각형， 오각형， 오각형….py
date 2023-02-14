import sys
T = int(sys.stdin.readline())

result = 1

for i in range(1, T+1) :
    result += ((i + 1) * 3) - 2
    
print(result % 45678)