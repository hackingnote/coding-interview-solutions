package main

func canCompleteCircuit(gas []int, cost []int) int {
	start := 0
	tank := 0
	for i := range gas {
		tank = tank + gas[i] - cost[i]
		if tank < 0 {
			start = i + 1
			tank = 0
		}
	}
	for i := 0; i < start; i++ {
		tank = tank + gas[i] - cost[i]
		if tank < 0 {
			return -1
		}
	}
	return start
}

func canCompleteCircuit2(gas []int, cost []int) int {
	net := 0
	for i := range gas {
		net += gas[i] - cost[i]
	}
	if net < 0 {
		return -1
	}
	start, tank := 0, 0
	for i := range gas {
		tank = tank + gas[i] - cost[i]
		if tank < 0 {
			start = i + 1
			tank = 0
		}
	}
	return start
}
