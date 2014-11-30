// greedy scan the array, process them using format sub function
public ArrayList<String> fullJustify(String[] words, int L) {
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<String> line = new ArrayList<String>();
	if (words == null || words.length == 0 || L < 1)
		return result;
	int length = -1; // offset for the space of the first word
	for (int i = 0; i < words.length; i++) {
		length += words[i].length() + 1;
		// adding to line greedy
		if (length <= L)
			line.add(words[i]);
		else {
			result.add(formatLine(line, L, length - words[i].length() - 1));
			line.clear();
			length = -1;
			i--;
		}
	}
	// deal with the last line, justify left
	StringBuilder sb = new StringBuilder();
	for (String s : line) {
		sb.append(s);
		if (sb.length() < L) // add a space after the word
			sb.append(' ');
	}
	while (sb.length() < L)
		// add all the other spaces
		sb.append(' ');
	result.add(sb.toString());
	return result;
}

private String formatLine(ArrayList<String> line, int L, int length) {
	StringBuilder result = new StringBuilder();
	int numOfSpace = L - length;
	int numOfHole = line.size() - 1;
	// only one word
	if (numOfHole == 0) {
		result.append(line.get(0));
		while (numOfSpace-- > 0)
			result.append(' ');
	} else {
		int aveSizeOfHole = numOfSpace / numOfHole + 1;	// average space plus the space itself has
		int numOfRemainder = numOfSpace % numOfHole;	// add the remainders to the fist spaces
		StringBuilder spaces = new StringBuilder();
		while (aveSizeOfHole-- > 0)
			spaces.append(' ');
		for (String s : line) {
			result.append(s);
			if (result.length() == L)
				break; // skip the tail space
			result.append(spaces);
			if (numOfRemainder-- > 0)
				result.append(' ');
		}
	}
	return result.toString();
}
