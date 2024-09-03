package com.nk.reviewsapptemp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.review.model.ReviewErrorCode;
import com.google.android.play.core.review.testing.FakeReviewManager;

/**
 * https://developer.android.com/guide/playcore/in-app-review/kotlin-java - Google documentation
 * https://developer.android.com/guide/playcore/in-app-review/test - test Google documentation
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Test_code";
    private Button writeReviewTestBtn;

    private ReviewManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReferences();

//        manager = ReviewManagerFactory.create(getBaseContext());
//        manager = new FakeReviewManager(getBaseContext());
//        Task<ReviewInfo> request = manager.requestReviewFlow();
//        request.addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                Log.d(TAG, "onCreate: We can get the ReviewInfo object");
//                ReviewInfo reviewInfo = task.getResult();
//                Log.d(TAG, "onCreate: ReviewInfo object: " + reviewInfo.toString());
//            } else {
//                Log.d(TAG, "onCreate: There was some problem, log or handle the error code");
////                @ReviewErrorCode int reviewErrorCode = ((ReviewException) task.getException()).getErrorCode();
////                Log.d(TAG, "onCreate: Error code: " + reviewErrorCode);
//            }
//        });

        writeReviewTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InAppReview inAppReview = new InAppReview();
                inAppReview.askUserForReview(getBaseContext());
            }
        });
    }

    private void setReferences() {
        writeReviewTestBtn = findViewById(R.id.write_review_test_btn);
    }
}