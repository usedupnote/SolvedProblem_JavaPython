def solution(str_list):
    for i, ch in enumerate(str_list):
        if ch == "l": return str_list[:i]
        elif ch =="r": return str_list[i+1:]
    return []