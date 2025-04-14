def solution(expression):
    answer = 0
    calc = []
    operator = ["+", "-", "*"]
    v = [False for _ in range(3)]
    
    def calculation(x, c, y):
        if c == operator[0]:
            return (x+y)
        elif c == operator[1]:
            return (x-y)
        else:
            return (x*y)
        
    sq = 0

    for i in expression :
        if sq == 0:
            calc.append(int(i))
            sq += 1
        elif i == "+" or i == "-" or i =="*":
            calc.append(i)
            sq = 0
        else :
            calc[-1] = (calc[-1] * 10) + int(i)
            sq += 1
    
    def comb(cnt, result, calc):
        if cnt == 3:
            return abs(calc[0])
        
        for i in range(3):
            if v[i]:
                continue
            v[i] = True
            cur = []
            
            for j, c in enumerate(calc):
                if not cur:
                    cur.append(c)
                elif cur[-1] == operator[i]:
                    pop = cur.pop()
                    cur[-1] = calculation(cur[-1], pop, calc[j])
                else:
                    cur.append(c)
            
            result = max(result, comb(cnt+1, result, cur))
            
            v[i] = False
            
        return result
            
    
    answer = comb(0, 0, calc)
    return answer