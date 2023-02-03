import sys
num = int(sys.stdin.readline())

result = 1
count = 0

for i in range(1, num + 1) :
    result *= i
result = list(str(result))

while True :
    if result.pop() == "0" :
        count += 1
    else :
        break
        
print(count)