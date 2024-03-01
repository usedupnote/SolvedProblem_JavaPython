def solution(my_string):
    answer = ''
    for i in my_string:
        cur = ord(i)
        if cur < 97 :
            answer += chr(cur + 32)
        else :
            answer += chr(cur - 32)
    return answer