def solution(arr):
    answer = []
    point = []
    
    for i, num in enumerate(arr):
        if num != 2:
            continue
        
        lp = len(point)
        
        if lp < 2:
            point.append(i)
        else :
            point[1] = i
    
    lp = len(point)
    
    if lp == 0:
        answer = [-1]
    elif lp == 1:
        answer = [2]
    else:
        answer = arr[point[0]:point[1]+1]
            
    return answer