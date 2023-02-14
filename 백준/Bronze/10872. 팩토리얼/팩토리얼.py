N = int(input())  # 정수 N(0 ≤ N ≤ 12)

reslut = 1

while N > 0 :
    reslut *= N
    N -= 1

print(reslut)