class Solution:
    # @return an integer
    def reverse(self, x):
        x_str = str(x)
        nag = ''
        if x_str[0] == '-':
            nag = '-'
            x_str = x_str[1:]
        x_new = x_str[::-1]
        x_new = nag + x_new
        return int(x_new)
