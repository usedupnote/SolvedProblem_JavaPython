def solution(wallpaper):
    answer = [51,51,0,0]
    lenHeight = len(wallpaper)
    lenWidth = len(wallpaper[0])
    
    for i in range(lenHeight) :
        for j in range(lenWidth) :
            if wallpaper[i][j] == "#" :
                if i < answer[0] :
                    answer[0] = i
                if i >= answer[2] :
                    answer[2] = i+1
                if j < answer[1] :
                    answer[1] = j
                if j >= answer[3] :
                    answer[3] = j+1
    
    return answer