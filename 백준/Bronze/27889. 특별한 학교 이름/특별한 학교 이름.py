import sys
input = sys.stdin.readline
name = input().split()
school = {"NLCS": "North London Collegiate School", "BHA": "Branksome Hall Asia", "KIS": "Korea International School", "SJA": "St. Johnsbury Academy"}
print(school[name[0]])