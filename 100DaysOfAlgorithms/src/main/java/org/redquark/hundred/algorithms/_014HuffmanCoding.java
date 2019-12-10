package org.redquark.hundred.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The Huffman algorithm is a greedy algorithm. Since at every stage it looks
 * for the best available option. A Disadvantage of Huffman codes is that a
 * minor change in any bit of the encoded string would break the whole message.
 * 
 * @author Anirudh Sharma
 *
 */
public class _014HuffmanCoding {

	// Prefix map for character
	private Map<Character, String> characterPrefixMap = new HashMap<>();
	// Root of the Huffman Tree
	private HuffmanNode root;

	public String encode(String input) {
		// This map will store the frequencies for each character in the input
		Map<Character, Integer> frequencies = new HashMap<>();
		// Loop through entire length of the input string
		for (int i = 0; i < input.length(); i++) {
			// Current character in the string
			char c = input.charAt(i);
			if (!frequencies.containsKey(c)) {
				// Update the frequency of the current character by 1
				frequencies.put(c, 0);
			}
			// This means the character is occurring for the first time
			frequencies.put(c, frequencies.get(c) + 1);
		}
		// Build the Huffman Tree
		root = buildTree(frequencies);
		// Set the prefix codes
		setPrefixCodes(root, new StringBuilder());

		// Create the encoding for each character and thus entire string
		StringBuilder encoded = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			// Get the current character
			char c = input.charAt(i);
			// Append the prefix of this character in the encoded string
			encoded.append(characterPrefixMap.get(c));
		}
		return encoded.toString();
	}

	/**
	 * This method takes the encoded String and decodes it into the original one
	 */
	public String decode(String encoded) {
		// Instance to store the decoded string
		StringBuilder decoded = new StringBuilder();

		// Get the reference of the current root node
		HuffmanNode temp = root;

		// Run through the entire encoded string
		for (int i = 0; i < encoded.length(); i++) {
			// Get the current character in the encoded string - it will either be 0 or 1
			char current = encoded.charAt(i);

			// If it is 0, then move to the left child
			if (current == '0') {
				// Move left
				temp = temp.left;
				// If the node is the leaf node
				if (temp.left == null && temp.right == null) {
					decoded.append(temp.data);
					temp = root;
				}
			}

			// If it is 1, then move to the right child
			if (current == '1') {
				// Move right
				temp = temp.right;
				// If the node is the leaf node
				if (temp.left == null && temp.right == null) {
					decoded.append(temp.data);
					temp = root;
				}
			}
		}
		return decoded.toString();
	}

	/**
	 * This method builds the Huffman Tree
	 * 
	 * 1. Get Frequency of each character and store it in a Map.
	 * 
	 * 2. Create a node for each character with its frequency and insert it into a
	 * Min Priority Queue.
	 * 
	 * 3. Extract the two nodes with the minimum frequency from the priority queue.
	 * 
	 * 4. Create a new node by merging these two nodes as children and with weight
	 * equal to the sum of the two nodes frequencies.
	 * 
	 * 5. Add this back to the Priority Queue.
	 * 
	 * 6. Repeat till the Priority Queue has only one node left. That node becomes
	 * the root of the Huffman Tree.
	 */
	private HuffmanNode buildTree(Map<Character, Integer> frequencies) {
		// Priority Queue for creating Huffman Tree
		PriorityQueue<HuffmanNode> heap = new PriorityQueue<>();
		// Loop through the frequencies map and then create nodes accordingly
		for (Character c : frequencies.keySet()) {
			// Create a HuffmanNode instance
			HuffmanNode node = new HuffmanNode();
			// Set the data (character) and its frequency in the node
			node.data = c;
			node.frequency = frequencies.get(c);
			// Set the left and right nodes as null
			node.left = null;
			node.right = null;
			// Add the node in the PriorityQueue
			heap.offer(node);
		}

		// Loop until we have more than one element left in the priority queue
		while (heap.size() > 1) {
			// Get the minimum two nodes
			HuffmanNode x = heap.poll();
			HuffmanNode y = heap.poll();

			// Create a node that will store the sum of the frequencies of the two minimum
			// nodes
			HuffmanNode sum = new HuffmanNode();
			sum.data = '-';
			sum.frequency = x.frequency + y.frequency;
			sum.left = x;
			sum.right = y;
			root = sum;
			// Add this node in the priority queue
			heap.offer(sum);
		}
		return heap.poll();
	}

	/**
	 * This method sets the prefix code for each character
	 * 
	 * 1. Starting at the top when you go left, append 0 to the prefix code string.
	 * 
	 * 2. When you go right, append 1.
	 * 
	 * 3. Stop when you have reached the Leaf nodes.
	 * 
	 * 4. The string of 0 and 1s created till now is the prefix code of that
	 * particular Node in the tree.
	 */
	private void setPrefixCodes(HuffmanNode node, StringBuilder prefix) {
		// Check if node is not null
		if (node != null) {
			// Check if the current node is the leaf node
			if (node.left == null && node.right == null) {
				// Add this node in the prefix map
				characterPrefixMap.put(node.data, prefix.toString());
			} else {
				// Else we append 0 to left child and 1 to right child as weights
				prefix.append('0');
				setPrefixCodes(node.left, prefix);
				prefix.deleteCharAt(prefix.length() - 1);
				prefix.append('1');
				setPrefixCodes(node.right, prefix);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
	}

	/**
	 * This class represents each node in the Huffman Tree
	 */
	private class HuffmanNode implements Comparable<HuffmanNode> {

		// Data to be stored in the node. It represents one character from the input
		private char data;
		// Frequency of the character stored in the node
		private int frequency;
		// Left child of the node
		private HuffmanNode left;
		// Right child of the node
		private HuffmanNode right;

		@Override
		public int compareTo(HuffmanNode o) {
			return this.frequency - o.frequency;
		}
	}
}
