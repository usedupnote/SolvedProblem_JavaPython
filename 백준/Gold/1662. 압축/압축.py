s = input()
curS = '1'
length = 0
stack = []

for i in s:
    if i == '(':
        stack.append([length-1, int(curS)])
        length = 0
    elif i == ')':
        curLen, multipleCnt = stack.pop()
        length = curLen + (length * multipleCnt)
    else :
        curS = i
        length += 1

print(length)