package com.github.sawyer.Hash.LCSS;

import com.github.sawyer.Hash.DistanceMeasure;
import com.github.sawyer.Hash.HashFamily;
import com.github.sawyer.Hash.HashFunction;

import java.util.Arrays;

/**
 * @author sunyue
 * @version 1.0    2016/10/4 14:44
 */
public class LcssHashFamily implements HashFamily {
    private int w;
    private int numOfPoints;

    public LcssHashFamily(int w) {
        this.w = w;
        this.numOfPoints = 5599;     // max=5562
    }

    @Override
    public HashFunction createHashFunction() {
        return new LcssHash(w, numOfPoints);
    }

    @Override
    public Integer combine(int[] hashes) {
        return Arrays.hashCode(hashes);
    }

    @Override
    public DistanceMeasure createDistanceMeasure() {
        return new LcssDistance();
    }

    @Override
    public String toString() {
        return "LcssHashFamily";
    }
}
