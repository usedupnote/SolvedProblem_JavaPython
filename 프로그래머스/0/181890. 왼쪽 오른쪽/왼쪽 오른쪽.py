def solution(str_list):
    answer = []
    for i, ch in enumerate(str_list):
        if ch == "l":
            answer = list(i for i in str_list[:i])
            break
        elif ch =="r":
            answer = list(i for i in str_list[i+1:])
            break
    return answer