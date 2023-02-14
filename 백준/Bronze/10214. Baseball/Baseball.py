game = int(input())

# 각각의 케이스마다 한 줄에 연세대가 이겼을 경우 "Yonsei", 고려대가 이겼을 경우 "Korea", 비겼을 경우 "Draw"를 출력한다.
for i in range(game) :
    
    yonseiScore = 0
    koreaScore = 0
    
    for i in range (9) :
        yonsei, korea = input().split()
        
        yonsei = int(yonsei)
        korea = int(korea)
        
        yonseiScore += yonsei
        koreaScore += korea
        
    if yonseiScore > koreaScore :
        print("Yonsei")
    elif yonseiScore < koreaScore :
        print("Korea")
    else :
        print("Draw")