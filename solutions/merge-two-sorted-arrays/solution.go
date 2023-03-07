package main

/**
 * @param a: sorted integer array A
 * @param b: sorted integer array B
 * @return: A new sorted integer array
 */
func MergeSortedArray(a []int, b []int) []int {
	lenA, lenB := len(a), len(b)
	c := make([]int, lenA+lenB)
	i, j, k := 0, 0, 0
	for k < lenA+lenB {
		if i == lenA {
			c[k] = b[j]
			j++
		} else if j == lenB {
			c[k] = a[i]
			i++
		} else if a[i] < b[j] {
			c[k] = a[i]
			i++
		} else {
			c[k] = b[j]
			j++
		}
		k++
	}
	return c
}
