import sys
input = sys.stdin.readline

L, P, V = map(int, input().split())
count = 1

while L + P + V != 0 :
    print("Case {}: {}".format(count, (V // P) * L + (L if V % P > L else V % P)))

    L, P, V = map(int, input().split())
    count += 1