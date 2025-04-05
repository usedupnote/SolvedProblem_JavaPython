import sys
input = sys.stdin.readline

def Fib(N) :
    Fibon = []
    num = 1_000_000
    p = (N+1) % (15 * (num // 10))

    for i in range(p):
        if i < 2:
            Fibon.append(i)
            continue

        Fibon.append((Fibon[0] + Fibon[1]) % num)
        Fibon.pop(0)

    return Fibon[1]

print(Fib(int(input())))