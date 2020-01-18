package com.ranx.chowder.deepinjvm.jvm9chapter.action;

/**
* @Description: 修改Class文件，暂时只提供修改常量池常量的功能，
* 将常量池中指定内容的CONSTANT_Utf8_info常量替换为新的字符串
* @author ranx
* @date 2019年12月19日17:01:54
 */
public class ClassModifier {

	//Class文件中常量池的起始偏移
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;
	
	//CONSTANT_Utf8_info常量的tag标志
	private static final int CONSTANT_utf8_info = 1;
	
	//常量池中11种常量所占的长度，CONSTANT_Utf8_info型常量除外，因为他不是定长的
	private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};
	
	private static final int u1 = 1;
	private static final int u2 = 2;
	
	private byte[] classByte;
	
	public ClassModifier(byte[] classByte) {
		this.classByte = classByte;
	}
	
	public byte[] modifyUTF8Constant(String oldStr, String newStr) {
		int cpc = getConstantPoolCount();
		int offset = CONSTANT_POOL_COUNT_INDEX + u2;
		for (int i=0; i<cpc; i++) {
			int tag = ByteUtils.bytes2Int(classByte, offset, u1);
			if (tag == CONSTANT_utf8_info) {
				int len = ByteUtils.bytes2Int(classByte, offset + u1, u2);
				offset += (u1 + u2);
				String str = ByteUtils.bytes2String(classByte, offset, len);
				if (str.equalsIgnoreCase(oldStr)) {
					byte[] strBytes = ByteUtils.string2Bytes(newStr);
					byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
					classByte = ByteUtils.bytesReplace(classByte, offset-u2, u2, strLen);
					classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
					return classByte;
				} else {
					offset += len;
				}
			} else {
				offset += CONSTANT_ITEM_LENGTH[tag];
			}
		}
		return classByte;
	}
	
	/**
	 * 获取常量池中常量的数量
	 * @return
	 */
	public int getConstantPoolCount() {
		return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
	}
}
