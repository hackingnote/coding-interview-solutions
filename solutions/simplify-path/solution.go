package main

import "strings"

func simplifyPath(path string) string {
	var parts []string
	for _, s := range strings.Split(path, "/") {
		switch s {
		case ".", "":
			continue
		case "..":
			if len(parts) > 0 {
				parts = parts[:len(parts)-1]
			}
		default:
			parts = append(parts, s)
		}
	}
	return "/" + strings.Join(parts, "/")
}
