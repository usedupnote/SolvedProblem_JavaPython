import sys

N = int(sys.stdin.readline().strip())

count = 1
check = 0

while N > count :
    N -= count
    count += 1

if count % 2 != 0 :
    print("{}/{}".format(count - N + 1, N))
else :
    print("{}/{}".format(N, count - N + 1))