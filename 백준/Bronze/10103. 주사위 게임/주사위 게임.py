countRound = int(input()) # 라운드의 수 n (1 ≤ n ≤ 15)
changScore = 100
sangScore = 100

for i in range(countRound) :
    chang, sang = input().split()
    
    chang = int(chang)
    sang = int(sang)
    
    if chang > sang :
        sangScore -= chang
    elif chang < sang :
        changScore -= sang
    
print(changScore)
print(sangScore)