def solution(strArr):
    answer = []
    for arr in strArr :
        if arr.find("ad") == -1 :
            answer.append(arr)
    return answer