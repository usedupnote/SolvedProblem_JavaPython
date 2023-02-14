import sys
input = sys.stdin.readline

jaminis = list(map(int, input().split()))
startlink = list(map(int, input().split()))

result = "No"

for i in range(1, 9) :
    jaminis[i] += jaminis[i-1]
    startlink[i] += startlink[i-1]

if jaminis[0] > 0 :
    result = "Yes"
else :
    for i in range(1, 9) :
        if jaminis[i] > startlink[i-1] :
            result = "Yes"

print(result)