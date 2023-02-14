import sys

T = int(sys.stdin.readline())

Q = []

for i in range(5) :
    Q.append(0)

for i in range(T) :
    x, y = map(int, sys.stdin.readline().split())

    if x > 0 and y > 0 : Q[0] += 1
    elif x < 0 and y > 0 : Q[1] += 1
    elif x < 0 and y < 0 : Q[2] += 1
    elif x > 0 and y < 0 : Q[3] += 1
    else : Q[4] += 1

for i in range(4) :
    print("Q{}: {}".format(i+1, Q[i]))
print("AXIS: {}".format(Q[4]))