package com.hankcs.hanlp.algoritm.ahocorasick.trie;

/**
 * 配置
 */
class TrieConfig {
    /**
     * 只保留最长匹配
     */
    boolean remainLongest = false;
    /**
     * 允许重叠
     */
    private boolean allowOverlaps = true;

    /**
     * 是否允许重叠
     *
     * @return
     */
    boolean isAllowOverlaps() {
        return allowOverlaps;
    }

    /**
     * 设置是否允许重叠
     *
     * @param allowOverlaps
     */
    void setAllowOverlaps(boolean allowOverlaps) {
        this.allowOverlaps = allowOverlaps;
    }
}
