package main

func numIslands(grid [][]byte) int {
	lenX, lenY := len(grid), len(grid[0])
	visited := make([][]bool, lenX)
	for i := range visited {
		visited[i] = make([]bool, lenY)
	}

	var dfs func(i, j int)
	dfs = func(i, j int) {
		if i < 0 || i >= lenX || j < 0 || j >= lenY || grid[i][j] == '0' || visited[i][j] {
			return
		}
		visited[i][j] = true
		dfs(i, j+1)
		dfs(i, j-1)
		dfs(i+1, j)
		dfs(i-1, j)
	}

	cnt := 0
	for i := 0; i < lenX; i++ {
		for j := 0; j < lenY; j++ {
			if grid[i][j] == '1' && !visited[i][j] {
				cnt += 1
				dfs(i, j)
			}
		}
	}
	return cnt
}
