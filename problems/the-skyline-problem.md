# The Skyline problem

## Description

Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. Buildings may overlap if you see them from far away，find the outline of them。

An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.

Note: Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.

## Example

Given 3 buildings：

```
[
  [1, 3, 3],
  [2, 4, 4],
  [5, 6, 1]
]
```

The outlines are：

```
[
  [1, 2, 3],
  [2, 4, 4],
  [5, 6, 1]
]
```

## Solution

From the input, create tuples `(x, height, isStart)`, so each building will create 2 tuples, one for start point and one for end point. Sort the tuples by x, then for each tuple:

- if `start`:
  - if height higher than previous height, a new segment! Add to the result and push the height to the heap
  - otherwise just push the height to the heap.
- else `end`:
  - if height lower than the highest height from the heap, just delete it(or mark it as deleted)
  - else a new segment! Add to the result and pop from the heap.

Note: during sorting, for the same `x`, end point should be prior to the start point to prevent multiple segments at the same height.

## Code (Python)

```python
from heapq import heappush, heappop

class Solution:
    """
    @param buildings: A list of lists of integers
    @return: Find the outline of those buildings
    """
    def buildingOutline(self, buildings):
        edges = []
        result = []
        deleted = {}
        for (start, end, height) in buildings:
            edges.append((start, height, True))
            edges.append((end, height, False))  
        edges.sort(key=lambda tup: (tup[0], not tup[2]))
        print(edges)
        heap = []
        prevX = 0
        for (x, y, isStart) in edges: 
            if not heap:
                heappush(heap, -y)
                prevX = x
            elif isStart:
                if y > -heap[0]:
                    if prevX != x:
                        result.append([prevX, x, -heap[0]])
                    heappush(heap, -y)
                    prevX = x
                else:
                    heappush(heap, -y)
            else:
                if y < -heap[0]:
                    deleted[y] = deleted.get(y, 0) + 1
                else:
                    highest = -heappop(heap)
                    if heap and highest == -heap[0]: continue
                    if prevX != x:
                        result.append([prevX, x, y])
                    while heap and deleted.get(-heap[0], 0) > 0:
                        deleted[-heap[0]] -= 1
                        heappop(heap)            
                  prevX = x
        return result
```