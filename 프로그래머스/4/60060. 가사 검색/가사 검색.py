
from bisect import bisect_left, bisect_right

def rangeCounter(a, leftV, rightV):
    right = bisect_right(a, rightV)
    left = bisect_left(a, leftV)
    return right - left


def solution(words, queries):
    array = [[] for _ in range(10001)]
    reverse = [[] for _ in range(10001)]

    answer = []
    for word in words:
        array[len(word)].append(word)
        reverse[len(word)].append(word[::-1])
        
    for i in range(10001):
        array[i].sort()
        reverse[i].sort()
        
    for query in queries:
        if query[0] != '?':
            res = rangeCounter(array[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
        else:
            res = rangeCounter(reverse[len(query)], query[::-1].replace('?','a'), query[::-1].replace('?', 'z'))
        answer.append(res)
    return answer
            