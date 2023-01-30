def TriangleArea(a, b, c, d, e, f) :
    result = (1/2) * ((a*d + c*f + e*b) - (b*c + d*e + a*f))
    return result


N = int(input())
point = []
area = 0

for i in range(N) :
    point.append(input().split())
    point[i][0] = int(point[i][0])
    point[i][1] = int(point[i][1])

for i in range(N-2) :
    area += TriangleArea(point[0][0], point[0][1], point[i+1][0], point[i+1][1], point[i+2][0], point[i+2][1])

print(format(abs(area), ".1f"))