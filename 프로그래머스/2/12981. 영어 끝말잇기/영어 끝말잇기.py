def solution(n, words):
    answer = [0, 0]

    check = set()
    cur = words[0][0]
    
    for i, sentence in enumerate(words):
        if (sentence in check) or (cur[-1] != sentence[0]): 
            answer[0] = (i % n) + 1
            answer[1] = (i // n) + 1
            break
        cur = sentence
        check.add(sentence)

    return answer