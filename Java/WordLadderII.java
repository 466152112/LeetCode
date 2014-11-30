/*Leetcode 第一难题，六星级！ 帆船酒店来了！
难点考点：
1 知道什么时候去掉重复，会使用set容器避免重复
2 高级层序遍历树应用
3 适当时候去掉字典中的单词避免重复
4 知道什么时候结束层序
5 利用高级数据结构保存结果，本程序使用unordered_map<string, vector<string> >
6 使用递归回溯法，利用高级数据结构，构造最终结果
每一点几乎都可以成为一个大题，都糅合在一起了，加上各个细节，那么就构成了一个六星级难题了。

注意细节：
1 上一层的单词要删掉，否则会有回路，形成无线循环
2 下一层保存单词不能重复，否则会有很多多余的单词处理，造成time limit excessed

子节点可以重复，但是只保留一个子节点，不过要保留这个子节点的多个父母节点，但是子节点只能保留一份。
要怎么完成这个操作呢？
1 使用set保留子节点
2 使用map<string, vector<string> > 保留父母节点，这样确保只有一个string子节点，而可以有多个父母节点vector<string>
形成path的时候，因为最终根节点肯定是start，所以一个孩子节点分别从多个父母节点回溯，都必然会到达start根节点

/* Graph of example:
 *                |--- dot --- dog ---|
 * hit --- hot -- |     |       |     |--- cog
 *                |--- lot --- log ---|
 * 
 * backward adjacent list:
 * hit => null
 * hot => hit
 * dot => hot
 * lot => hot
 * dog => dot
 * log => lot
 * cog => dot -- log
 */
*/

// MLGB, 吐了一屏幕雪
public ArrayList<ArrayList<String>> findLadders(String start, String end,
		HashSet<String> dict) {
	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	if (start == null || end == null || dict == null || start.equals(end))
		return result;
	// HashMap for DFS paths, HashSet for remove visited words
	HashMap<String, Queue<String>> adjMap = new HashMap<String, Queue<String>>();
	HashSet<String> visitedThisLevel = new HashSet<String>();
	dict.add(end);
	dict.remove(start);
	// initial empty adjMap for each word
	for (String word : dict)
		adjMap.put(word, new LinkedList<String>());
	// BSF
	Queue<String> queue = new LinkedList<String>();
	queue.offer(start);
	boolean found = false;
	int currentLen = 1; // default value for current level BFS
	int nextLen = 0; // default value for the next level BFS
	int currentDepth = 0; // count BFS depth

	// BFS
	while (!queue.isEmpty()) {
		String currLadder = queue.poll();
		// for all unvisited words that are one character change from
		// current word
		for (String nextLadder : getNextLadders(currLadder, dict)) {
			if (visitedThisLevel.add(nextLadder)) {
				nextLen++;
				queue.offer(nextLadder);
			}
			adjMap.get(nextLadder).offer(currLadder);
			if (nextLadder.equals(end) && !found) {
				found = true;
				currentDepth++;
			}
		}
		currentLen--;
		if (currentLen == 0) {
			if (found)
				break;
			dict.removeAll(visitedThisLevel);
			currentLen = nextLen;
			nextLen = 0;
			currentDepth++;
		}
	}
    /*
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			String currentLadder = queue.poll();
			for (String nextLadder : getNextLadders(currentLadder, dict)) {
				if (!found && nextLadder.equals(end)) {
					found = true;
					currentDepth++;
				}
				if (visitedThisLevel.add(nextLadder)) {
					queue.offer(nextLadder);
				}
				// 子节点可以重复，但是只保留一个子节点，不过要保留这个子节点的多个父母节点，但是子节点只能保留一份。
				adjMap.get(nextLadder).offer(currentLadder);
			}
		}
		if (found)
			break;
		dict.remove(visitedThisLevel);
		currentDepth++;
	}
    */
    
	// DFS to get the path
	if (found) {
		LinkedList<String> p = new LinkedList<String>();
		p.addFirst(end);
		getLadders(start, end, p, result, adjMap, currentDepth);
	}
	// DFS to get the path
	return result;
}

private ArrayList<String> getNextLadders(String currentLadder,
		HashSet<String> dict) {
	ArrayList<String> result = new ArrayList<String>();
	for (int i = 0; i < currentLadder.length(); i++) {
		StringBuilder sb = new StringBuilder(currentLadder);
		for (char c = 'a'; c <= 'z'; c++) {
			sb.setCharAt(i, c);
			if (dict.contains(sb.toString()))
				result.add(sb.toString());
		}
	}
	return result;
}

// DFS to get all possible path from start to end
private void getLadders(String start, String currLadder,
		LinkedList<String> p, ArrayList<ArrayList<String>> solu,
		HashMap<String, Queue<String>> adjMap, int len) {

	if (currLadder.equals(start)) {
		solu.add(new ArrayList<String>(p));
		return;
	}
	if (len <= 0)
		return;
	for (String lad : adjMap.get(currLadder)) {
		p.addFirst(lad);
		getLadders(start, lad, p, solu, adjMap, len - 1);
		p.removeFirst();
	}
}
