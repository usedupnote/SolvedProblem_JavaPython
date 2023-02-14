score = 0
scoreMod = 0

for i in range(5) :
    score = int(input())
    if score < 40 :
        score = 40
    scoreMod += score
    
print(int(scoreMod/5))