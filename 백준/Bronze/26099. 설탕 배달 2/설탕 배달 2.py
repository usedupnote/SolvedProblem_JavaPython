def main():
    import sys
    input = sys.stdin.readline

    N = int(input())

    result = -1

    for i in range(11) :
        if N - (i * 3) < 0 :
            break
        if (N - (i * 3)) % 5 == 0 :
            result = i + ((N - (i * 3)) // 5)
            break

    print(result)

if __name__ == "__main__":
    main()