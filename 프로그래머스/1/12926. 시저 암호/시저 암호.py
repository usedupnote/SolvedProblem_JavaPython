def solution(s, n):
    answer = ''
    for i in s :
        if "A" <= i <= "Z" :
            change = ord(i) + n - 65
            i = chr(65 + (change % 26))
        elif "a" <= i <= "z":
            change = ord(i) + n - 97
            i = chr(97 + (change % 26))
        answer += i
    return answer