# Multiple linear regression in Java 
Implementation of multiple linear regression in Java for continuous data, fitting the parameters
both using gradient descent and the closed-form normal equation method. Developed from scratch, excluding the use of the *Apache Commons Math*  
library for matrix operations. 

Data source: [*Concrete compressive strength*](http://archive.ics.uci.edu/ml/datasets/Concrete+Compressive+Strength), UCI Machine Learning Repository

The model is fit in the class ```Fit```, predicting the feature specified by the ```dependent``` parameter using all other features, in one of two methods:
* ```Fit.gradientDescent```, which fits the parameters using batch gradient descent with a learning rate
specified by the ```alpha``` parameter. To speed up convergence, helper methods are used to standardise data. 
* ```Fit.normalEquation```, which fits the parameters in closed form using the normal equation method. 
Matrix operations are done using the *Apache Commons Math* library. As expected, this is dramatically
faster than gradient descent over the sample data. 

Once the model is fit, a ```Model``` object is returned. The intercept and parameters are stored as key-value 
pairs and the R-squared value and name of the dependent variable are accessible as public fields. 
The method ```predict()``` takes an Observation object with dimensions matching the training data and 
returns a prediction for the dependent variable, while ```toString()``` gives the R-squared value and 
parameters.

In the main method of ```javamlr.MultipleLinearRegression```, a model is fit on our sample data using both methods to demonstrate the similarity of their fit and the difference in speed. To demonstrate the ```Model.predict()``` method, some arbitrary rows of the dataset are then predicted. 

### Instructions 
* From the root directory, compile with: ```javac -classpath lib/* -d . src/*.java```
* The main program can then be executed from the root directory using: ```java -classpath .:lib/* javamlr.MultipleLinearRegression``` (for Windows, replace ```.:lib/*``` with ```.;lib/*```)
