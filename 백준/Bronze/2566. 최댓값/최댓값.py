def main():
    import sys
    input = sys.stdin.readline

    result = 0
    A = 0
    B = 0

    for i in range(9) :
        num = list(map(int, input().split()))
        for j in range(9) :
            if num[j] > result :
                result = num[j]
                A = i
                B = j

    print(result)
    print(A + 1, B + 1)



if __name__ == "__main__":
    main()