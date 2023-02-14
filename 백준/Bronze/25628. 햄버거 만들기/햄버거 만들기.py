import sys
input = sys.stdin.readline

burgerIngredient = list(map(int, input().split()))

result = min(burgerIngredient[0] // 2, burgerIngredient[1])

print(result)