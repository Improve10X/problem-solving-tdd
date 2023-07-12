package com.improve10x.scoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ScoringTest {
    private Scoring scoring;

    @BeforeEach
    public void setup() {
        scoring = new Scoring();
    }

    @Test
    public void nothing() {}

    @Test
    public void givenNull_returnsAllZeros() {
        int[] allZeros = scoring.calculateScores(null);
        assertArrayEquals(new int[3], allZeros);
    }

    @Test
    public void givenEmpty_returnsAllZeros() {
        int[] allZeros = scoring.calculateScores("");
        assertArrayEquals(new int[3], allZeros);
    }

    @Test
    public void givenA_returnsOneZeroZero() {
        int[] onlyAScores = scoring.calculateScores("A");
        assertArrayEquals(new int[]{1, 0, 0}, onlyAScores);
    }

    @Test
    public void givenB_returnsZeroOneZero() {
        int[] onlyBScores = scoring.calculateScores("B");
        assertArrayEquals(new int[]{0, 1, 0}, onlyBScores);
    }

    @Test
    public void givenC_returnsZeroZeroOne() {
        int[] onlyCScores = scoring.calculateScores("C");
        assertArrayEquals(new int[]{0, 0, 1}, onlyCScores);
    }

    @Test
    public void givenAB_returnsOneOneZero() {
        int[] abScores = scoring.calculateScores("AB");
        assertArrayEquals(new int[]{1, 1, 0}, abScores);
    }

    @Test
    public void givenABC_returnsAllOnes() {
        int[] abcScores = scoring.calculateScores("ABC");
        assertArrayEquals(new int[]{1, 1, 1}, abcScores);
    }

    @Test
    public void givenAABC_returnsTwoOneOne() {
        int[] aabcScores = scoring.calculateScores("AABC");
        assertArrayEquals(new int[]{2, 1, 1}, aabcScores);
    }

    @Test
    public void givenABBC_returnsOneTwoOne() {
        int[] abbcScores = scoring.calculateScores("ABBC");
        assertArrayEquals(new int[]{1, 2, 1}, abbcScores);
    }

    @Test
    public void givenABCC_returnsOneOneTwo() {
        int[] abccScores = scoring.calculateScores("ABCC");
        assertArrayEquals(new int[]{1, 1, 2}, abccScores);
    }

    @Test
    public void givenABBACCCCAC_returnsThreeTwoFive() {
        int[] abbaccccacScores = scoring.calculateScores("ABBACCCCAC");
        assertArrayEquals(new int[]{3, 2, 5}, abbaccccacScores);
    }
}
