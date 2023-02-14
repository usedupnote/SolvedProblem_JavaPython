dice1, dice2, dice3 = input().split()

dice1 = int(dice1)
dice2 = int(dice2)
dice3 = int(dice3)

score = 0
counter = []

for i in range(7) :
    counter.append(0)
    
counter[dice1] += 1
counter[dice2] += 1
counter[dice3] += 1

for i in range(7) :
    if counter[i] == 3 :     # 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금
        score = 10000 + (i * 1000)
        break
    elif counter[i] == 2 :   # 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금
        score = 1000 + (i * 100)
        break
    elif counter[i] == 1 :   # 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금
        score = i * 100

print(score)