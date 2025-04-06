import sys
input = sys.stdin.readline

result = 0
s = input()

def correctBracket() :
    cal = [-1]
    for i in s:
        if i == '(':
            cal.append(-2)
        elif i == '[':
            cal.append(-3)
        elif i == ')':
            cur = 0
            while len(cal):
                pop = cal.pop()
                if pop < 0:
                    if pop == -2:
                        if cur == 0:
                            cur = 1
                        cur *= 2
                        cal.append(cur)
                        break
                    else :
                        return 0
                else :
                    cur += pop
        elif i == ']':
            cur = 0
            while len(cal):
                pop = cal.pop()
                if pop < 0:
                    if pop == -3:
                        if cur == 0:
                            cur = 1
                        cur *= 3
                        cal.append(cur)
                        break
                    else :
                        return 0
                else :
                    cur += pop
    if -2 in cal or -3 in cal:
        return 0
    cal.pop(0)
    return sum(cal)

print(correctBracket())