# Dig-Draw

This project demonstrates how to use [TensorFlow Mobile](https://www.tensorflow.org/mobile/mobile_intro) on Android for handwritten digits classification from MNIST.

<div align="center">
  <img src="image/demo.gif" heigit="500"/>
</div>

### *IN MY CASE SINCE I DONT WANT TO DO THE TRAINING PART SO I SKIPPED STEP 1 & 2

## How to build

### Requirement

- Python 3.6, TensorFlow 1.8.0
- Android Studio 3.0, Gradle 4.1

### Step 1. Training
### Step 2. Model optimization


### Step 3. Build Android app

Copy the `mnist_optimized.pb` generated in Step 2 to `/android/app/src/main/assets`, then build and run the app.

The [Classifer](https://github.com/nex3z/tfmobile-mnist-android/blob/master/android/app/src/main/java/com/nex3z/tfmobilemnist/Classifier.java) creates a [TensorFlowInferenceInterface](https://github.com/tensorflow/tensorflow/blob/master/tensorflow/contrib/android/java/org/tensorflow/contrib/android/TensorFlowInferenceInterface.java) from  `mnist_optimized.pb`. The TensorFlowInferenceInterface provides an interface for inference and performance summarization, which is included in the following library.

```
implementation "org.tensorflow:tensorflow-android:1.8.0"
```


## Credits
-*I have took the pre-trained and pre-optimized model from [nex3z](https://github.com/nex3z/tfmobile-mnist-android)
- The basic model architecture comes from [tensorflow-mnist-tutorial](https://github.com/martin-gorner/tensorflow-mnist-tutorial).
- The official TensorFlow Mobile [Android demo](https://github.com/tensorflow/tensorflow/tree/master/tensorflow/examples/android).
- The [FingerPaint](https://android.googlesource.com/platform/development/+/master/samples/ApiDemos/src/com/example/android/apis/graphics/FingerPaint.java) from Android API demo.
