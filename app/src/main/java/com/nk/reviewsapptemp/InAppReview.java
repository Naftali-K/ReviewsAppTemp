package com.nk.reviewsapptemp;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.review.testing.FakeReviewManager;

/**
 * @Author: naftalikomarovski
 * @Date: 2024/09/03
 */


/**
 * https://youtu.be/iv7J-9oqGxA?si=3Yss5gV_3laTazI3 - lesson video
 */
public class InAppReview {

    private static final String TAG = "Test_code";

    public void askUserForReview(Context context) {
//        ReviewManager manager = ReviewManagerFactory.create(context);
        ReviewManager manager = new FakeReviewManager(context);

        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d(TAG, "onCreate: We can get the ReviewInfo object");
                ReviewInfo reviewInfo = task.getResult();
                Log.d(TAG, "onCreate: ReviewInfo object: " + reviewInfo.toString());
            } else {
                Log.d(TAG, "onCreate: There was some problem, log or handle the error code");
                String reviewError = task.getException().getMessage();
                Log.d(TAG, "onCreate: Error Message: " + reviewError);
            }
        });
    }
}
