package dev.prateek.com.dig_draw;

/**
 * Created by prateek on 19-05-2018.
 */

public class Result {

    private final int mNumber;
    private final float mProbability;
    private final long mTimeCost;

    public Result(float[] result, long timeCost) {
        mNumber = argmax(result);
        mProbability = result[mNumber];
        mTimeCost = timeCost;
    }

    public int getNumber() {
        return mNumber;
    }

    public float getProbability() {
        return mProbability;
    }

    public long getTimeCost() {
        return mTimeCost;
    }

    private static int argmax(float[] probs) {
        int maxIdx = -1;
        float maxProb = 0.0f;
        for (int i = 0; i < probs.length; i++) {
            if (probs[i] > maxProb) {
                maxProb = probs[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

}