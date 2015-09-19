# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        n = len(points)
        max_counts = n if n <3 else 2
        for i in range(n-1):
            count = {'self_point':1} # in case of empty map
            dups = 0
            for j in range(i+1,n):
                if points[j].x == points[i].x and points[j].y == points[i].y:
                    dups += 1
                    continue
                this_line = self.line(points[i],points[j])
                if this_line in count:
                    count[this_line] += 1
                else:
                    count[this_line] = 2
            for k,v in count.items():
                print v, max_counts
                max_counts = max(v+dups,max_counts)
        return max_counts
        
    def line(self, point1, point2):
        a = 0.0
        if point1.x == point2.x:
            a = '#'
        else:
            a = (point2.y-point1.y)*1.0/(point2.x-point1.x)
        return a
