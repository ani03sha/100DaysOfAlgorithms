package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _014HuffmanCodingTest {

	_014HuffmanCoding hc = new _014HuffmanCoding();

	/**
	 * Test method for both encoding and decoding a String using Huffman Coding
	 */
	@Test
	void testEncodeAndDecode() {
		assertEquals("1001011", hc.encode("ABACA"));
		assertEquals("ABACA", hc.decode("1001011"));
		
		assertEquals("000011101010111110100001", hc.encode("ABCD1%$^"));
		assertEquals("ABCD1%$^", hc.decode("000011101010111110100001"));
	}

}
