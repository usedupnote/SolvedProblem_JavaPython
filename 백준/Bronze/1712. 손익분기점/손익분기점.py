A, B, C = list(map(int, input().split()))

if C-B > 0 :
    print((A//(C-B)) + 1)
else :
    print(-1)