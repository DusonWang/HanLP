/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/9/13 13:34</create-date>
 *
 * <copyright file="SynonymHelper.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014, 上海林原信息科技有限公司. All Right Reserved, http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.hanlp.corpus.synonym;

/**
 * 一个Util
 *
 * @author hankcs
 */
public class SynonymHelper {
    /**
     * 同一行最多支持编码这么多个单词
     */
    private static final long MAX_WORDS = 999L;
    /**
     * 尾数的长度，表示原子词的index
     */
    private static final int MAX_INDEX_LENGTH = String.valueOf(MAX_WORDS).length();

    static long convertString2Id(String idString) {
        long id;
        id = (idString.charAt(0) - 'A') * 26L * 10 * 10 * 26 * 10 * 10 +
                (idString.charAt(1) - 'a') * 10 * 10 * 26 * 10 * 10 +
                (idString.charAt(2) - '0') * 10 * 26 * 10 * 10 +
                (idString.charAt(3) - '0') * 26 * 10 * 10 +
                (idString.charAt(4) - 'A') * 10 * 10 +
                (idString.charAt(5) - '0') * 10 +
                (idString.charAt(6) - '0');    // 编码等号前面的
        return id;
    }

    private static String convertId2String(long id) {
        return String.valueOf((char) (id / (26 * 10 * 10 * 26 * 10 * 10) + 'A')) +
                (char) (id % (26 * 10 * 10 * 26 * 10 * 10) / (10 * 10 * 26 * 10 * 10) + 'a') +
                (char) (id % (10 * 10 * 26 * 10 * 10) / (10 * 26 * 10 * 10) + '0') +
                (char) (id % (10 * 26 * 10 * 10) / (26 * 10 * 10) + '0') +
                (char) (id % (26 * 10 * 10) / (10 * 10) + 'A') +
                (char) (id % (10 * 10) / (10) + '0') +
                (char) (id % (10) / (1) + '0');
    }

    private static long convertString2IdWithIndex(String idString, long index) {
        long id = convertString2Id(idString);
        id = id * MAX_WORDS + index;
        return id;
    }

    public static long convertString2IdWithIndex(String idString, int index) {
        return convertString2IdWithIndex(idString, (long) index);
    }

    static String convertId2StringWithIndex(long id) {
        String idString = convertId2String(id / MAX_WORDS);
        long index = id % MAX_WORDS;
        return String.format("%s%0" + MAX_INDEX_LENGTH + "d", idString, index);
    }

    public static void main(String[] args) {
        System.out.println(convertId2StringWithIndex(convertString2IdWithIndex("Zg83H75=", 0)));
    }
}
