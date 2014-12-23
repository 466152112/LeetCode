// mod operation, and recursive
public static String convertToTitle(int n) {
	StringBuilder result = new StringBuilder();
	if (n < 1)
		return result.toString();
	while (n > 0) {
		char c = (char) ('A' + (n - 1) % 26);
		result.insert(0, c);
		n = (n - 1) / 26;
	}
	return result.toString();
}

return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
