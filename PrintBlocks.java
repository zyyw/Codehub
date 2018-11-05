/**
 * Give an positive integer, print all valid block.
 * Example:
 * n = 3 
 * output:
 * if {
 *   if {
 *       if {
 *       }
 *   }
 * }
 *
 * if {
 *   if {
 *   }
 *   if {
 *   }
 * }
 *
 * if {
 *   if {
 *   }
 * }
 * if {
 * }
 *
 * if {
 * }
 * if {
 *   if {
 *   }
 * }
 *
 * if {
 * }
 * if {
 * }
 * if {
 * }
 *
 * Idea:
 * 1. 插入 openBlock 的条件：
 *    1.1 已经插入的 openBlock 的个数 < 输入 n
 *    1.2 在插入 openBlock 之前，要插入 tab 的个数 ＝ 已经插入的 openBlock 的个数 - 已经插入的 closeBlock 的个数。
 *    	  think it as an offset
 * 2. 插入 closeBlock 的条件：
 *    2.1 已经插入的 closeBlock 的个数 < 插入的 openBlock 的个数
 *    2.2 在插入 closeBlock 之前，要插入的 tab 的个数 ＝ (已经插入的 openBlock 的个数 - 1) - 已经插入的 closeBlock 的个数
 *
 * 难点:
 *   在插入 openBlock 或者 closeBlock 之前需要插入的 tab 的个数 !!!!
 **/

public class PrintBlocks {
	public void printBlocks(int n) {
		// input sanity check
		if (n <= 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		printBlocksHelper(n, 0, 0, sb);
	}

	private void printBlocksHelper(int n, int left, int right, StringBuilder sb) {
		if (left == n && right == n) {
			System.out.println(sb.toString());
			return;
		}
		// insert open block
		int sz = sb.length();
		if (left < n) {
			addOpenBlock(sb, left - right);
			printBlocksHelper(n, left + 1, right, sb);
			sb.setLength(sz); // backtrack
		}

		// insert close block
		if (right < left) {
			addCloseBlock(sb, left - 1 - right);
			printBlocksHelper(n, left, right + 1, sb);
			sb.setLength(sz); // backtrack
		}
	}

	private void addOpenBlock(StringBuilder sb, int indentLevel) {
		for (int i = 0; i < indentLevel; ++i) {
			sb.append(tab);
		}
		sb.append(openBlock);
	}

	private void addCloseBlock(StringBuilder sb, int indentLevel) {
		for (int i = 0; i < indentLevel; ++i) {
			sb.append(tab);
		}
		sb.append(closeBlock);
	}

	private static final String openBlock = "if {";
	private static final String closeBlock = "}";
	private static final char tab = '\t';
}
