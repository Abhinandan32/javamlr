package javamlr;

public class MultipleLinearRegression {
    public static void main(String[] args){
        Observation[] inputVectors = FileHandler.read("data/concrete.csv");
        
        // Fits the model predicting the feature compressivestrength using gradient descent. 
        double alpha = 0.0001;
        System.out.println("\n\nFitting model using gradient descent, alpha = " + alpha + " ...");
        System.out.println("*************************************************************************\n");
        Model gradientFit = Fit.gradientDescent(inputVectors, "compressivestrength", 0.0001);
        System.out.println(gradientFit.toString());
        
        // Fits the model predicting the feature compressivestrength using the normal equation method. 
        System.out.println("\n\nFitting model in using the normal equation method ...");
        System.out.println("*************************************************************************\n");
        Model normalFit = Fit.normalEquation(inputVectors, "compressivestrength");
        System.out.println(normalFit.toString());
        
        // Demonstrates the Model.predict() method, as well as the model fits, by predicting some arbitrary rows of the dataset. 
        System.out.println("\n\nPredicting some arbitrary rows using both models ...\n");
        double testValue = inputVectors[30].getFeature("compressivestrength");
        double predictionA = gradientFit.predict(inputVectors[30]);
        double predictionB = normalFit.predict(inputVectors[30]);
        System.out.println("Actual value: " + testValue + "\nPrediction using gradient descent: " + predictionA);
        System.out.println("Prediction using normal equation method: " + predictionB);
        testValue = inputVectors[40].getFeature("compressivestrength");
        predictionA = gradientFit.predict(inputVectors[40]);
        predictionB = normalFit.predict(inputVectors[40]);
        System.out.println("Actual value: " + testValue + "\nPrediction using gradient descent: " + predictionA);
        System.out.println("Prediction using normal equation method: " + predictionB);
        testValue = inputVectors[50].getFeature("compressivestrength");
        predictionA = gradientFit.predict(inputVectors[50]);
        predictionB = normalFit.predict(inputVectors[50]);
        System.out.println("Actual value: " + testValue + "\nPrediction using gradient descent: " + predictionA);
        System.out.println("Prediction using normal equation method: " + predictionB);
    }
}
