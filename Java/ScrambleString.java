/*
For example, given "great" and "rgate", the splits are
("great") vs. ("rgate")
("g", "reat") vs. ("r", "gate") or ("rgat", "e")
("gr", "eat") vs. ("rg", "ate") or ("te", "rga")
("gre", "at") vs. ("rga", "te") or ("ate", "rg")
("grea", "t") vs. ("rgat", "e") or ("gate", "r")
*/
// DP using 3D table, O(N^4)

// recursive O(2^N) exponential
