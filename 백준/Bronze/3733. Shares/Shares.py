while True:
    try:
        num = list(map(int, input().split()))
        print((num[1])//(num[0] + 1))
    except:
        break