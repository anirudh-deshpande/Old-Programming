__author__ = 'Anirudh'

# Recursive

def LCSRec(s1,s2):

    l1 = len(s1)
    l2 = len(s2)
    ret = ""

    if l1 is 0 or l2 is 0:
        return ret

    if s1[l1-1] is s2[l2-1]:
        ret=s1[l1-1]+LCSRec(s1[0:l1-1],s2[0:l2-1])
    else:
        l1rem = LCSRec(s1[0:l1-1],s2)
        l2rem = LCSRec(s1,s2[0:l2-1])

        if len(l1rem) > len(l2rem):
            ret = l1rem
        else:
            ret = l2rem

    return ret


#Dynamic Programming
def computeLCS(s1,s2):
    matrix = [[0 for i in xrange(len(s2))]for i in xrange(len(s1))]
    pointer = [[0 for i in xrange(len(s2))]for i in xrange(len(s1))]

    const_pick_s1_s2 = 0
    const_pick_s1 = 1
    const_pick_s2 = 2

    for i in range(0,len(s1)):
        for j in range(0,len(s2)):

            if s1[i] is s2[j]:

                if i is 0 or j is 0:
                    matrix[i][j] = 1
                else:
                    matrix[i][j] = matrix[i-1][j-1]

                pointer[i][j] = const_pick_s1_s2

            else:

                if i is 0 and j>0:
                    matrix[i][j] = matrix[i][j-1]
                    pointer[i][j] = const_pick_s1

                elif j is 0 and i>0:
                    matrix[i][j] = matrix[i-1][j]
                    pointer[i][j] = const_pick_s2

                elif i>0 and j>0:

                    if matrix[i][j-1] >= matrix[i-1][j]:
                        matrix[i][j]  = matrix[i][j-1]
                        pointer[i][j] = const_pick_s2
                    else:
                        matrix[i][j] = matrix[i-1][j]
                        pointer[i][j] = const_pick_s1

    return pointer

def LCSDynamicProgramming(s1,s2):
    pointer = computeLCS(s1,s2)

    i=len(s1)-1
    j=len(s2)-1
    ret=""

    while i>=0 and j>=0:

        if pointer[i][j] is 0:
            ret=ret+s1[i]
            i=i-1
            j=j-1
        elif pointer[i][j] is 1:
            j=j-1
        else:
            i=i-1

    return ret

print LCSRec("abcdefg","aceg")[::-1]
print LCSDynamicProgramming("abcdefg","aceg")[::-1]