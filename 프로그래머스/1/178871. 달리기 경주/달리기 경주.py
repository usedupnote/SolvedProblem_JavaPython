def solution(players, callings):
    playerDict = {}
    answer = players
    
    for i in range(len(players)):
        playerDict[players[i]] = i
    
    for i in callings:
        j = answer[playerDict[i]-1]
        answer[playerDict[i]] = j
        answer[playerDict[i]-1] = i
        playerDict[i] -= 1
        playerDict[j] += 1
    return answer