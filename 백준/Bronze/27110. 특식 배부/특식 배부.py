import sys
input = sys.stdin.readline

N = int(input())
A,B,C = list(map(int, input().split()))

if A > N :
    A = N
if B > N :
    B = N
if C > N :
    C = N
print(A + B + C)