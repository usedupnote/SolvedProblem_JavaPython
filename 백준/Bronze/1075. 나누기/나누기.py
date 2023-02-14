N = int(input())
F = int(input())

N -= N % 100
result = (F - N % F) % F

if result < 9 :
    print("0", result, sep="")
else :
    print(result)