# Enter your code here. Read input from STDIN. Print output to STDOUT
def max_stock(A, start):
    if start >= len(A) - 1:
        return 0
    peak_index = A[start:].index(max(A[start:])) + start
    this_profit = A[peak_index]*(peak_index - start) - sum(A[start:peak_index])
    return this_profit + max_stock(A,peak_index + 1)

T = int(raw_input())
for i in range(T):
    N = int(raw_input())
    A = map(int, raw_input().strip().split(' '))
    print max_stock(A,0)
