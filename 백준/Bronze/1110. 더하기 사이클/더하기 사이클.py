import sys
N = int(sys.stdin.readline())

check = N
count = 0

while True :
    check = (check%10 * 10) + (check//10 + check % 10) % 10

    count += 1
    if N == check : break
print(count)