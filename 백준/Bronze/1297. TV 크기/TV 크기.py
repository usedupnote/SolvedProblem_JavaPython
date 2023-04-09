import sys
input = sys.stdin.readline

D, H, W = list(map(int, input().split()))
A = ((H * H) + (W * W)) ** (1/2)
print(int((D*H)//A),int((D*W)//A))