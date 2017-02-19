package com.hankcs.hanlp.algoritm.ahocorasick.trie;

public class FragmentToken extends Token {

    FragmentToken(String fragment) {
        super(fragment);
    }

    @Override
    public boolean isMatch() {
        return false;
    }

    @Override
    public Emit getEmit() {
        return null;
    }
}
