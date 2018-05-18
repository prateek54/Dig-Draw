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
### FYI : How is TensorFlowInferenceInterface Used ?
##  Ans  : 
# Step 1 { Code — Initialization } 
Initialize the TensorFlowInferenceInterface.
```
private static final String MODEL_PATH = "file:///android_asset/mnist_optimized.pb";
c.inferenceInterface = new TensorFlowInferenceInterface(assetManager, modelpath);
```
# Step 2 { Code — Model Definitions } 
The names of the input and output for the model come from our mnist.py training script
```

private static final String INPUT_NAME = "input";
private static final String OUTPUT_NAME = "output";
```
- To figure out the names of your input and output nodes is to import your TensorFlow model into TensorBoard and inspect it there.
# Step 3 {Code — Running the Classifier via TensorFlowInferenceInterface}
We feed in the pixel data, run the classifier, then fetch the outputs.
Those outputs are then sorted to get the one with the highest confidence (above a specified threshold), and shown to the user

     ```
     - Copy the input data into TensorFlow.
     
    inferenceInterface.feed(inputName, pixels, new long[]{inputSize * inputSize});
  
    - Run the inference call.
    
    inferenceInterface.run(outputNames);
    
   - Copy the output Tensor back into the output array.
     
    inferenceInterface.fetch(outputName, outputs);
    
    - Find the best classifications.
    
    for (int i = 0; i < outputs.length; ++i) {
        <snip> 
    }
    ```


   


### Credits
- I have took the pre-trained and pre-optimized model from [nex3z](https://github.com/nex3z/tfmobile-mnist-android)
- The basic model architecture comes from [tensorflow-mnist-tutorial](https://github.com/martin-gorner/tensorflow-mnist-tutorial).
- The official TensorFlow Mobile [Android demo](https://github.com/tensorflow/tensorflow/tree/master/tensorflow/examples/android).
- The [FingerPaint](https://android.googlesource.com/platform/development/+/master/samples/ApiDemos/src/com/example/android/apis/graphics/FingerPaint.java) from Android API demo.
