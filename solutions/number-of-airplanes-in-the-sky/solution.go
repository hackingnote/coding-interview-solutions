package main

import (
	"sort"
)

type Interval struct {
	Start, End int
}

/**
 * @param airplanes: An interval array
 * @return: Count of airplanes are in the sky.
 */
func CountOfAirplanes(airplanes []*Interval) int {
	m := make(map[int]int)
	for _, interval := range airplanes {
		m[interval.Start] += 1
		m[interval.End] -= 1
	}
	var keys []int
	for k := range m {
		keys = append(keys, k)
	}
	sort.Ints(keys)
	cnt, max := 0, 0
	for _, k := range keys {
		cnt += m[k]
		if max < cnt {
			max = cnt
		}
	}
	return max
}
