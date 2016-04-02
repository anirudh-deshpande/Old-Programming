__author__ = 'Anirudh'

# 1. Declare a table of size = length * length of string
# 2. Palindrome computed as follows
# 		a. Characters with length 1 is a palindrome
# 		b. If consecutive characters are of same length, they are palindromes
# 		c. Form a window of size 3 onwards and slide the window
# 			- If 1st and last characters of window are same, Inner string is a palindrome, it implies that outer string is also palindrome
# 			- Do this only if the length is greater, Else it is not a palindrome.

def longestPalSubString(s):

    palSub =""
    palSubLen = 0

    length = len(s)
    table = [[0 for i in xrange(length)] for i in xrange(length)]

    for i in range (0,length):
        table[i][i]=1
        palSubLen = 1
        palSub =s[i]


    for i in range (0,length-1):
        if(s[i]==s[i+1]):
            table[i][i+1]=1
            palSubLen=2
            palSub=s[i:i+2]

    for l in range (2,length):
        for i in range (0,length-l):
            j=i+l

            if(s[i] == s[j]):
                table[i][j] = table[i+1][j-1]

                if table[i][j] == 1 and j-i > palSubLen:
                    palSubLen = j-i
                    palSub = s[i:j+1]

    return palSub

s = "abbadabba"
print longestPalSubString(s)