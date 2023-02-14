import sys

N = int(sys.stdin.readline())
P = int(sys.stdin.readline())

result = P

if N >= 5 :
    result = min(result, P - 500)
if N >= 10 :
    result = min(result, P * 0.9)
if N >= 15 :
    result = min(result, P - 2000)
if N >= 20 :
    result = min(result, P * 0.75)

if result < 0 :
    result = 0

print(int(result))